package yokudlela.recipes.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
@Schema(description = "Termék")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Termék neve")
    private String name;

    @Schema(description = "Raktáron lévő mennyiség")
    private double quantity;

    @Schema(description = "Mértékegység")
    private Unit unit;
}
