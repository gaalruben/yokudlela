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
import yokudlela.market.controller.client.RecipeControllerService;
import yokudlela.market.model.*;
import yokudlela.market.service.MarketService;
import yokudlela.recipe.java.clients.api.MenuControllerApi;
import yokudlela.recipe.java.clients.invoker.ApiClient;
import yokudlela.recipe.java.clients.invoker.ApiException;
import yokudlela.recipe.java.clients.invoker.Configuration;
import yokudlela.recipe.java.clients.model.Recipe;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.util.List;

@RestController
@RequestMapping(path = "/market")
public class MarketController {
    @Autowired
    MarketService marketService;

    @Autowired
    RecipeControllerService menuControllerService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sikeres lekérdezés",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Recipe.class))) }),
    })
    @Operation(summary = "MENÜ APIból hívva: Azon receptek lekérdezése, amelyekhez NINCS elegendő alapanyag raktáron.")
    @GetMapping(value = "/getRecipesWithNotEnoughResources", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Recipe> getRecipesWithNotEnoughResources(HttpServletRequest request) throws ApiException, MalformedURLException {
        MenuControllerApi api = menuControllerService.getClientInstance();
        //api.getApiClient().setBasePath("http://recipe:8080/recipe");

        System.out.println("----- /getRecipesWithNotEnoughResources CALLED -----");
        System.out.println("----- BasePath: " + api.getApiClient().getBasePath()  + "-----");

        List<Recipe> recipes = api.getRecipesWithNotEnoughResources();
        return recipes;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sikeres lekérdezés",
            content = { @Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = yokudlela.recipe.java.clients.model.Product.class))) }),
    })
    @Operation(summary = "MENÜ APIból hívva: Azon termékek lekérdezése, amelyekből a megadott mennyiségnél kevesebb van raktáron.")
    @GetMapping(value = "/getLowQuantityProducts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<yokudlela.recipe.java.clients.model.Product> getLowQuantityProducts(
            @Parameter(description = "Maximális mennyiség", required = true) @RequestParam(name = "quantity", required = true)double quantity,
            @Parameter(description = "Mértékegység", required = true) @RequestParam(name = "unit", required = true)String unit) throws ApiException, MalformedURLException {
        MenuControllerApi api = menuControllerService.getClientInstance();

        System.out.println("----- /getLowQuantityProducts CALLED -----");
        System.out.println("----- BasePath: " + api.getApiClient().getBasePath()  + "-----");

        List<yokudlela.recipe.java.clients.model.Product> products = api.getLowQuantityProducts(quantity, unit);
        return products;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sikeres hozzáadás",
            content = { @Content(mediaType = "application/json")})
    })
    @Operation(summary = "Partnerhez termék felvitele pl. productId = 207, consumerId = 100 .")
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

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sikeres felvitel",
            content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = Product.class)) })
    })
    @Operation(summary = "Új termék felvitele")
    @PostMapping(path = "/add/product", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product addProduct(@Parameter(description = "Az új termék mértékegysége",required = true)@RequestParam(required = true) String unit){
        Product p = Product.builder().unit(Unit.valueOf(unit)).build();
        marketService.createProduct(p);
        return p;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sikeres felvitel",
            content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = Consumer.class)) })
    })
    @Operation(summary = "Új partner felvitele")
    @PostMapping(path = "/add/consumer", produces = MediaType.APPLICATION_JSON_VALUE)
    public Consumer addConsumer(@Parameter(description = "Partner neve",required = true) @RequestParam(required = true) String name,
                                @Parameter(description = "Partner elérhetősége",required = true) @RequestParam(required = true) String contact){
        Consumer consumer = Consumer.builder().name(name).contact(name).build();
        marketService.createConsumer(consumer);
        return consumer;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sikeres felvitel",
            content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = Supplier.class)) })
    })
    @Operation(summary = "Új beszállító felvitele")
    @PostMapping(path = "/add/supplier", produces = MediaType.APPLICATION_JSON_VALUE)
    public Supplier addSupplier(@Parameter(description = "Az új partner",required = true) @RequestParam(required = true) String name,
                                @Parameter(description = "Az új partner",required = true) @RequestParam(required = true) String contact){
        Supplier s = Supplier.builder().name(name).contact(contact).build();
        marketService.createSupplier(s);
        return s;
    }

}
