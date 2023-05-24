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
@Table(name = "menu")
@Schema(description = "Menü")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "menu")
    @Schema(description = "Menü csoportja")
    MenuGroup group;

    @Schema(description = "A hét mely napján elérhető")
    DayOfWeek dayAvailable;

    @Schema(description = "Ár")
    int price;

    @Schema(description = "Ételek")
    @OneToMany(mappedBy = "menu")
    List<MenuItem> menuItems;

    public Menu(){
        menuItems = new ArrayList<>();
    }
}
