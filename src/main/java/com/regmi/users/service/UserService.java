package com.regmi.users.service;

import com.regmi.users.util.UserEntity;

public interface UserService {
    public UserEntity getUserById(int id);

    public void saveUser(UserEntity user);

    public void deleteUser(int id);

    UserEntity getUserByName(String name);
}
