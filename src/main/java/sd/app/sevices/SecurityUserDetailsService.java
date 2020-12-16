package sd.app.sevices;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sd.app.model.SecurityUserPrincipal;
import sd.app.model.User;
import sd.app.repositoryes.UserRepository;

/**
 * @author Sergey Inyakin
 */

@Service
@AllArgsConstructor
public class SecurityUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(s);
        if (user == null) throw new UsernameNotFoundException("User not found");

        return new SecurityUserPrincipal(user);
    }
}
