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
public class ProductTest {
    
    public ProductTest() {
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
     * Test of getProductId method, of class Product.
     */
    @Test
    public void testGetProductId() {
        System.out.println("getProductId");
        Product instance = new Product(6, "", "");
        int expResult = 6;
        int result = instance.getProductId();
        assertEquals(expResult, result, "El id del producto ingresado y el regresado no coinciden.");
    }

    /**
     * Test of setProductId method, of class Product.
     */
    @Test
    public void testSetProductId() {
        System.out.println("setProductId");
        int productId = 8;
        Product instance = new Product();
        instance.setProductId(productId);

        int expResult = 8;
        int result = instance.getProductId();
        assertEquals(expResult, result,"El id del producto no se guardó correctamente.");
    }

    /**
     * Test of getProductName method, of class Product.
     */
    @Test
    public void testGetProductName() {
        System.out.println("getProductName");
        Product instance = new Product(2, "exampleProductName", "");
        String expResult = "exampleProductName";
        String result = instance.getProductName();
        assertEquals(expResult, result, "El nombre del producto ingresado y el regresado no coinciden.");
    }

    /**
     * Test of setProductName method, of class Product.
     */
    @Test
    public void testSetProductName() {
        System.out.println("setProductName");
        String productName = "exampleProductName";
        Product instance = new Product();
        instance.setProductName(productName);

        String expResult = "exampleProductName";
        String result = instance.getProductName();
        assertEquals(expResult, result,"El nombre del producto no se guardó correctamente.");
    }

    /**
     * Test of getProductDescripcion method, of class Product.
     */
    @Test
    public void testGetProductDescripcion() {
        System.out.println("getProductDescripcion");
        Product instance = new Product(Integer.MAX_VALUE, "", "exampleProductDescripcion");
        String expResult = "exampleProductDescripcion";
        String result = instance.getProductDescripcion();
        assertEquals(expResult, result, "La decripción del producto ingresado y la regresada no coinciden.");
    }

    /**
     * Test of setProductDescripcion method, of class Product.
     */
    @Test
    public void testSetProductDescripcion() {
        System.out.println("setProductDescripcion");
        System.out.println("setProductDescripcion");
        String productDescripcion = "exampleProductDescripcion";
        Product instance = new Product();
        instance.setProductDescripcion(productDescripcion);

        String expResult = "exampleProductDescripcion";
        String result = instance.getProductDescripcion();
        assertEquals(expResult, result,"La decripción del producto no se guardó correctamente.");
    }

    /**
     * Test of getProductPrice method, of class Product.
     */
    @Test
    public void testGetProductPrice() {
        System.out.println("getProductPrice");
        Product instance = new Product(0, "", "", 150000, 0, "", "");
        double expResult = 150000.0;
        double result = instance.getProductPrice();
        assertEquals(expResult, result, "El precio del producto ingresado y el regresado no coinciden.");
    }

    /**
     * Test of setProductPrice method, of class Product.
     */
    @Test
    public void testSetProductPrice() {
        System.out.println("setProductPrice");
        double productPrice = 152000.0;
        Product instance = new Product();
        instance.setProductPrice(productPrice);

        double expResult = 152000.0;
        double result = instance.getProductPrice();
        assertEquals(expResult, result,"El precio del producto no se guardó correctamente.");
    }

    /**
     * Test of getProductStock method, of class Product.
     */
    @Test
    public void testGetProductStock() {
        System.out.println("getProductStock");
        Product instance = new Product();
        int expResult = 0;
        instance.setProductStock(expResult);
        int result = instance.getProductStock();
        assertEquals(expResult, result, "Las existencias del producto ingresado y las regresadas no coinciden.");
    }

    /**
     * Test of setProductStock method, of class Product.
     */
    @Test
    public void testSetProductStock() {
        System.out.println("setProductStock");
        int productStock = 10;
        Product instance = new Product();
        instance.setProductStock(productStock);

        int expResult = 10;
        int result = instance.getProductStock();
        assertEquals(expResult, result, "Las existencias del producto no se guardaron correctamente.");
    }

    /**
     * Test of getKeywords method, of class Product.
     */
    @Test
    public void testGetKeywords() {
        System.out.println("getKeywords");
        Product instance = new Product();
        String expResult = "exampleKeywords";
        instance.setKeywords(expResult);
        String result = instance.getKeywords();
        assertEquals(expResult, result, "Las palabras clave del producto ingresado y las regresadas no coinciden.");
    }

    /**
     * Test of setKeywords method, of class Product.
     */
    @Test
    public void testSetKeywords() {
        System.out.println("setKeywords");
        String keywords = "exampleKeywords";
        Product instance = new Product();
        instance.setKeywords(keywords);

        String expResult = "exampleKeywords";
        String result = instance.getKeywords();
        assertEquals(expResult, result, "Las palabras clave del producto no se guardaron correctamente.");
    }

    /**
     * Test of getProductCaracteristc method, of class Product.
     */
    @Test
    public void testGetProductCaracteristc() {
        System.out.println("getProductCaracteristc");
        Product instance = new Product();
        String expResult = "exampleProductCharacteristics";
        instance.setProductCaracteristc(expResult);
        String result = instance.getProductCaracteristc();
        assertEquals(expResult, result, "Las características del producto ingresado y las regresadas no coinciden.");
    }

    /**
     * Test of setProductCaracteristc method, of class Product.
     */
    @Test
    public void testSetProductCaracteristc() {
        System.out.println("getProductCaracteristc");
        Product instance = new Product();
        String expResult = "exampleProductCharacteristics";
        instance.setProductCaracteristc(expResult);
        String result = instance.getProductCaracteristc();
        assertEquals(expResult, result, "Las características del producto no se guardaron correctamente.");
    }

    /**
     * Test of getCategory method, of class Product.
     */
    @Test
    public void testGetCategory() {
        System.out.println("getCategory");
        Product instance = new Product();
        Category expResult = new Category(20, "a");
        instance.setCategory(expResult);
        Category result = instance.getCategory();
        assertEquals(expResult, result, "La decripción del producto ingresado y la regresada no coinciden.");
    }

    /**
     * Test of setCategory method, of class Product.
     */
    @Test
    public void testSetCategory() {
        System.out.println("setCategory");
        Product instance = new Product();
        Category expResult = new Category(40, "");
        instance.setCategory(expResult);
        Category result = instance.getCategory();
        assertEquals(expResult, result,"La decripción del producto no se guardó correctamente.");
    }

    /**
     * Test of setUser method, of class Product.
     */
    @Test
    public void testGetUser() {
        System.out.println("setUser");
        User expResult = new User(Long.MIN_VALUE, "", "");
        Product instance = new Product();
        instance.setUser(expResult);
        User result = instance.getUser();
        assertEquals(expResult, result, "El usuario del producto ingresado y el regresado no coinciden.");
    }
    
    /**
     * Test of setUser method, of class Product.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        User user = new User();
        Product instance = new Product();
        instance.setUser(user);
        User result = instance.getUser();
        assertEquals(user, result,"El usuario del producto no se guardó correctamente.");
    }

    /**
     * Test of getLocation method, of class Product.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        Product instance = new Product();
        Location expResult = new Location(10, 20);
        instance.setLocation(expResult);
        Location result = instance.getLocation();
        assertEquals(expResult, result, "La ubicación devuelta no es correcta.");
    }

    /**
     * Test of setLocation method, of class Product.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation");
        Product instance = new Product();
        Location expResult = new Location(50, 62);
        instance.setLocation(expResult);
        Location result = instance.getLocation();
        assertEquals(expResult, result, "La ubicación devuelta no coincide con la ingresada.");
    }

    /**
     * Test of toString method, of class Product.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Product instance = new Product();
        String expResult = "Product{productId=" + 0
                + ", productName='" + null
                + "', productDescripcion='" + null
                + ", productPrice='" + 0.0
                + ", productStock='" + 0
                + ", keywords='" + null
                + ", productCharacteristics='"
                + null
                + "'}";
        String result = instance.toString();
        assertEquals(expResult, result, "El método toStrig no devuelve lo que debería");
    }
    
}
