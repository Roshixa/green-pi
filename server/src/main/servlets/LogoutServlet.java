package main.servlets;

import main.service.UserService;
import main.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private static final UserService userService = new UserServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (userService.hasLoggedIn(request.getSession())) {
            userService.logout(request.getSession());
        }
        response.sendRedirect(request.getContextPath() + "/");
    }
}
