package yokudlela.market.service;

import yokudlela.market.model.Consumer;
import yokudlela.market.model.Product;
import yokudlela.market.model.Supplier;
import yokudlela.market.model.SupplierProduct;

import java.util.List;
import java.util.concurrent.ScheduledFuture;

public interface MarketService {
    void createConsumer(Consumer consumer);
    void createSupplier(Supplier supplier);
    void createProduct(Product product);
    void addConsumerToProduct(Long productId, Long consumerId);
    List<SupplierProduct> getSupplierProductsByConsumerId(Long consumerId);
    void orderProductBySupplierProductId(Long consumerId, Long supplierProductId, double quantity);
    void restockProduct(Long supplierProductId, double quantity);
}
