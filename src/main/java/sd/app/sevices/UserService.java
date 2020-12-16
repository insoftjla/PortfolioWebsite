package sd.app.sevices;

import sd.app.model.User;

import java.util.Optional;

/**
 * @author Sergey Inyakin
 */

public interface UserService {
    Optional<User> findById(long id);
    Optional<User> findByUsername(String username);
    User save(User user);
    User addUser(User user);
}
