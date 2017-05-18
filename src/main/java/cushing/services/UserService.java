package cushing.services;


import cushing.models.entity.User;
import org.jetbrains.annotations.NotNull;

/**
 * @author Roman Nagibov
 */
public interface UserService {

    void save(@NotNull User user);

}
