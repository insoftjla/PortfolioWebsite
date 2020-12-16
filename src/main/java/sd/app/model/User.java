package sd.app.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;
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
@EqualsAndHashCode(of = "email", callSuper = false)
@Table(name = "users_data")
public class User extends BaseEntity {

    @Pattern(regexp = "^(\\w{5,20})$", message = "Does not match the pattern (5-20 \\w)")
    private String username;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d\\S]{8,}$", message = "Does not match the pattern")
    private String password;

    private String email;

    private String firstname;

    private String lastname;

    private String patronymic;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @Enumerated(EnumType.STRING)
    private Sex sex = Sex.MALE;

    private String phone;

    private String profession;

    private String website;

    private String about;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_skill",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<Skill> skills = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_main_skills",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<Skill> mainSkills = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_project",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    private Set<Project> projects = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public void addSkill(Skill skill) {
        skills.add(skill);
        skill.getUsers().add(this);
    }

    public void removeSkill(Skill skill) {
        skills.remove(skill);
        skill.getUsers().remove(this);
    }

    public int getAge() {
        if (birthday == null) return 0;
        LocalDate birthDate = birthday.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        LocalDate nowDate = LocalDate.now();
        return Period.between(birthDate, nowDate).getYears();
    }
}
