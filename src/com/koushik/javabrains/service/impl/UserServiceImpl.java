package com.koushik.javabrains.service.impl;

import com.koushik.javabrains.dao.UserDao;
import com.koushik.javabrains.entity.TweetEntity;
import com.koushik.javabrains.entity.UserEntity;
import com.koushik.javabrains.model.UserModel;
import com.koushik.javabrains.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: venkatakrishnachaita
 * Date: 9/29/13
 * Time: 12:44 AM
 * To change this template use File | Settings | File Templates.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    public int userServiceInt = 2;

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
    private UserDao userDao;

    @Override
    public UserDao getUserDao() {
        return userDao;
    }

    @Override
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void insert(UserModel userModel){
        getUserDao().insert(userModel);
    }

    @Override
    @Transactional
    public List<UserEntity> showAllUsers() {
        List<UserEntity> userEntityList = null;
        try{
                userEntityList = getUserDao().listUsers();
        }
        catch (Exception e){
            logger.debug(e);
        }
          return userEntityList ;
    }

    @Override
    @Transactional
    public void delete(UserModel userModel) {
        getUserDao().deleteUser(userModel);
    }

    @Override
    @Transactional
    public void update(UserModel userModel) {
        UserEntity userEntity =new UserEntity();
        userEntity.setUserId(userModel.getUserId());
        userEntity.setUserName(userModel.getUserName());
        getUserDao().updateUser(userEntity);
    }
}











