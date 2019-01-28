package main.servlets;

import main.beans.Plant;
import main.beans.Reading;
import main.service.PlantService;
import main.service.RaspberryService;
import main.service.UserService;
import main.service.impl.PlantServiceImpl;
import main.service.impl.RaspberryServiceImpl;
import main.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/stats")
public class PlantStatsServlet extends HttpServlet {
    private final static UserService userService = new UserServiceImpl();
    private final static RaspberryService raspberryService = new RaspberryServiceImpl();
    private final static PlantService plantService = new PlantServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (userService.hasLoggedIn(request.getSession())) {
            List<Plant> plants = plantService.findByUserEmail(userService.getSessionUser(request.getSession()));
            List<Reading> readings = raspberryService.getLastData(plants);
            request.setAttribute("plants", plants);
            request.setAttribute("readings", readings);
            request.getRequestDispatcher("/WEB-INF/layout/stats.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
}
