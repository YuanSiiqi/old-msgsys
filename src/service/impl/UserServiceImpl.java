package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import service.UserService;

/**
 * 作者：ysq
 * 日期: 2020/11/26 14:33
 * 描述:
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    public int register(User user) {
        return userDao.insert(user);
    }

    public User login(User user) {
        return userDao.queryUserByNameAndPassword(user);
    }
}
