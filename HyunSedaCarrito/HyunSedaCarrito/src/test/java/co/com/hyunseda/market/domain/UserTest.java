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
public class UserTest {
    
    public UserTest() {
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
     * Test of getUserId method, of class User.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        User instance = new User(Long.MAX_VALUE, "", "");
        Long expResult = Long.MAX_VALUE;
        Long result = instance.getUserId();
        assertEquals(expResult, result, "El id ingresado no coincide con el regresado.");
    }

    /**
     * Test of setUserId method, of class User.
     */
    @Test
    public void testSetUserId() {
        System.out.println("setUserId");
        Long userId = Long.MIN_VALUE;
        User instance = new User(Long.MIN_VALUE, "", "");
        instance.setUserId(userId);

        Long expResult = Long.MIN_VALUE;
        Long result = instance.getUserId();
        assertEquals(expResult, result, "El id ingresado no se guardó.");
    }

    /**
     * Test of getFirstName method, of class User.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        User instance = new User(1L, "exampleFirstName", "");
        String expResult = "exampleFirstName";
        String result = instance.getFirstName();
        assertEquals(expResult, result, "El nombre devuelto no coincide con el ingresado.");
    }

    /**
     * Test of setFirstName method, of class User.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "exampleFirstName";
        User instance = new User();
        instance.setFirstName(firstName);

        String expResult = "exampleFirstName";
        String result = instance.getFirstName();
        assertEquals(expResult, result, "El nombre ingresado no se guardó.");
    }

    /**
     * Test of getLastName method, of class User.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        User instance = new User(1L, "", "exampleLastName");
        String expResult = "exampleLastName";
        String result = instance.getLastName();
        assertEquals(expResult, result, "El apellido devuelto no coincide con el ingresado.");
    }

    /**
     * Test of setLastName method, of class User.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "exampleLastName";
        User instance = new User();
        instance.setLastName(lastName);

        String expResult = "exampleLastName";
        String result = instance.getLastName();
        assertEquals(expResult, result, "El apellido devuelto no coincide con el ingresado.");
    }
    
}
