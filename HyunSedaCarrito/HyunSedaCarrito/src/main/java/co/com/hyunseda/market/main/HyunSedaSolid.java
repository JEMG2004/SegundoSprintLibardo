package co.com.hyunseda.market.main;

import co.com.hyunseda.market.domain.Product;
import co.com.hyunseda.market.domain.User;
import co.com.hyunseda.market.domain.acess.CategoryRepository;
import co.com.hyunseda.market.domain.acess.Factory;
import co.com.hyunseda.market.domain.acess.ICategoryRepository;
import co.com.hyunseda.market.domain.acess.IProductRepository;
import co.com.hyunseda.market.domain.acess.ProductRepository;
import co.com.hyunseda.market.presentation.GUIAGREGARPRODUCT;
import co.com.hyunseda.market.presentation.GUIBUSCPRODUCTO;
import co.com.hyunseda.market.presentation.GUILOGIN;
import co.com.hyunseda.market.service.CategoryService;
import co.com.hyunseda.market.service.ProductService;
import co.com.hyunseda.market.service.ShoppingCartService;
import java.util.Scanner;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;

public class HyunSedaSolid {

    public static void main(String[] args) {
        
        /*Scanner scanner = new Scanner(System.in);
        IProductRepository repository = Factory.getInstance().getProductRepository("default");
        ICategoryRepository repositorycat = Factory.getInstance().getCategoryRepository("default");
        //Instancia el modelo - observado
        ProductService service = new ProductService(repository);
        ShoppingCartService shoppingCartService = new ShoppingCartService(new User());
        //CategoryRepository categoryRepository = new CategoryRepository();
        CategoryService categoryService = new CategoryService(repositorycat);
        categoryService.saveCategory(1,"Aretes");
        categoryService.saveCategory(2,"Bufandas");
        service.saveProduct(1,"Aretes Blancos","Blancos",2300, 20, "Seda", "Aretes hechos con hilos de seda 100% natural y cortezas de capullo",1);
        service.saveProduct(2,"Aretes margarita naranja y amarillo","Naranja y amarillo",1200, 10, "Seda", "Aretes con hilos y cortezas de capullos de seda 100% natural",2);
        service.saveProduct(3,"Bufanda rosa y marrón","Rosa y marrón",1200, 10, "Seda", "Bufanda hecha con gusano de seda",2);
        GUILOGIN guiLogin = new GUILOGIN(categoryService,service,shoppingCartService);

        guiLogin.setSize(400, 300);
        guiLogin.setVisible(true);
        
        //Instanciar las vistas - observers
        GUIBUSCPRODUCTO guiBuscProducto = new GUIBUSCPRODUCTO(guiLogin, true,categoryService,service,shoppingCartService);
        GUIAGREGARPRODUCT guiAgregarProduct = new GUIAGREGARPRODUCT(categoryService,service,shoppingCartService);*/
        
        //peticionGet();
        //peticionPost();
        peticionDelete();
        //peticionUpdate();
    }
    
