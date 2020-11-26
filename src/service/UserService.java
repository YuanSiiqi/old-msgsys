package service;

import entity.User;

/**
 * 作者：ysq
 * 日期: 2020/11/26 14:25
 * 描述:
 */
public interface UserService {
    int register(User user);

    User login(User user);
}
