package servlet;

import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * 作者：ysq
 * 日期: 2020/11/26 14:39
 * 描述:
 */
@WebServlet("/user.do")
public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request,response);
    }

    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        User user = new User(username, password, email);
        System.out.println("register");
        int result = userService.register(user);
        if (result > 0) {
            response.sendRedirect("/login.jsp");
        }
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("login");
        String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        String verify = request.getParameter("verify");
        if (token != null && verify != null && token.equalsIgnoreCase(verify)) {//忽略大小写
            User user = userService.login(new User(username, password, null));
            if (user != null) {
                System.out.println(user);
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                request.getRequestDispatcher("/message.do?action=queryList").forward(request, response);
            } else {
                //request.setAttribute("loginFlag",1);
                response.sendRedirect(request.getContextPath()+"/login.jsp");
            }
        } else {
            //request.setAttribute("verifyFlag", 1);
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }

    }

}
