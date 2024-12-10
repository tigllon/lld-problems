package org.leetcodelikeplatform.services;

import lombok.AllArgsConstructor;
import org.leetcodelikeplatform.entities.User;
import org.leetcodelikeplatform.repositories.UserRepository;

@AllArgsConstructor
public class UserManagementService {
    private UserRepository userRepository;

    public void createUser(String name) {
        User user = new User(name);
        userRepository.add(user);
    }

    public User getUser(String name) {
        return userRepository.get(name);
    }
}
