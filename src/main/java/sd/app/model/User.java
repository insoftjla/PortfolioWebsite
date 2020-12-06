package sd.app.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @NotBlank(message = "Birthday may not be blank")
    private Date birthday;

    @Enumerated(EnumType.STRING)
    private Sex sex = Sex.MALE;

    @NotBlank(message = "Phone may not be blank")
    private String phone;

    @NotBlank(message = "Profession may not be blank")
    private String profession;

    @NotBlank(message = "Website may not be blank")
    private String website;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_skill",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<Skill> skills = new HashSet<>();

    public void addSkill(Skill skill){
        skills.add(skill);
        skill.getUsers().add(this);
    }

    public void removeSkill(Skill skill){
        skills.remove(skill);
        skill.getUsers().remove(this);
    }

    public int getAge(){
        LocalDate birthDate = birthday.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        LocalDate nowDate = LocalDate.now();
        return Period.between(birthDate, nowDate).getYears();
    }
}
