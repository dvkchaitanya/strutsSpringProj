package com.koushik.javabrains.dao.impl;

import com.koushik.javabrains.dao.UserDao;
import com.koushik.javabrains.entity.UserEntity;
import com.koushik.javabrains.model.UserModel;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * UserName: venkatakrishnachaita
 * Date: 9/29/13
 * Time: 4:44 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao{
    private SessionFactory sessionFactory;
    private static final Logger logger = Logger.getLogger(UserDaoImpl.class);
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    public Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void insert(UserModel userModel) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userModel.getUserId());
        userEntity.setUserName(userModel.getUserName());
        getCurrentSession().save(userEntity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<UserEntity> listUsers() {
        return getCurrentSession().createCriteria(UserEntity.class).list();
    }
    
    @Override
    public void deleteUser(UserModel userModel ) {
        UserEntity userEntity= (UserEntity)getCurrentSession().
                createCriteria(UserEntity.class).add(Expression.eq("userId",userModel.
                getUserId())).list().get(0);
        getCurrentSession().delete(userEntity);
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        getCurrentSession().update(userEntity);
    }

    @Override
    public UserEntity getUser(int userId) {
          return (UserEntity)getCurrentSession().createCriteria(UserEntity.class).add(Expression.eq("userId",userId)).list().get(0);
    }
}
