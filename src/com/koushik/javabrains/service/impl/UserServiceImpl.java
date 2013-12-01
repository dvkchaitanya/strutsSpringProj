package com.koushik.javabrains.service.impl;

import com.koushik.javabrains.dao.UserDao;
import com.koushik.javabrains.entity.UserEntity;
import com.koushik.javabrains.model.UserModel;
import com.koushik.javabrains.service.UserService;
import com.koushik.javabrains.viewBean.OnlyUserNameWithIds;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public List<OnlyUserNameWithIds> showAllUsers() {
        List<UserEntity> userEntityList = null;
        List<UserEntity> userEntityList1 = new ArrayList<UserEntity>();
        OnlyUserNameWithIds userNameWithIds = null;
        List<OnlyUserNameWithIds> onlyUserNameWithIdsList = new ArrayList<OnlyUserNameWithIds>();
        Set<OnlyUserNameWithIds> onlyUserNameWithIdsSet = new HashSet<OnlyUserNameWithIds>();
        int userId;
        String userName;
        try{
            userEntityList = getUserDao().listUsers();
            for (UserEntity userEntity: userEntityList) {
                 userId = userEntity.getUserId();
                 userName = userEntity.getUserName();
                 userNameWithIds = new OnlyUserNameWithIds();
                userNameWithIds.setUserId(userId);
                userNameWithIds.setUserName(userName);
                 onlyUserNameWithIdsSet.add(userNameWithIds);
            }
            onlyUserNameWithIdsList.addAll(onlyUserNameWithIdsSet);
        }
        catch (Exception e){
            logger.debug(e);
        }
/*        Set<UserEntity> userEntitySet = new HashSet<UserEntity>(userEntityList);
         userEntityList1.addAll(userEntitySet);
         return userEntityList1;*/
//        return userEntityList ;
        return onlyUserNameWithIdsList;
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

    @Override
    @Transactional
    public OnlyUserNameWithIds getUserById(int userId){
        OnlyUserNameWithIds userNameWithId = new OnlyUserNameWithIds();
        String userName =getUserDao().getUser(userId).getUserName();
        userNameWithId.setUserId(userId);
        userNameWithId.setUserName(userName);
        return userNameWithId;
//        return getUserDao().getUser(userId);
    }
}
