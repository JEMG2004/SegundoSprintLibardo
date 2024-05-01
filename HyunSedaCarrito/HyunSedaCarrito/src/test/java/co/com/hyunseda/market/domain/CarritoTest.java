package co.com.hyunseda.market.domain;

import java.util.ArrayList;
import java.util.List;
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
public class CarritoTest {
    
    public CarritoTest() {
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
     * Test of getProductos method, of class Carrito.
     */
    @Test
    public void testGetProductos() {
        System.out.println("getProductos");
        List<Product> expResult = new ArrayList<>();
        Random rand = new Random();
        Category instanceCat = new Category();
        Product instanceProd = new Product();
        for (int i = 0; i < 5; i++) {
            instanceCat.setCategoryId(rand.nextInt(5));
            instanceCat.setCategoryName("exampleCategoryName " + i);
            instanceProd.setProductId(i);
            instanceProd.setProductName("exampleProductName" + i);
            instanceProd.setProductDescripcion("exampleProductDescripcion" + i);
            instanceProd.setProductPrice(150000 + i * 2000);
            instanceProd.setKeywords("exampleKeywords" + i);
            instanceProd.setProductStock(i+7);
            instanceProd.setProductCaracteristc("exampleCharacteristics" + i);
            instanceProd.setCategory(instanceCat);
            expResult.add(instanceProd);
            
        }
        Carrito instanceCart = new Carrito(expResult, expResult.size());
        List<Product> result = instanceCart.getProductos();
        assertEquals(expResult, result, "Los productos ingresado no coinciden con los obtenidos");
    }

    /**
     * Test of setProductos method, of class Carrito.
     */
    @Test
    public void testSetProductos() {
        System.out.println("setProductos");
        List<Product> expResult = new ArrayList<>();
        Random rand = new Random();
        Category instanceCat = new Category();
        Product instanceProd = new Product();
        for (int i = 0; i < 5; i++) {
            instanceCat.setCategoryId(rand.nextInt(5));
            instanceCat.setCategoryName("exampleCategoryName " + i);
            instanceProd.setProductId(i);
            instanceProd.setProductName("exampleProductName" + i);
            instanceProd.setProductDescripcion("exampleProductDescripcion" + i);
            instanceProd.setProductPrice(150000 + i * 2000);
            instanceProd.setKeywords("exampleKeywords" + i);
            instanceProd.setProductStock(i+7);
            instanceProd.setProductCaracteristc("exampleCharacteristics" + i);
            instanceProd.setCategory(instanceCat);
            expResult.add(instanceProd);
            
        }
        Carrito instanceCart = new Carrito(new ArrayList<Product>(), 0);
        instanceCart.setProductos(expResult);
        List<Product> result = instanceCart.getProductos();
        assertEquals(expResult, result, "Los productos ingresado no se guardaron correctamente.");
    }

    /**
     * Test of getTotalArticulos method, of class Carrito.
     */
    @Test
    public void testGetTotalArticulos() {
        System.out.println("getTotalArticulos");
        Carrito instanceCart = new Carrito(new ArrayList<Product>(), 0);
        Random rand = new Random();
        int expResult = rand.nextInt(500);
        instanceCart.setTotalArticulos(expResult);
        int result = instanceCart.getTotalArticulos();
        assertEquals(expResult, result, "El número total de artículos ingresados y los obtenidos no coinciden.");
    }

    /**
     * Test of setTotalArticulos method, of class Carrito.
     */
    @Test
    public void testSetTotalArticulos() {
        System.out.println("setTotalArticulos");
        Carrito instanceCart = new Carrito(new ArrayList<Product>(), 0);
        Random rand = new Random();
        int expResult = rand.nextInt(500);
        instanceCart.setTotalArticulos(expResult);
        int result = instanceCart.getTotalArticulos();
        assertEquals(expResult, result, "El número total de artículos no se guardó correctamente.");
    }
    
}
