package sd.app.sevices;

import sd.app.model.User;

import java.util.Optional;

/**
 * @author Sergey Inyakin
 */

public interface UserService {
    Optional<User> get(long id);
    User save(User user);
}
