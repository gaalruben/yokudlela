package yokudlela.recipes.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Builder
@Getter
@Setter
@AllArgsConstructor
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Recept neve")
    private String name;

    @Schema(description = "Összetevők")
    @OneToMany(mappedBy = "recipe")
    private List<Ingredient> ingredients;

    @Schema(description = "Mely ételeket készítik a recept alapján")
    @OneToMany(mappedBy = "recipe")
    private List<MenuItem> menuItems;

    public Recipe(){
        ingredients = new ArrayList<>();
        menuItems = new ArrayList<>();
    }
}
