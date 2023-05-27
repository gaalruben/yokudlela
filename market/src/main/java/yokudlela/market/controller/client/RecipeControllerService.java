package yokudlela.market.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import yokudlela.recipe.java.clients.invoker.auth.ApiKeyAuth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import yokudlela.recipe.java.clients.api.MenuControllerApi;

import java.net.MalformedURLException;
import java.net.URL;

@Service
@Configuration
public class RecipeControllerService {

    @Value("http://recipe:8080/recipe")
    private String path;

    public MenuControllerApi getClientInstance() throws MalformedURLException {
        MenuControllerApi api = new MenuControllerApi();
        URL url = new URL("http", "recipe", 8080, "recipe");
        api.getApiClient().setBasePath(path);
        return new MenuControllerApi();
    }
}
