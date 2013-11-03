package com.koushik.javabrains.service;

import com.koushik.javabrains.dao.UserDao;
import com.koushik.javabrains.entity.UserEntity;
import com.koushik.javabrains.model.UserModel;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: venkatakrishnachaita
 * Date: 10/13/13
 * Time: 5:38 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {
    UserDao getUserDao();

    void setUserDao(UserDao userDao);

    void insert(UserModel userModel);

    List<UserEntity> showAllUsers();

    void delete(UserModel userModel);

    void update(UserModel userModel);
}
