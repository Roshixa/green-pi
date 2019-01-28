package test.service;

import main.beans.Plant;
import main.service.RaspberryService;
import main.service.impl.RaspberryServiceImpl;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RaspberryServiceTest {

    private static final String EXISTANT_DB_ADDRESS = "raspberrypi";
    private static final Integer EXISTANT_DB_PORT = 3306;
    private static final String EXISTANT_DB_USERNAME = "Soukayna";
    private static final String EXISTANT_DB_PASSWORD = "1111";

    private static RaspberryService raspberryService = new RaspberryServiceImpl();

    @Test
    public void checkConnection(){
        Plant plant = new Plant(" ", EXISTANT_DB_ADDRESS,EXISTANT_DB_USERNAME,EXISTANT_DB_PASSWORD,EXISTANT_DB_PORT," ", " ", " ");
        assertTrue(raspberryService.checkConnection(plant));

        plant = new Plant(" ", EXISTANT_DB_ADDRESS + new Random().nextInt(),EXISTANT_DB_USERNAME,EXISTANT_DB_PASSWORD,EXISTANT_DB_PORT," ", " ", " ");
        assertFalse(raspberryService.checkConnection(plant));

        plant = new Plant(" ", EXISTANT_DB_ADDRESS ,EXISTANT_DB_USERNAME,EXISTANT_DB_PASSWORD,EXISTANT_DB_PORT + new Random().nextInt()," ", " ", " ");
        assertFalse(raspberryService.checkConnection(plant));
    }
}
