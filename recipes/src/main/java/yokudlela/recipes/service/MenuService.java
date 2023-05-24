package yokudlela.recipes.service;

import yokudlela.recipes.model.*;

import java.time.DayOfWeek;
import java.util.List;

public interface MenuService {
    List<Product> getLowQuantityProducts(double quantity, Unit unit);
    List<Recipe> getRecipesWithEnoughResources();
    List<Recipe> getRecipesWithNotEnoughResources();
    List<Menu> getMenusByGroupId(Long groupId);
    List<Menu> getMenusByDayOfWeek(DayOfWeek dayOfWeek);
    MenuItem getMostFrequentlyOrderedMenuItem();

    void createRecipe(Recipe recipe);
    void createProduct(Product product);
    void createMenuItem(MenuItem menuItem);
    void createMenuGroup(MenuGroup menuGroup);
    void createMenu(Menu menu);

}
