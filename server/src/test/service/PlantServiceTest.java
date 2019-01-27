package test.service;

import main.service.PlantService;
import main.service.impl.PlantServiceImpl;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class PlantServiceTest {

    private static final String EXISTANT_DB_ADDRESS = "127.0.0.1";
    private static final Integer EXISTANT_DB_PORT = 3306;
    private static final String USER_NAME = "_test";
    private static PlantService plantService = new PlantServiceImpl();

    @Test
    public void add() {
        Boolean added = plantService.add(" ",EXISTANT_DB_ADDRESS, " ", " ", EXISTANT_DB_PORT, " ", " ");
        assertNotNull(added);

        added = plantService.add(" ",EXISTANT_DB_ADDRESS + new Random().nextInt(), " ", " ", EXISTANT_DB_PORT, " ", " ");
        assertTrue(added);

        added = plantService.add(" ",EXISTANT_DB_ADDRESS , " ", " ", EXISTANT_DB_PORT + new Random().nextInt(), " ", " ");
        assertTrue(added);

    }
}
