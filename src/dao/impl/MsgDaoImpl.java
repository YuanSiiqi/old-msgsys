package dao.impl;

import dao.BaseDao;
import dao.MsgDao;
import entity.Msg;

import java.util.List;

/**
 * 作者：ysq
 * 日期: 2020/11/26 16:13
 * 描述:
 */
public class MsgDaoImpl extends BaseDao implements MsgDao {

    public int insert(Msg msg) {
        String sql = "insert into `T_msg` (`fromUid`,`toUid`,`mTitle`,`mContent`,`readFlag`,`createTime`) values (?,?,?,?,?,?)";
        return update(sql, msg.getFromUid(), msg.getToUid(), msg.getmTitle(), msg.getmContent(), msg.getReadFlag(), msg.getCreateTime());
    }

    public int update(Msg msg) {
        String sql = "update `T_msg` set `fromUid`=?,`toUid`=?,`mTitle`=?,`mContent`=?,`readFlag`=?,`createTime`=? where `id`=?";
        return update(sql, msg.getFromUid(), msg.getToUid(), msg.getmTitle(), msg.getmContent(), msg.getReadFlag(), msg.getCreateTime(),msg.getId());

    }

    public int delete(Integer id) {
        String sql = "delete form `T_msg` where `id`=?";
        return update(sql, id);
    }

    public List<Msg> queryAll() {
        String sql = "select * from `T_msg`";
        return queryForList(Msg.class, sql);
    }

    public Msg queryById(Integer id) {
        String sql = "select * from `T_msg` where `id`=?";
        return queryForOne(Msg.class, sql, id);
    }

    public List<Msg> queryByToUid(Integer id) {
        String sql = "select * from `T_msg` where `toUid`=?";
        return queryForList(Msg.class, sql, id);
    }

}
