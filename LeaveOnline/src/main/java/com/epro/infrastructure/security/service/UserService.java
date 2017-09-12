package com.epro.infrastructure.security.service;

import com.epro.infrastructure.security.entity.User;

public interface UserService {

    void changeUserPassword(User user, String password);

    boolean checkIfValidOldPassword(User user, String password);
    
    String genaratePasswordEncode(String rawPassword);

	boolean checkUserExistsByUsername(String username);

	User getUserByUsername(String username);

	void changeUserPasswordEncoded(User user, String passwordEncode);

	User getUserByUsernamePassword(String username, String password);

	boolean checkUserExistsByUsernamePassword(String username, String password);
}
