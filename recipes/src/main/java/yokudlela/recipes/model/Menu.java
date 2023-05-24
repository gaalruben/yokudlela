package yokudlela.recipes.model;

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
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "menu")
    MenuGroup group;
    DayOfWeek dayAvailable;
    int price;

    @OneToMany(mappedBy = "menu")
    List<MenuItem> menuItems;

    public Menu(){
        menuItems = new ArrayList<>();
    }
}
