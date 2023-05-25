package yokudlela.market.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "consumer_product")
@Schema(description = "Fogyasztó és termék kapcsolat")
@Entity
public class ConsumerProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonManagedReference
    private Consumer consumer;

    @ManyToOne
    @JsonManagedReference
    private Product product;
}
