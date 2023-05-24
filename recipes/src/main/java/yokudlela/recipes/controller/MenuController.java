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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    @Operation(summary = "Azon termékek lekérdezése, amelyek a megadott mértékegységet használják és a paraméterként átadott mennyiségnél kevesebb van belőlük raktáron.")
    @GetMapping(path = "/getLowQuantityProducts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getLowQuantityProducts(
            @Parameter(description = "Maximális mennyiség", required = true) @RequestParam(name = "quantity", required = true)double quantity,
            @Parameter(description = "Mértékegység", required = true) @RequestParam(name = "unit", required = true)String unit){
        return menuService.getLowQuantityProducts(quantity, Unit.valueOf(unit));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sikeres lekérdezés",
            content = { @Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = Recipe.class))) }),
    })
    @Operation(summary = "Azon receptek lekérdezése, amelyekhez VAN elegendő alapanyag raktáron.")
    @GetMapping(path = "/getRecipesWithEnoughResources", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Recipe> getRecipesWithEnoughResources() {
        return menuService.getRecipesWithEnoughResources();
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sikeres lekérdezés",
            content = { @Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = Recipe.class))) }),
    })
    @Operation(summary = "Azon receptek lekérdezése, amelyekhez NINCS elegendő alapanyag raktáron.")
    @GetMapping(path = "/getRecipesWithNotEnoughResources", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Recipe> getRecipesWithNotEnoughResources(){
        return menuService.getRecipesWithNotEnoughResources();
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sikeres lekérdezés",
            content = { @Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = Menu.class))) }),
    })
    @Operation(summary = "Azon menük lekérdezése, amelyek a paraméterként átadott csoportazonosítóval rendelkeznek.")
    @GetMapping(path = "/getMenusByGroupId", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Menu> getMenusByGroupId(
            @Parameter(description = "Csoportazonosító", required = true) @RequestParam(name = "groupId", required = true)Long groupId) {
        return getMenusByGroupId(groupId);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sikeres lekérdezés",
            content = { @Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = Menu.class))) }),
    })
    @Operation(summary = "Azon menük lekérdezése, amelyek a paraméterként átadott napon (a hét napjai közül) elérhetőek.")
    @GetMapping(path = "/getMenusByDayOfWeek", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Menu> getMenusByDayOfWeek(
            @Parameter(description = "A hét egy napja angolul", required = true) @RequestParam(name = "groupId", required = true)String dayOfWeek){
        return menuService.getMenusByDayOfWeek(DayOfWeek.valueOf(dayOfWeek));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sikeres lekérdezés",
            content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = Menu.class)) }),
    })
    @Operation(summary = "Legtöbbször rendelt étel lekérdezése.")
    @GetMapping(path = "/getMenusByDayOfWeek", produces = MediaType.APPLICATION_JSON_VALUE)
    public MenuItem getMostFrequentlyOrderedMenuItem(){
        return menuService.getMostFrequentlyOrderedMenuItem();
    }
}
