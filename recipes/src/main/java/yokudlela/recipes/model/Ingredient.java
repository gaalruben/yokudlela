package yokudlela.recipes.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode
@Builder
@Getter
@Setter
@AllArgsConstructor
@Table(name = "ingredient")
@Schema(description = "Hozzávalók")
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
}
