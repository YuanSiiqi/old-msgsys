package servlet;

import entity.Msg;
import entity.User;
import service.MsgService;
import service.impl.MsgServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 作者：ysq
 * 日期: 2020/11/26 16:19
 * 描述:
 */
@WebServlet("/message.do")
public class MsgServlet extends BaseServlet {
    MsgService msgService = null;

    public MsgServlet() {
        msgService = new MsgServiceImpl();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request,response);
    }
    public void queryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        List<Msg> msgs = msgService.queryByToUid(user.getId());
        System.out.println(msgs);

        request.setAttribute("msgs", msgs);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }
}
