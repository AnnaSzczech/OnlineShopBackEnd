package team.java.auction.house.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.java.auction.house.domain.UserEntity;
import team.java.auction.house.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    public void deleteUser(UserEntity user) {
        userRepository.delete(user);
    }
}