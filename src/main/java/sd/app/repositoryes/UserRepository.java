package sd.app.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sd.app.model.User;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * @author Sergey Inyakin
 */

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
}
