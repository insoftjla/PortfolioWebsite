package sd.app.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author Sergey Inyakin
 */


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "email", callSuper = false)
@Table(name = "users_data")
public class User extends BaseEntity{

    @NotBlank(message = "Username may not be blank")
    @Pattern(regexp = "^(\\w{5,20})$", message = "Does not match the pattern (5-20 \\w)")
    private String username;

    @NotBlank(message = "Password may not be blank")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d\\S]{8,}$", message = "Does not match the pattern")
    private String password;

    @NotBlank(message = "Email may not be blank")
    private String email;

    @NotBlank(message = "Firstname may not be blank")
    private String firstname;

    @NotBlank(message = "Lastname may not be blank")
    private String lastname;

    private String patronymic;

    @NotBlank(message = "Age may not be blank")
    private String age;

    @Enumerated(EnumType.STRING)
    private Sex sex = Sex.MALE;

    @NotBlank(message = "Phone may not be blank")
    private String phone;
}
