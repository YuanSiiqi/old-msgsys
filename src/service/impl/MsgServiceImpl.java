package service.impl;

import dao.MsgDao;
import dao.impl.MsgDaoImpl;
import entity.Msg;
import service.MsgService;

import java.util.List;

/**
 * 作者：ysq
 * 日期: 2020/11/26 16:18
 * 描述:
 */
public class MsgServiceImpl implements MsgService {
    MsgDao msgDao = new MsgDaoImpl();

    public Msg queryById(Integer id) {
        return msgDao.queryById(id);
    }

    public List<Msg> queryByToUid(Integer id) {
        return msgDao.queryByToUid(id);
    }

}
