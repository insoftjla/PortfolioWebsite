package sd.app.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "title")
@Table(name = "projects")
public class Project extends BaseEntity{

    private String title;

    @Column(columnDefinition = "TEXT")
    private String about;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "project_image",
    joinColumns = @JoinColumn(name = "project_id"),
    inverseJoinColumns = @JoinColumn(name = "image_id"))
    private Set<Image> images = new HashSet<>();

}
