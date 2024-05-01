package co.com.hyunseda.market.domain;

import java.util.ArrayList;
import java.util.Random;
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
public class ShoppingCartTest {

    public ShoppingCartTest() {
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
     * Test of getProduct method, of class ShoppingCart.
     */
    @Test
    public void testGetProduct() {
        System.out.println("getProduct");
        ShoppingCart instance = new ShoppingCart();
        Random rand = new Random();
        Category instanceCat = new Category();
        Product instanceProd = new Product();

        instanceCat.setCategoryId(rand.nextInt(5));
        instanceCat.setCategoryName("exampleCategoryName ");
        instanceProd.setProductId(1);
        instanceProd.setProductName("exampleProductName");
        instanceProd.setProductDescripcion("exampleProductDescripcion");
        instanceProd.setProductPrice(150000);
        instanceProd.setKeywords("exampleKeywords");
        instanceProd.setProductStock(3);
        instanceProd.setProductCaracteristc("exampleCharacteristics");
        instanceProd.setCategory(instanceCat);
        
        Product expResult = instanceProd;
        instance.setProduct(instanceProd);
        Product result = instance.getProduct();
        assertEquals(expResult, result, "El producto obtenido no coincide con el ingresado.");
    }

    /**
     * Test of setProduct method, of class ShoppingCart.
     */
    @Test
    public void testSetProduct() {
        System.out.println("setProductId");
        ShoppingCart instance = new ShoppingCart();
        Random rand = new Random();
        Category instanceCat = new Category();
        Product instanceProd = new Product();

        instanceCat.setCategoryId(rand.nextInt(5));
        instanceCat.setCategoryName("exampleCategoryName ");
        instanceProd.setProductId(2);
        instanceProd.setProductName("exampleProductName");
        instanceProd.setProductDescripcion("exampleProductDescripcion");
        instanceProd.setProductPrice(150000);
        instanceProd.setKeywords("exampleKeywords");
        instanceProd.setProductStock(3);
        instanceProd.setProductCaracteristc("exampleCharacteristics");
        instanceProd.setCategory(instanceCat);
        
        Product expResult = instanceProd;
        instance.setProduct(instanceProd);
        Product result = instance.getProduct();
        assertEquals(expResult, result, "El producto  no se guardó correctamente.");
    }

    /**
     * Test of getUser method, of class ShoppingCart.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        ShoppingCart instance = new ShoppingCart();
        User expResult = new User(1L, "exampleFirstName", "exampleLastName");
        instance.setUser(expResult);
        User result = instance.getUser();
        assertEquals(expResult, result, "El usuario ingresado y el obtenido no coinciden.");
    }

    /**
     * Test of setUser method, of class ShoppingCart.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        ShoppingCart instance = new ShoppingCart();
        User expResult = new User(10L, "exampleFirstName", "exampleLastName");
        instance.setUser(expResult);
        User result = instance.getUser();
        assertEquals(expResult, result, "El usuario no se guardó correctamente.");
    }

    /**
     * Test of getCarro method, of class ShoppingCart.
     */
    @Test
    public void testGetCarro() {
        System.out.println("getCarro");
        ShoppingCart instanceCart = new ShoppingCart();
        ArrayList<Product> expResult = new ArrayList<>();
        Random rand = new Random();
        Category instanceCat = new Category();
        Product instanceProd = new Product();
        for (int i = 0; i < 5; i++) {
            instanceCat.setCategoryId(rand.nextInt(5));
            instanceCat.setCategoryName("exampleCategoryName " + i);
            instanceProd.setProductId(i);
            instanceProd.setProductName("exampleProductName" + i);
            instanceProd.setProductDescripcion("exampleProductDescripcion" + i);
            instanceProd.setProductPrice(150000 + i * 1000);
            instanceProd.setKeywords("exampleKeywords" + i);
            instanceProd.setProductStock(i+3);
            instanceProd.setProductCaracteristc("exampleCharacteristics" + i);
            instanceProd.setCategory(instanceCat);
            expResult.add(instanceProd);
            
        }
        instanceCart.setCarro(expResult);
        ArrayList<Product> result = instanceCart.getCarro();
        assertEquals(expResult, result, "El carrito ingresado y el obtenido no coinciden.");
        
    }

    /**
     * Test of setCarro method, of class ShoppingCart.
     */
    @Test
    public void testSetCarro() {
        System.out.println("setCarro");
        ShoppingCart instanceCart = new ShoppingCart();
        ArrayList<Product> expResult = new ArrayList<>();
        Random rand = new Random();
        Category instanceCat = new Category();
        Product instanceProd = new Product();
        for (int i = 0; i < 5; i++) {
            instanceCat.setCategoryId(rand.nextInt(5));
            instanceCat.setCategoryName("exampleCategoryName " + i);
            instanceProd.setProductId(i);
            instanceProd.setProductName("exampleProductName" + i);
            instanceProd.setProductDescripcion("exampleProductDescripcion" + i);
            instanceProd.setProductPrice(150000 + i * 1000);
            instanceProd.setKeywords("exampleKeywords" + i);
            instanceProd.setProductStock(i+3);
            instanceProd.setProductCaracteristc("exampleCharacteristics" + i);
            instanceProd.setCategory(instanceCat);
            expResult.add(instanceProd);
            
        }
        instanceCart.setCarro(expResult);
        ArrayList<Product> result = instanceCart.getCarro();
        assertEquals(expResult, result, "El carrito no se guardó correctamente.");
    }

}
