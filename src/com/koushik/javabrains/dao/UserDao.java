package com.koushik.javabrains.dao;

import com.koushik.javabrains.entity.UserEntity;
import com.koushik.javabrains.model.UserModel;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: venkatakrishnachaita
 * Date: 10/13/13
 * Time: 5:35 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserDao {
/*    JdbcTemplate getJdbcTemplate();

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);*/

    void insert(UserModel userModel);

    List listUsers();

    void deleteUser(UserModel userModel);

    void updateUser(UserEntity userModel);
   
    UserEntity getUser(int userId);
}
