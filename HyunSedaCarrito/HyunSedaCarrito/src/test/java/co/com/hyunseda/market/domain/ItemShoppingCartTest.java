package co.com.hyunseda.market.domain;

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
public class ItemShoppingCartTest {
    
    public ItemShoppingCartTest() {
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
     * Test of getProduct method, of class ItemShoppingCart.
     */
    @Test
    public void testGetProduct() {
        System.out.println("getProduct");
        ItemShoppingCart instance = new ItemShoppingCart();
        
        Random rand = new Random();
        Category instanceCat = new Category();
        Product expResult = new Product();

        instanceCat.setCategoryId(rand.nextInt(5));
        instanceCat.setCategoryName("exampleCategoryName ");
        expResult.setProductId(rand.nextInt(10));
        expResult.setProductName("exampleProductName");
        expResult.setProductDescripcion("exampleProductDescripcion");
        expResult.setProductPrice(97000);
        expResult.setKeywords("exampleKeywords");
        expResult.setProductStock(rand.nextInt(30));
        expResult.setProductCaracteristc("exampleCharacteristics");
        expResult.setCategory(instanceCat);
        
        instance.setProduct(expResult);
        Product result = instance.getProduct();
        assertEquals(expResult, result, "El producto ingresado y el regresado no coinciden.");
    }

    /**
     * Test of setProduct method, of class ItemShoppingCart.
     */
    @Test
    public void testSetProduct() {
        System.out.println("setProduct");
        ItemShoppingCart instance = new ItemShoppingCart();
        
        Random rand = new Random();
        Category instanceCat = new Category();
        Product expResult = new Product();

        instanceCat.setCategoryId(rand.nextInt(5));
        instanceCat.setCategoryName("exampleCategoryName ");
        expResult.setProductId(rand.nextInt(10));
        expResult.setProductName("exampleProductName");
        expResult.setProductDescripcion("exampleProductDescripcion");
        expResult.setProductPrice(97000);
        expResult.setKeywords("exampleKeywords");
        expResult.setProductStock(rand.nextInt(30));
        expResult.setProductCaracteristc("exampleCharacteristics");
        expResult.setCategory(instanceCat);
        
        instance.setProduct(expResult);
        Product result = instance.getProduct();
        assertEquals(expResult, result, "El producto no se guardó correctamente");
    }

    /**
     * Test of getAmount method, of class ItemShoppingCart.
     */
    @Test
    public void testGetAmount() {
        System.out.println("getAmount");
        ItemShoppingCart instance = new ItemShoppingCart(new Product(), 30);
        int expResult = 30;
        int result = instance.getAmount();
        assertEquals(expResult, result, "La cantidad de productos ingresada y la regresada no coinciden.");
    }

    /**
     * Test of setAmount method, of class ItemShoppingCart.
     */
    @Test
    public void testSetAmount() {
        System.out.println("setAmount");
        int amount = Integer.MAX_VALUE;
        ItemShoppingCart instance = new ItemShoppingCart();
        instance.setAmount(amount);
        int result = instance.getAmount();
        assertEquals(amount, result, "La cantidad de productos no se guardó correctamente");
    }
    
}
