package kz.baribir.scipitor.service;

import kz.baribir.scipitor.model.dto.UserDTO;
import kz.baribir.scipitor.model.entity.User;
import kz.baribir.scipitor.repository.postgre.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());  // TODO hash
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {

        User user = userRepository.findByUsername(username);

        if (user == null) {
            return null;
        }

        return user;
    }

    @Override
    public User findById(Long id) {

        return userRepository.findById(id).get();
    }

    @Override
    public User updateUser(Long id, UserDTO userDTO) {
        User user = findById(id);
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword()); // Обновление пароля TODO hash
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = findById(id);
        userRepository.delete(user);
    }
}
