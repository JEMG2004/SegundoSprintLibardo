package co.com.hyunseda.market.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Felipe Pino
 */
public class LocationTest {

    public LocationTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getLatitude method, of class Location.
     */
    @Test
    public void testGetLatitude() {
        System.out.println("getLatitude");
        Location instance = new Location();
        int expResult = 100;
        instance.setLatitude(expResult);
        int result = instance.getLatitude();
        assertEquals(expResult, result);
        assertEquals(expResult, result, "La latitud de la ubicación ingresada y la regresada no coinciden.");

    }

    /**
     * Test of setLatitude method, of class Location.
     */
    @Test
    public void testSetLatitude() {
        System.out.println("setLatitude");
        int latitude = 10;
        Location instance = new Location();
        instance.setLatitude(latitude);

        int expResult = 10;
        int result = instance.getLatitude();
        assertEquals(expResult, result,"La latitud de la ubicación no se guardó correctamente.");
    }

    /**
     * Test of getLongitude method, of class Location.
     */
    @Test
    public void testGetLongitude() {
        System.out.println("getLongitude");
        Location instance = new Location();
        int expResult = 60;
        instance.setLongitude(expResult);
        int result = instance.getLongitude();
        assertEquals(expResult, result, "La longitud de la ubicación ingresada y la regresada no coinciden.");

    }

    /**
     * Test of setLongitude method, of class Location.
     */
    @Test
    public void testSetLongitude() {
        System.out.println("setLongitude");
        int longitude = 30;
        Location instance = new Location();
        instance.setLongitude(longitude);

        int expResult = 30;
        int result = instance.getLongitude();
        assertEquals(expResult, result,"La longitud de la ubicación ingresada no se guardó correctamente.");
    }
}
