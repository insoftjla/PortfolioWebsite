package sd.app.sevices;

import sd.app.model.User;

/**
 * @author Sergey Inyakin
 */

public interface UserService {
    User get(long id);
    User save(User user);
}
