package yokudlela.market.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "supplier")
@Schema(description = "Beszállító")
@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Beszállító neve")
    String name;

    @Schema(description = "Beszállító elérhetősége (e-mail cím)")
    private String contact;

    @OneToMany
    @JsonBackReference
    private List<SupplierProduct> products;
}
