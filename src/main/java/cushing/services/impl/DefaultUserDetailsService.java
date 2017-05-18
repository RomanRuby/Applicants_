package cushing.services.impl;


import cushing.models.entity.User;
import cushing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Roman Nagibov
 */
@Service
@Transactional(readOnly = true)
public class DefaultUserDetailsService implements UserDetailsService {

    @Autowired private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (null == user) {
            throw new UsernameNotFoundException(String.format("User with username %s not found", username));
        }

        return user;

    }

}
