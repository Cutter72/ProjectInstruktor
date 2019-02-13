package pl.project.instruktor.service;

import pl.project.instruktor.model.User;

public interface UserService {
    User findByUserName(String name);

    void saveUser(User user);
}
