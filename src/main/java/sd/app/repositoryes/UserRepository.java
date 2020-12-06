package sd.app.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sd.app.model.User;

/**
 * @author Sergey Inyakin
 */

public interface UserRepository extends JpaRepository<User, Long> {
}
