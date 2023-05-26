package yokudlela.recipes.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yokudlela.recipes.model.*;
import yokudlela.recipes.service.MenuService;

import java.time.DayOfWeek;
import java.util.List;

@RestController
@RequestMapping(path = "/menu")
public class MenuController {
    @Autowired
    MenuService menuService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sikeres lekérdezés",
            content = { @Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = Product.class))) }),
    })
    @Operation(summary = "Azon termékek lekérdezése, amelyek a megadott mértékegységet (G, KG, PCS, L, ML) használják és a paraméterként átadott mennyiségnél (pl. 100) kevesebb van belőlük raktáron.")
    @GetMapping(path = "/getLowQuantityProducts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getLowQuantityProducts(
            @Parameter(description = "Maximális mennyiség", required = true) @RequestParam(name = "quantity", required = true)double quantity,
            @Parameter(description = "Mértékegység", required = true) @RequestParam(name = "unit", required = true)String unit){

        List<Product> products = menuService.getLowQuantityProducts(quantity, Unit.valueOf(unit));
        return  products;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sikeres lekérdezés",
            content = { @Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = Recipe.class))) }),
    })
    @Operation(summary = "Azon receptek lekérdezése, amelyekhez VAN elegendő alapanyag raktáron.")
    @GetMapping(path = "/getRecipesWithEnoughResources", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Recipe> getRecipesWithEnoughResources() {
        List<Recipe> recipes = menuService.getRecipesWithEnoughResources();
        return recipes;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sikeres lekérdezés",
            content = { @Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = Recipe.class))) }),
    })
    @Operation(summary = "Azon receptek lekérdezése, amelyekhez NINCS elegendő alapanyag raktáron.")
    @GetMapping(path = "/getRecipesWithNotEnoughResources", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Recipe> getRecipesWithNotEnoughResources(){
        List<Recipe> recipes = menuService.getRecipesWithNotEnoughResources();
        return recipes;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sikeres lekérdezés",
            content = { @Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = Menu.class))) }),
    })
    @Operation(summary = "Azon menük lekérdezése, amelyek a paraméterként átadott csoportazonosítóval rendelkeznek. (pl. 300, 303 stb)")
    @GetMapping(path = "/getMenusByGroupId", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Menu> getMenusByGroupId(
            @Parameter(description = "Csoportazonosító", required = true) @RequestParam(name = "groupId", required = true)Long groupId) {
        List<Menu> menus = menuService.getMenusByGroupId(groupId);
        return menus;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sikeres lekérdezés",
            content = { @Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = Menu.class))) }),
    })
    @Operation(summary = "Azon menük lekérdezése, amelyek a paraméterként átadott napon (a hét napjai közül) elérhetőek. pl. MONDAY")
    @GetMapping(path = "/getMenusByDayOfWeek", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Menu> getMenusByDayOfWeek(
            @Parameter(description = "A hét egy napja angolul", required = true) @RequestParam(name = "dayOfWeek", required = true)String dayOfWeek){

        List<Menu> menus = menuService.getMenusByDayOfWeek(DayOfWeek.valueOf(dayOfWeek));
        return menus;
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sikeres lekérdezés",
            content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = Menu.class)) }),
    })
    @Operation(summary = "Legtöbbször rendelt étel lekérdezése.")
    @GetMapping(path = "/getMostFrequentlyOrderedMenuItem", produces = MediaType.APPLICATION_JSON_VALUE)
    public MenuItem getMostFrequentlyOrderedMenuItem(){
        MenuItem menuItem = menuService.getMostFrequentlyOrderedMenuItem();
        return menuItem;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sikeres felvitel",
            content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = Product.class)) })
    })
    @Operation(summary = "Új termék felvitele")
    @PostMapping(path = "/addProduct", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product addConsumer(@Parameter(description = "Termék neve",required = true) @RequestParam(required = true) String name,
                                @Parameter(description = "Mennyiség",required = true) @RequestParam(required = true) double quantity,
                               @Parameter(description = "Mértékegység",required = true) @RequestParam(required = true) String unit){
        Product product = Product.builder().name(name).quantity(quantity).unit(Unit.valueOf(unit)).build();
        menuService.createProduct(product);
        return product;
    }
}
