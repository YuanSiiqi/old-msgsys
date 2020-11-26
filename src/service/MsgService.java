package service;

import entity.Msg;

import java.util.List;

/**
 * 作者：ysq
 * 日期: 2020/11/26 16:13
 * 描述:
 */
public interface MsgService {
    Msg queryById(Integer id);

    List<Msg> queryByToUid(Integer id);

}