    private static void peticionUpdate() {

        try {
            // Crear un objeto CloseableHttpClient
            CloseableHttpClient httpClient = HttpClients.createDefault();

            // Especificar la URL a la que se enviará la solicitud PUT
            String url = "http://localhost:8001/products/1"; // URL del producto a actualizar

            // Crear un objeto HttpPut con la URL especificada
            HttpPut httpPut = new HttpPut(url);

            // Crear un objeto ObjectMapper de Jackson
            ObjectMapper objectMapper = new ObjectMapper();

            // Crear un objeto Producto con los datos actualizados
            Product product = new Product();
            product.setProductId(1);
            product.setProductName("Nuevo nombre");
            product.setProductPrice(500D);
            // En este caso, estamos suponiendo que solo se actualizará el nombre y el precio del producto

            // Convertir el objeto a JSON
            String requestBody = objectMapper.writeValueAsString(product);

            // Configurar el cuerpo de la solicitud con el JSON
            StringEntity entity = new StringEntity(requestBody);
            httpPut.setEntity(entity);

            // Configurar las cabeceras de la solicitud si es necesario
            httpPut.setHeader("Content-Type", "application/json");

            // Ejecutar la solicitud PUT y obtener la respuesta
            HttpResponse response = httpClient.execute(httpPut);

            // Obtener el código de estado de la respuesta
            int statusCode = response.getStatusLine().getStatusCode();

            // Imprimir el código de estado de la respuesta
            System.out.println("Status code: " + statusCode);

            // Si se desea, también se puede obtener y mostrar el cuerpo de la respuesta
             String responseBody = EntityUtils.toString(response.getEntity());
             System.out.println("Response body: " + responseBody);
            // Cerrar el cliente HttpClient
            httpClient.close();
        } catch (JsonProcessingException ex) {
            Logger.getLogger(HyunSedaSolid.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(HyunSedaSolid.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HyunSedaSolid.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void peticionDelete() {

        try {
            // Crear un objeto CloseableHttpClient
            CloseableHttpClient httpClient = HttpClients.createDefault();

            // Especificar la URL a la que se enviará la solicitud DELETE
            String url = "http://localhost:8001/products/4"; // URL del producto a eliminar

            // Crear un objeto HttpDelete con la URL especificada
            HttpDelete httpDelete = new HttpDelete(url);

            // Ejecutar la solicitud DELETE y obtener la respuesta
            HttpResponse response = httpClient.execute(httpDelete);

            // Obtener el código de estado de la respuesta
            int statusCode = response.getStatusLine().getStatusCode();

            // Imprimir el código de estado de la respuesta
            System.out.println("Status code: " + statusCode);

            // Si se desea, también se puede obtener y mostrar el cuerpo de la respuesta
            String responseBody = EntityUtils.toString(response.getEntity());
            System.out.println("Response body: " + responseBody);

            // Cerrar el cliente HttpClient
            httpClient.close();

        } catch (IOException ex) {
            Logger.getLogger(HyunSedaSolid.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void peticionPost() {

        try {
            // Crear un objeto CloseableHttpClient
            CloseableHttpClient httpClient = HttpClients.createDefault();

            // Especificar la URL a la que se enviará la solicitud POST
            String url = "http://localhost:8001/products";

            // Crear un objeto HttpPost con la URL especificada
            HttpPost httpPost = new HttpPost(url);

            // Crear un objeto ObjectMapper de Jackson
            ObjectMapper objectMapper = new ObjectMapper();

            // Crear un objeto Producto
            Product product = new Product(6, "guantes",16,"Blancos",0 ); // Ejemplo de un producto

            // Convertir el objeto a JSON
            String jsonRequest = objectMapper.writeValueAsString(product);

            // Configurar la entidad de la solicitud con el JSON
            StringEntity entity = new StringEntity(jsonRequest);
            httpPost.setEntity(entity);

            // Configurar las cabeceras de la solicitud
            httpPost.setHeader("Content-Type", "application/json");
            // Si es necesario, puedes configurar otras cabeceras aquí

            // Ejecutar la solicitud y obtener la respuesta
            HttpResponse response = httpClient.execute(httpPost);

            // Obtener el cuerpo de la respuesta
            HttpEntity responseEntity = response.getEntity();
            String responseBody = EntityUtils.toString(responseEntity);

            // Imprimir la respuesta
            System.out.println("Response status: " + response.getStatusLine());
            System.out.println("Response body: " + responseBody);

            // Cerrar el cliente HttpClient
            httpClient.close();

        } catch (JsonProcessingException ex) {
            Logger.getLogger(HyunSedaSolid.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(HyunSedaSolid.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(HyunSedaSolid.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void peticionGet() {
        try {
            HttpClient httpClient = HttpClients.createDefault();
            ObjectMapper mapper = new ObjectMapper();

            // Definir la URL de la API REST de productos
            String apiUrl = "http://localhost:8001/products";

            // Crear una solicitud GET para obtener todos los productos
            HttpGet request = new HttpGet(apiUrl);

            // Ejecutar la solicitud y obtener la respuesta
            HttpResponse response = httpClient.execute(request);

            // Verificar el código de estado de la respuesta
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                // La solicitud fue exitosa, procesar la respuesta
                String jsonResponse = EntityUtils.toString(response.getEntity());

                // Mapear la respuesta JSON a objetos Product
                Product[] products = mapper.readValue(jsonResponse, Product[].class
                );

                // Mostrar los productos
                System.out.println("Productos:");
                for (Product product : products) {
                    System.out.println(product.getProductId() + ", " + product.getProductName() + ", " + product.getProductDescripcion()+", " + product.getProductPrice()+", " + product.getProductStock());
                }
            } else {
                // La solicitud falló, mostrar el código de estado
                System.err.println("Error al obtener productos. Código de estado: " + statusCode);

            }
        } catch (IOException ex) {
            Logger.getLogger(HyunSedaSolid.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }
}


