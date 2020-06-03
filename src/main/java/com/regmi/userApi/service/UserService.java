package com.regmi.userApi.service;

import com.regmi.userApi.util.UserEntity;

public interface UserService {
    public UserEntity getUserById(int id);

    public void saveUser(UserEntity user);

    public void deleteUser(int id);
}
