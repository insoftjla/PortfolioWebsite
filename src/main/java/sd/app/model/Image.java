package sd.app.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "title")
@Table(name = "images")
public class Image extends BaseEntity{

    private String title;

    private String url;
}
