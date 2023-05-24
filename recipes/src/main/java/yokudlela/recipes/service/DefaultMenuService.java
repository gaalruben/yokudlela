package yokudlela.recipes.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yokudlela.recipes.model.*;
import yokudlela.recipes.persistence.*;

import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Getter
@Setter
@Service
@Transactional
public class DefaultMenuService implements MenuService{

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    MenuItemRepository menuItemRepository;

    @Autowired
    MenuGroupRepository menuGroupRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    RecipeRepository recipeRepository;

    @Override
    public List<Product> getLowQuantityProducts(double quantity, Unit unit) {
        List<Product> lowQuantityProducts = StreamSupport
                .stream(productRepository.findAll().spliterator(), false).filter(product -> product.getUnit() == unit &&
                        product.getQuantity() < quantity).collect(Collectors.toList());
        return lowQuantityProducts;
    }

    @Override
    public List<Recipe> getRecipesWithEnoughResources() {
        List<Recipe> recipes = StreamSupport.stream(recipeRepository.findAll().spliterator(), false).filter(recipe ->
                recipe.getIngredients().stream().allMatch(i -> i.getQuantity() <= i.getProduct().getQuantity())).collect(Collectors.toList());
        return recipes;
    }

    @Override
    public List<Recipe> getRecipesWithNotEnoughResources() {
        List<Recipe> recipes = StreamSupport.stream(recipeRepository.findAll().spliterator(), false).filter(
                Predicate.not(recipe -> recipe.getIngredients().stream().allMatch(i -> i.getQuantity() <= i.getProduct().getQuantity())))
                .collect(Collectors.toList());
        return recipes;
    }

    @Override
    public List<Menu> getMenusByGroupId(Long groupId) {
        List<Menu> menus = StreamSupport.stream(menuRepository.findAll().spliterator(), false).filter(menu -> menu.getGroup().getId().equals(groupId)).collect(Collectors.toList());
        return menus;
    }

    @Override
    public List<Menu> getMenusByDayOfWeek(DayOfWeek dayOfWeek) {
        List<Menu> menus = StreamSupport.stream(menuRepository.findAll().spliterator(), false).filter(menu -> menu.getDayAvailable().equals(dayOfWeek)).collect(Collectors.toList());
        return menus;
    }

    @Override
    public MenuItem getMostFrequentlyOrderedMenuItem() {
       MenuItem menuItem =  StreamSupport.stream(menuItemRepository.findAll().spliterator(), false).max(Comparator.comparing(bh -> bh.getTimesOrdered())).get();
       return menuItem;
    }

    @Override
    public void createRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void createMenuItem(MenuItem menuItem) {
        menuItemRepository.save(menuItem);
    }

    @Override
    public void createMenuGroup(MenuGroup menuGroup) {
        menuGroupRepository.save(menuGroup);
    }

    @Override
    public void createMenu(Menu menu) {
        menuRepository.save(menu);
    }
}
