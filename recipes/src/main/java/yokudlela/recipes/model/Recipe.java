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
@NoArgsConstructor
@Table(name = "recipe")
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Recept neve")
    private String name;

    @Schema(description = "Összetevők")
    @ManyToMany
    private List<Ingredient> ingredients;

    @Schema(description = "Mely ételeket készítik a recept alapján")
    @ManyToMany
    private List<MenuItem> menuItems;
}
