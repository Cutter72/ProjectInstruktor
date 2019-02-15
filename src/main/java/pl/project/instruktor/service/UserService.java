package pl.project.instruktor.service;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import pl.project.instruktor.model.CurrentUser;
import pl.project.instruktor.model.User;

import javax.validation.Valid;

public interface UserService {
    User findByUserName(String name);

    void saveUser(User user);

    void updateUser(@AuthenticationPrincipal CurrentUser customUser, @Valid User user);
}
