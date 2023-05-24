package yokudlela.recipes.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "menuItem")
@Schema(description = "Ételek")
@Entity
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Étel neve")
    String name;

    @Schema(description = "Hányszor rendelték az ételt")
    int timesOrdered;

    @Schema(description = "Ár")
    int price;

    @Schema(description = "Melyik receptből készült")
    @ManyToOne
    @JoinColumn(name = "recipe_id")
    Recipe recipe;

    @Schema(description = "Melyik menühöz tartozik")
    @ManyToOne
    private Menu menu;
}
