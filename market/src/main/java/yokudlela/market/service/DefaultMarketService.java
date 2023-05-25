package yokudlela.market.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yokudlela.market.model.*;
import yokudlela.market.persistence.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Getter
@Setter
@Service
@Transactional
public class DefaultMarketService implements  MarketService{
    @Autowired
    ConsumerRepository consumerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    SupplierProductRepository supplierProductRepository;

    @Autowired
    ConsumerProductRepository consumerProductRepository;

    @Override
    public void createConsumer(Consumer consumer) {
        consumerRepository.save(consumer);
    }

    @Override
    public void createSupplier(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void addConsumerToProduct(Long productId, Long consumerId) {
        Product product = StreamSupport.stream(productRepository.findAll().spliterator(), false)
                .filter(pr -> pr.getId().equals(productId)).findFirst().get();

        Consumer consumer = StreamSupport.stream(consumerRepository.findAll().spliterator(), false)
                .filter(c -> c.getId().equals(consumerId)).findFirst().get();

        ConsumerProduct cp = ConsumerProduct.builder().product(product).consumer(consumer).build();
        consumerProductRepository.save(cp);

        consumer.getProducts().add(cp);
        consumerRepository.save(consumer);
    }

    @Override
    public List<SupplierProduct> getSupplierProductsByConsumerId(Long consumerId) {

        List<ConsumerProduct> consumerProducts = StreamSupport.stream(consumerRepository.findAll().spliterator(), false)
                .filter(c -> c.getId().equals(consumerId)).findFirst().get().getProducts();
        List<Long> productIds = new ArrayList<>();

        for (ConsumerProduct cp: consumerProducts) {
            productIds.add(cp.getProduct().getId());
        }

        List<SupplierProduct> supplierProducts = StreamSupport.stream(supplierProductRepository.findAll().spliterator(), false)
                .filter(sp -> productIds.contains(sp.getProduct().getId())).collect(Collectors.toList());

        return supplierProducts;
    }

    @Override
    public void orderProductBySupplierProductId(Long consumerId, Long supplierProductId, double quantity) {
        Consumer consumer = StreamSupport.stream(consumerRepository.findAll().spliterator(), false)
                .filter(c -> c.getId().equals(consumerId)).findFirst().get();

        SupplierProduct supplierProduct = StreamSupport.stream(supplierProductRepository.findAll().spliterator(), false)
                .filter(sp -> sp.getId().equals(supplierProductId)).findFirst().get();

        double newQuantity = supplierProduct.getQuantity() - quantity;

        supplierProduct.setQuantity(newQuantity);
        supplierProductRepository.save(supplierProduct);
    }

    @Override
    public void restockProduct(Long supplierProductId, double quantity) {
        SupplierProduct supplierProduct = StreamSupport.stream(supplierProductRepository.findAll().spliterator(), false)
                .filter(sp -> sp.getId().equals(supplierProductId)).findFirst().get();

        double newQuantity = supplierProduct.getQuantity() + quantity;
        supplierProduct.setQuantity(newQuantity);
    }
}
