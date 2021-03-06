package main.servlets;

import main.service.PlantService;
import main.service.UserService;
import main.service.impl.PlantServiceImpl;
import main.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static main.utils.StringUtils.encrypt;

@WebServlet("/add")
public class PlantAddServlet extends HttpServlet {
    private static final UserService userService = new UserServiceImpl();
    private static final PlantService plantService = new PlantServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (userService.hasLoggedIn(request.getSession())) {
            String name = request.getParameter("name");
            String dbAddress = request.getParameter("dbAddress");
            String dbUsername = request.getParameter("dbUsername");
            String dbPassword = request.getParameter("dbPassword");
            String description = request.getParameter("description");
            Integer port = Integer.getInteger(request.getParameter("port"));
            String userEmail = userService.getUserEmail(request.getSession());
            plantService.add(userEmail, dbAddress,dbUsername, dbPassword,port,name,description );
            if (plantService.find(encrypt(dbAddress + port)) != null) {
                response.sendRedirect(request.getContextPath() + "/stats");
            } else {
                response.sendRedirect(request.getContextPath() + "/add");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (userService.hasLoggedIn(request.getSession())) {
            request.setAttribute("plants", plantService.findByUserEmail(userService.getSessionUser(request.getSession())));
            request.getRequestDispatcher("/WEB-INF/layout/add.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
}
