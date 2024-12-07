package ru.kpfu.itis.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.invoke.MethodHandles;



@WebServlet("/login")
public class LoginServlet extends HttpServlet {


    private static final Logger LOG =
            LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Выполнение doGet() метода для login страницы.");
        req.getRequestDispatcher("/login.html").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        LOG.info("Выполнение doPost() метода для login страницы. Логин пользователя: " + login);


        if ("login".equalsIgnoreCase(login) && "password".equals(password)) {
            //session
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("user", login);
            httpSession.setMaxInactiveInterval(60*60);
            LOG.info("Пользователь " + login + " авторизовался. Сессия создана.");

            //cookie
            Cookie cookie = new Cookie("user", login);
            cookie.setMaxAge(24*60*60);
            resp.addCookie(cookie); //для того чтоб браузер узнал, что кука добавилась
            LOG.info("Добавили cookie.");

            resp.sendRedirect("main.jsp");
        } else {
            LOG.warn("Провалена авторизация пользователя " + login);
            resp.sendRedirect("/login");
        }
    }

}
