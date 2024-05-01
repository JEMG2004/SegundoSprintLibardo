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
public class CategoryTest {

    public CategoryTest() {
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
     * Test of getCategoryId method, of class Category.
     */
    @Test
    public void testGetCategoryId() {
        System.out.println("getCategoryId");
        Category instance = new Category(8, "exampleCategoryName");
        int expResult = 8;
        int result = instance.getCategoryId();
        assertEquals(expResult, result, "El id de la categoría ingresada y el obtenido no coinciden.");

        
    }

    /**
     * Test of setCategoryId method, of class Category.
     */
    @Test
    public void testSetCategoryId() {
        System.out.println("setCategoryId");
        int categoryId = 9;
        Category instance = new Category();
        instance.setCategoryId(categoryId);

        int expResult = 9;
        int result = instance.getCategoryId();
        assertEquals(expResult, result, "El id de la categoría no se guardó correctamente.");
    }

    /**
     * Test of getCategoryName method, of class Category.
     */
    @Test
    public void testGetCategoryName() {
        System.out.println("getCategoryName");
        Category instance = new Category();
        String expResult = "exampleCategoryName";
        instance.setCategoryName(expResult);
        String result = instance.getCategoryName();
        assertEquals(expResult, result, "El nombre de la categoría ingresada y el obtenido no coinciden.");
    }

    /**
     * Test of setCategoryName method, of class Category.
     */
    @Test
    public void testSetCategoryName() {
        System.out.println("setCategoryName");
        String categoryName = "exampleCategoryName";
        Category instance = new Category();
        instance.setCategoryName(categoryName);

        String expResult = "exampleCategoryName";
        String result = instance.getCategoryName();
        assertEquals(expResult, result, "El nombre de la categoría no se guardó correctamente.");
    }

    /**
     * Test of toString method, of class Category.
     */
    /*
    @Test
    public void testToString() {
        System.out.println("toString");
        Category instance = new Category(3, "exampleCategoryName");
        String expResult = "Product{productId=" 
                           + 3 
                           + ", productName='" 
                           + "exampleCategoryName" + "'}";
        String result = instance.toString();
        assertEquals(expResult, result, "El método toStrig no devuelve lo que debería");
    }*/

}
