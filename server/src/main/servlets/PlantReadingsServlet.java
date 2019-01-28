package main.servlets;

import main.beans.Readings;
import main.service.PlantService;
import main.service.RaspberryService;
import main.service.UserService;
import main.service.impl.PlantServiceImpl;
import main.service.impl.RaspberryServiceImpl;
import main.service.impl.UserServiceImpl;
import main.utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/readings/*")
public class PlantReadingsServlet extends HttpServlet {
    private static final UserService userService = new UserServiceImpl();
    private static final PlantService plantService = new PlantServiceImpl();
    private static final RaspberryService raspberryService = new RaspberryServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (userService.hasLoggedIn(request.getSession())) {
            String hash = request.getPathInfo().substring(1);
            Readings readings = raspberryService.getReadings(plantService.find(hash));

            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.print(StringUtils.toJSON(readings));
            out.flush();
        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
}
