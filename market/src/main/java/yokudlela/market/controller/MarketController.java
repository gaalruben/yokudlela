package yokudlela.market.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import yokudlela.market.model.SupplierProduct;
import yokudlela.market.service.MarketService;

import java.util.List;

@RestController
@RequestMapping(path = "/market")
public class MarketController {
    @Autowired
    MarketService marketService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sikeres hozzáadás",
            content = { @Content(mediaType = "application/json")})
    })
    @Operation(summary = "Partnerhez termék felvitele pl. consumerId = 100, productId = 207.")
    @PostMapping(path = "/addConsumerToProduct", produces = MediaType.APPLICATION_JSON_VALUE)
    void addConsumerToProduct(
            @Parameter(description = "Termék azonosítója, amit fel szeretnénk venni a fogyasztóhoz.", required = true) @RequestParam(name = "productId", required = true)Long productId,
            @Parameter(description = "Fogyasztó azonosítója", required = true) @RequestParam(name = "consumerId", required = true)Long consumerId
    ){
        marketService.addConsumerToProduct(productId, consumerId);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sikeres lekérdezés",
            content = { @Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = SupplierProduct.class))) }),
    })
    @Operation(summary = "Fogyasztói azonosító alapján lekérdezi, hogy melyik Supplier-nél milyen készlet milyen áron érhető el. pl. consumerId = 100")
    @GetMapping(path = "/getSupplierProductsByConsumerId", produces = MediaType.APPLICATION_JSON_VALUE)
    List<SupplierProduct> getSupplierProductsByConsumerId(
            @Parameter(description = "Fogyasztó azonosítója", required = true) @RequestParam(name = "consumerId", required = true)Long consumerId){
            return marketService.getSupplierProductsByConsumerId(consumerId);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sikeres megrendelés",
            content = { @Content(mediaType = "application/json")})
    })
    @Operation(summary = "Fogyasztóként termék megrendelése beszállítótól pl. consumerId = 100, supplierProductId = 500.")
    @PostMapping(path = "/orderProductBySupplierProductId", produces = MediaType.APPLICATION_JSON_VALUE)
    void orderProductBySupplierProductId(
            @Parameter(description = "Fogyasztó azonosítója, aki rendelni szeretne", required = true) @RequestParam(name = "consumerId", required = true)Long consumerId,
            @Parameter(description = "Beszállító termék azonosítója, amit rendelni szeretnénk", required = true) @RequestParam(name = "supplierProductId", required = true)Long supplierProductId,
            @Parameter(description = "Rendelni kívánt mennyiség", required = true) @RequestParam(name = "quantity", required = true)double quantity){
        marketService.orderProductBySupplierProductId(consumerId, supplierProductId, quantity);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sikeres készletfeltöltés",
            content = { @Content(mediaType = "application/json")})
    })
    @Operation(summary = "Beszállítóhoz meglévő termék készletfeltöltése pl. supplierProductId = 500")
    @PostMapping(path = "/restockProduct", produces = MediaType.APPLICATION_JSON_VALUE)
    void restockProduct(
            @Parameter(description = "Beszállító termék azonosítója", required = true) @RequestParam(name = "supplierProductId", required = true)Long supplierProductId,
            @Parameter(description = "Feltölteni kívánt mennyiség", required = true) @RequestParam(name = "quantity", required = true)double quantity){
            marketService.restockProduct(supplierProductId, quantity);
    }

}