package ru.kpfu.itis.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.invoke.MethodHandles;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    private static final Logger LOG =
            LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Выполнение doGet() метода для logout страницы.");
        clear(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Выполнение doPost() метода для logout страницы.");
        clear(req, resp);
    }

    private void clear(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie[] cookies = req.getCookies();
        if(cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
                LOG.info("Cookie " + cookie.getName() + " очищены.");
            }
        }
        HttpSession session = req.getSession();
        if(session != null) {
            session.invalidate();
            LOG.info("Сессия недействительна.");
        }
        resp.sendRedirect(req.getContextPath() + "/index.html");
    }
}
