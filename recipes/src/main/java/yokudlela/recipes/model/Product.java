package yokudlela.recipes.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@EqualsAndHashCode
@Builder
@Getter
@Setter
@AllArgsConstructor
@Table(name = "product")
@Schema(description = "Termék")
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
