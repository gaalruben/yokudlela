package yokudlela.recipes.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "menu")
@Schema(description = "Menü")
@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name;

    @ManyToOne
    @Schema(description = "Menü csoportja")
    MenuGroup group;

    @Schema(description = "A hét mely napján elérhető")
    DayOfWeek dayAvailable;

    @Schema(description = "Ételek")
    @ManyToMany
    List<MenuItem> menuItems;
}
