package sd.app.sevices;

import lombok.AllArgsConstructor;
import org.hibernate.HibernateException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import sd.app.model.Role;
import sd.app.model.User;
import sd.app.repositoryes.RoleRepository;
import sd.app.repositoryes.UserRepository;

import java.util.Optional;

/**
 * @author Sergey Inyakin
 */

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User addUser(User user) {

        User userFromDbUsername = userRepository.findByUsername(user.getUsername());
        User userFromDbEmail = userRepository.findByEmail(user.getEmail());

        if (userFromDbUsername != null || userFromDbEmail != null)
            throw new HibernateException("User with such username or email already exists");

        Role roleUser = roleRepository.findByName("ROLE_USER");
        if (roleUser != null)
            user.getRoles().add(roleUser);
        else throw new SecurityException("Role Not Found");

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }
}
