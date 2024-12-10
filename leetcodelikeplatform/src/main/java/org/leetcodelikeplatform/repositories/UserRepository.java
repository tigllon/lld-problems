package org.leetcodelikeplatform.repositories;

import org.leetcodelikeplatform.entities.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class UserRepository {
    private final HashMap < String,User> users;

    public UserRepository () {
        this.users = new HashMap<>();
    }
    public void add(User user) {
        users.put(user.getName(),user);
    }

    public User get(String name) {
        return users.get(name);
    }

    public List< User> get() {
        return new ArrayList<>(users.values());
    }
}
