package kz.baribir.scipitor.service;

import kz.baribir.scipitor.model.dto.LoginRequest;
import kz.baribir.scipitor.model.dto.UserDTO;
import kz.baribir.scipitor.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private UserService userService;

    @Override
    public boolean login(LoginRequest loginRequest) {
        User user = userService.findByUsername(loginRequest.getUsername());
        if (user == null) {
            return false;
        }

        return true;
    }

    private boolean checkPassword(User user, String password) {
        return  user.getPassword().equals(password);
    }

    @Override
    public boolean register(UserDTO userDTO) {
        userService.save(userDTO);
        return true;
    }
}
