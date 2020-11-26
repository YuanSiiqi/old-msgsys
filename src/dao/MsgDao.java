package dao;

import entity.Msg;

import java.util.List;

/**
 * 作者：ysq
 * 日期: 2020/11/26 16:08
 * 描述:
 */
public interface MsgDao {
    int insert(Msg msg);

    int update(Msg msg);

    int delete(Integer id);

    List<Msg> queryAll();

    Msg queryById(Integer id);

    List<Msg> queryByToUid(Integer id);
}
