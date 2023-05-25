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
@Table(name = "consumer")
@Schema(description = "Fogyasztó")
@Entity
public class Consumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Fogyasztó neve")
    private String name;

    @Schema(description = "Fogyasztó elérhetősége (e-mail cím)")
    private String contact;

    @OneToMany
    @JsonBackReference
    private List<ConsumerProduct> products;
}
