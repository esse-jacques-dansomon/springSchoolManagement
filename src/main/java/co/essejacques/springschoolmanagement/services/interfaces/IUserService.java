package co.essejacques.springschoolmanagement.services.interfaces;

import co.essejacques.springschoolmanagement.data.entity.User;

import java.util.Optional;

public interface IUserService {
    User createUser(User user);
    User updateUser(User user);
    void deleteUser(Long userId);
    User findUserById(Long id);
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByEmailAndPassword(String email, String password);
}
