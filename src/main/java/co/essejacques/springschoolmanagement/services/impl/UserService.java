package co.essejacques.springschoolmanagement.services.impl;

import co.essejacques.springschoolmanagement.data.entity.User;
import co.essejacques.springschoolmanagement.data.projections.UserDetailsProjection;
import co.essejacques.springschoolmanagement.data.repository.UserRepository;
import co.essejacques.springschoolmanagement.services.interfaces.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;

    /**
     * @param user
     * @return
     */
    @Override
    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    /**
     * @param user
     * @return
     */
    @Override
    public User updateUser(User user) {
        return this.userRepository.save(user);
    }

    /**
     * @param userId
     */
    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public User findUserById(Long id) {
        return this.userRepository.findById(id).orElseThrow();
    }

    /**
     * @param email
     * @return
     */
    @Override
    public Optional<User> findUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    /**
     * @param email
     * @param password
     * @return
     */
    @Override
    public Optional<User> findUserByEmailAndPassword(String email, String password) {
        return this.userRepository.findByEmailAndPassword(email, password);
    }

    /**
     * @param pageRequest
     * @return
     */
    @Override
    public Page<UserDetailsProjection> getAll(PageRequest pageRequest) {
        return this.userRepository.findPagedProjectedBy(pageRequest);
    }

    @Override
    public Optional<UserDetailsProjection> findUserProjectedByEmail(String email) {
        return this.userRepository.findProjectedByEmail(email);
    }
}
