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
@Table(name = "ingredient")
@Schema(description = "Hozzávalók")
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @Schema(description = "Termék")
    private Product product;

    @Schema(description = "Mennyiség")
    private double quantity;

    @ManyToMany
    private List<Recipe> recipes;
}
