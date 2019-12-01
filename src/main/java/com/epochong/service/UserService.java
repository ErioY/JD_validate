package com.epochong.service;

import com.epochong.dao.UserDao;
import com.epochong.entity.User;

/**
 * @author epochong
 * @date 2019/8/3 10:38
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
public class UserService {
    private UserDao userDao = new UserDao();

    //用户登录
    public boolean userLogin(String username, String password) {
        User user = userDao.userLogin(username,password);
        if (user == null) {
            return false;
        }
        return true;
    }

    //用户注册
    public boolean userRegister(String userName, String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        return userDao.userRegister(user);
    }

    public boolean checkUsername(String username) {
        return userDao.checkUsername(username);
    }
}
