package yokudlela.market.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import yokudlela.recipe.java.clients.api.MenuControllerApi;

@Service
public class RecipeControllerService {

    @Value("http://recipe:8080/recipe")
    private String path;

    public MenuControllerApi getClientInstance(){
        MenuControllerApi api = new MenuControllerApi();
        api.getApiClient().setBasePath(path);
        return new MenuControllerApi();
    }
}
