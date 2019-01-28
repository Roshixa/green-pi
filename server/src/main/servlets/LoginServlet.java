package main.servlets;

import main.service.UserService;
import main.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!userService.hasLoggedIn(request.getSession())) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            if (request.getParameter("name") != null) {
                String name = request.getParameter("name");
                String passwordConfirmation = request.getParameter("password_confirmation");
                userService.signUp(name, email, password, passwordConfirmation);
            }
            userService.login(email, password, request.getSession());
        }
        response.sendRedirect(request.getContextPath() + "/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!userService.hasLoggedIn(request.getSession())) {
            request.getRequestDispatcher("/WEB-INF/layout/login.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
}
