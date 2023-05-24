package yokudlela.recipes.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode
@Builder
@Getter
@Setter
@AllArgsConstructor
@Table(name = "menuItem")
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "menuItem_id")
    private Menu menu;
}
