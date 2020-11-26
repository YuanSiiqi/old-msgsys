package dao.impl;

import dao.BaseDao;
import dao.UserDao;
import entity.User;

import java.util.List;

/**
 * 作者：ysq
 * 日期: 2020/11/26 14:24
 * 描述:
 */
public class UserDaoImpl extends BaseDao implements UserDao{
    public int insert(User user) {
        String sql="insert into `T_user` (`username`,`password`,`email`) values(?,?,?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }

    public int update(User user) {
        String sql = "update `T_user` set `username`=?,`password`=?,`email`=? where `id`=?";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getId());

    }

    public int delete(Integer id) {
        String sql = "delete from `T_user` where `id`=?";
        return update(sql, id);
    }

    public List<User> queryAll() {
        String sql = "select * from `T_user";
        return queryForList(User.class, sql);
    }

    public User queryUserById(Integer id) {
        String sql = "select * from `T_user` where `id`=?";
        return queryForOne(User.class, sql, id);
    }

    public User queryUserByNameAndPassword(User user) {
        String sql = "SELECT * FROM `T_user` where `username`=? and `password`=?";
        return queryForOne(User.class, sql, user.getUsername(), user.getPassword());
    }
}
