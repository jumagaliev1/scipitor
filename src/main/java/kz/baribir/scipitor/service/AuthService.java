package kz.baribir.scipitor.service;

import kz.baribir.scipitor.model.dto.LoginRequest;
import kz.baribir.scipitor.model.dto.UserDTO;

public interface AuthService {

    boolean login(LoginRequest loginRequest);
    boolean register(UserDTO userDTO);
}


