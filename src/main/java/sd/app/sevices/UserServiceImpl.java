package sd.app.sevices;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sd.app.model.User;
import sd.app.repositoryes.UserRepository;

import java.util.Optional;

/**
 * @author Sergey Inyakin
 */

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public Optional<User> get(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
