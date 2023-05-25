package yokudlela.market.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "supplier_product")
@Schema(description = "Adott beszállítóhoz tartozó termék, ára és mennyisége")
@Entity
public class SupplierProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Beszállítónál lévő mennyiség")
    private double quantity;

    @Schema(description = "Ár")
    private int price;

    @ManyToOne
    @JsonManagedReference
    private Supplier supplier;

    @ManyToOne
    @JsonManagedReference
    private Product product;
}
