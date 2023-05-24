package yokudlela.recipes.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Builder
@Getter
@Setter
@AllArgsConstructor
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "recipe")
    private List<Product> ingredients;

    @OneToMany(mappedBy = "recipe")
    private List<MenuItem> menuItems;

    public Recipe(){
        ingredients = new ArrayList<>();
        menuItems = new ArrayList<>();
    }
}
