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

@WebServlet("/live/*")
public class PlantMonitorServlet extends HttpServlet {
    private static final UserService userService = new UserServiceImpl();
    private static final PlantService plantService = new PlantServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (userService.hasLoggedIn(request.getSession())) {
            String hash = request.getPathInfo().substring(1);
            request.setAttribute("plants", plantService.findByUserEmail(userService.getSessionUser(request.getSession())));
            request.setAttribute("plant", plantService.find(hash));
            request.getRequestDispatcher("/WEB-INF/layout/live.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
}
