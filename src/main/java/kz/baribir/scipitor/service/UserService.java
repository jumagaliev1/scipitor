package kz.baribir.scipitor.service;

import kz.baribir.scipitor.model.dto.UserDTO;
import kz.baribir.scipitor.model.entity.User;

public interface UserService {

    User save(UserDTO userDTO);
    User findByUsername(String username);
    User findById(Long id);
    User updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);

}
