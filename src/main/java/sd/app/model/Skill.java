package sd.app.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Sergey Inyakin
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "title", callSuper = false)
@Table(name = "skills")
public class Skill extends BaseEntity{

    @NotBlank(message = "Title may not be blank")
    private String title;

    @ManyToMany(mappedBy = "skills")
    private Set<User> users = new HashSet<>();

}
