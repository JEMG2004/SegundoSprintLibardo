package co.com.hyunseda.market.domain.acess;

import co.com.hyunseda.market.domain.Category;
import co.com.hyunseda.market.domain.Product;
import co.com.hyunseda.market.service.ProductService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ProductRepository implements IProductRepository{
     
     private String apiUrl = "http://localhost:8001/products";
     private Connection conn;
     
     //Constructor que inicia la base de datos
    public ProductRepository() {
        try {

            conn = DatabaseConnection.getConnection();
            initDatabase();
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<Product> findAll() {
        
        HttpClient httpClient = HttpClients.createDefault();
        ObjectMapper mapper = new ObjectMapper();
        List<Product> list = new ArrayList<>();
        try {

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
                Product[] products = mapper.readValue(jsonResponse, Product[].class);

                for (Product product : products) {
                    list.add(product);
                }

            } else {
                // La solicitud falló, mostrar el código de estado
                Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, "Error al obtener productos. Código de estado: " + statusCode);
            }
        } catch (IOException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    @Override
    public boolean save(Product newProduct) {
        
        HttpClient httpClient = HttpClients.createDefault();
        ObjectMapper mapper = new ObjectMapper();
   
            try {

            // Definir la URL de la API REST de productos
            String apiUrl = "http://localhost:8001/products";
            // Crear una solicitud GET para obtener todos los productos
            HttpPost request = new HttpPost(apiUrl);

            // Ejecutar la solicitud y obtener la respuesta
            HttpResponse response = httpClient.execute(request);

            // Verificar el código de estado de la respuesta
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                // La solicitud fue exitosa, procesar la respuesta
                String jsonResponse = EntityUtils.toString(response.getEntity());
                return true;
            } else {
                // La solicitud falló, mostrar el código de estado
                Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, "Error al obtener productos. Código de estado: " + statusCode);
            }
        } catch (IOException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    
    @Override
    public boolean delete(int productId) {
    HttpClient httpClient = HttpClients.createDefault();
    ObjectMapper mapper = new ObjectMapper();

    try {
        // Definir la URL de la API REST de productos
        String apiUrl = "http://localhost:8001/products/" + productId;

        // Crear una solicitud DELETE para eliminar el producto con el ID especificado
        HttpDelete request = new HttpDelete(apiUrl);

        // Ejecutar la solicitud y obtener la respuesta
        HttpResponse response = httpClient.execute(request);

        // Verificar el código de estado de la respuesta
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            // La solicitud fue exitosa, procesar la respuesta si es necesario
            return true;
        } else {
            // La solicitud falló, mostrar el código de estado
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, "Error al eliminar el producto. Código de estado: " + statusCode);
        }
    } catch (IOException ex) {
        // Manejar la excepción
        Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        // Cerrar el cliente HTTP
        try {
            httpClient.close();
        } catch (IOException e) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    return false;
}
    
     /*@Override
    public boolean delete(int productId) {
         try {
            //Validate product
            if (productId <= 0) {
                return false;
            }
            //this.connect();

            String sql = "DELETE FROM Product "
                    + "WHERE productId = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, productId);
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }*/

    /*@Override
    public boolean save(Product newProduct) {
        ArrayList<Category> categorias = newProduct.getCategoriasSecundarias();
        Category categoria = newProduct.getCategory();
        try {
            //Validate product
            if (newProduct == null || newProduct.getProductId() < 0 || newProduct.getProductName().isBlank()) {
                return false;
            }
            //this.connect();

            String sql = "INSERT INTO Product ( ProductId, productName, productDescripcion,categoryId,price ) "
                    + "VALUES ( ?, ?, ?,? ,?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.getResultSetType();
            pstmt.setInt(1, newProduct.getProductId());
            pstmt.setString(2, newProduct.getProductName());
            pstmt.setString(3, newProduct.getProductDescripcion());
            pstmt.setLong(4, newProduct.getCategory().getCategoryId());
            pstmt.setDouble(5, newProduct.getProductPrice());
            pstmt.executeUpdate();
            
            sql = "INSERT INTO ProductCategories ( ProductId,categoryId ) "
            + "VALUES ( ?, ?)";

            PreparedStatement pstmt2 = conn.prepareStatement(sql);
       
            pstmt2.setInt(1, newProduct.getProductId());
            
            System.out.print("LE ESTAMOS INGRESANDO LA CATEGORIA::: ");
            System.out.println(newProduct.getCategory().getCategoryId());
          
            pstmt2.setInt(2, newProduct.getCategory().getCategoryId());
            pstmt2.executeUpdate();
            
            categoria.setCategoryId(newProduct.getCategory().getCategoryId());
            categoria.setCategoryName(newProduct.getCategory().getCategoryName());
            //se almacena la lista de categorias del producto y se le añade la nueva categoria
            categorias.add(categoria);
            //se actualiza la lista de categorias
            System.out.print("CATEGORIA SECUNDARIA AÑADIDA");
            System.out.print(categorias);
            newProduct.setCategoriasSecundarias(categorias);
            
            String sql2 = "SELECT * FROM ProductCategories";
            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery(sql2);
            System.out.println("ESTAMOS BUSCANDO EL ERROR, ID CATEGORIA:");
            while (rs2.next()) {
                System.out.println(rs2.getInt("categoryId"));
            }

            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    */
    @Override
    public boolean saveProductCategory(Product producto,Category newCategory) {
        ArrayList<Category> categorias = producto.getCategoriasSecundarias();
        try {
            //Validate product
            if (producto == null || producto.getProductId() < 0 || producto.getProductName().isBlank()) {
                return false;
            }
            //this.connect();
            //se añade la conexion producto-categoria en la base de datos
            String sql = "INSERT INTO ProductCategories ( ProductId,categoryId ) "
            + "VALUES ( ?, ?)";

            PreparedStatement pstmt2 = conn.prepareStatement(sql);
            System.out.println("ATENCION");
            System.out.println("ID DEL PRODUCTO:");
            System.out.println(producto.getProductId());
            pstmt2.setInt(1, producto.getProductId());
            System.out.println("ATENCION");
            System.out.println("ID DE LA CATEGORIA:");
            System.out.println(newCategory.getCategoryId());
            pstmt2.setInt(2, newCategory.getCategoryId());
            pstmt2.executeUpdate();
            
            //se almacena la lista de categorias del producto y se le añade la nueva categoria
            categorias.add(newCategory);
            //se actualiza la lista de categorias
            System.out.print("OJOOOOOOOJ CATEGORIA SECUNDARIA AÑADIDA");
            System.out.print(categorias);
            producto.setCategoriasSecundarias(categorias);
            
           

            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**@Override
    public List<Product> findAll() {

        List<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Product";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Obtener todas las categorías secundarias de todos los productos
            Map<Integer, List<Integer>> productIdToCategoryIdsMap = new HashMap<>();
            String sql2 = "SELECT * FROM ProductCategories";
            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery(sql2);
            while (rs2.next()) {
                int productId = rs2.getInt("productId");
                int categoryId = rs2.getInt("categoryId");
                if (!productIdToCategoryIdsMap.containsKey(productId)) {
                    productIdToCategoryIdsMap.put(productId, new ArrayList<>());
                }
                productIdToCategoryIdsMap.get(productId).add(categoryId);
            }

            while (rs.next()) {
                Product newProduct = new Product();
                newProduct.setProductId(rs.getInt("productId"));
                newProduct.setProductName(rs.getString("productName"));
                newProduct.setProductDescripcion(rs.getString("productDescripcion"));

                int categoryId = rs.getInt("categoryId");
                Category newCategory = new Category(categoryId, findByCategoryId(categoryId).getCategoryName());
                newProduct.setCategory(newCategory);

                // Obtener las categorías secundarias del producto actual
                List<Integer> categoryIds = productIdToCategoryIdsMap.getOrDefault(newProduct.getProductId(), new ArrayList<>());
                ArrayList<Category> secondaryCategories = new ArrayList<>();
                for (int id : categoryIds) {
                    Category secondaryCategory = new Category(id, findByCategoryId(id).getCategoryName());
                    secondaryCategories.add(secondaryCategory);
                }
                newProduct.setCategoriasSecundarias(secondaryCategories);

                products.add(newProduct);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }*/

    
    private void initDatabase() {
        // SQL statement for creating a new table
        /*String sql = "CREATE TABLE IF NOT EXISTS category (\n"
                + "	categoryId integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	name text NOT NULL\n"
                + ");";*/

        try {
            this.connect();
            Statement stmt = conn.createStatement();
            //stmt.execute(sql);
            String sql = "CREATE TABLE IF NOT EXISTS Categories (\n"
                + "categoryId INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + "categoryName TEXT NOT NULL"
                + ")";
            stmt.execute(sql);
            sql = "CREATE TABLE IF NOT EXISTS Product (\n"
                + "	productId integer PRIMARY KEY,\n"
                + "	productName text NOT NULL,\n"
                + "	productDescripcion text NOT NULL,\n"
                + "	categoryId integer,\n"
                + "	price REAL NOT NULL"
                //+ "	FOREIGN KEY (categoryId) REFERENCES Categories(categoryId)"
                + ");";
            stmt.execute(sql);
            
            sql = "CREATE TABLE IF NOT EXISTS ProductCategories (\n"
                + "	productId integer,\n"
                + "	categoryId integer,\n"
                + "	FOREIGN KEY (productId) REFERENCES Product(productId) ON DELETE CASCADE,\n"
                + "	FOREIGN KEY (categoryId) REFERENCES Categories(categoryId),\n"
                + "	PRIMARY KEY (productId, categoryId)"
                + ");";
            stmt.execute(sql);
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    

    public void connect() {
        // SQLite connection string
        //String url = "jdbc:sqlite:./mydatabase.db";
        String url = "jdbc:sqlite::memory:";

        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }


  
    @Override
    public boolean edit(int productId, Product product) {
         try {
            //Validate product
            if (productId <= 0 || product == null) {
                return false;
            }
            //this.connect();

            String sql = "UPDATE  product "
                    + "SET productName=?, productDescripcion=? , categoryId=?, price =? "
                    + "WHERE productId = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, product.getProductName());
            pstmt.setString(2, product.getProductDescripcion());
            pstmt.setInt(3, product.getCategory().getCategoryId());
            pstmt.setDouble(4, product.getProductPrice());
            pstmt.setInt(5, productId);
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

   

    @Override
    public Product findById(int productId) {
        ArrayList<Category> categorias = new ArrayList<>();
        try {

            String sql = "SELECT * FROM product  "
                    + "WHERE productId = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, productId);

            ResultSet res = pstmt.executeQuery();

            String sql2 = "SELECT * FROM ProductCategories";
            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery(sql2);
            
            
            if (res.next()) {
                Product prod = new Product();
                do{
                    Category newCategory = new Category();
                    if(res.getInt("productId") == rs2.getInt("productId")){
                        newCategory.setCategoryId(rs2.getInt("categoryId"));
                        //obtiene el id category de productCategories y usa la funcion 
                        //buscar categoria por id para obtener la categoria y luego
                        //obtiene el nombre de esa categoria
                        newCategory.setCategoryName(findByCategoryId(rs2.getInt("categoryId")).getCategoryName());
                        categorias.add(newCategory);
                    }
                    prod.setCategoriasSecundarias(categorias); 
                }while(rs2.next());
                prod.setProductId(res.getInt("productId"));
                prod.setProductName(res.getString("ProductName"));
                prod.setProductDescripcion(res.getString("productDescripcion"));
                
                Category cat = new Category(res.getInt("categoryId"), "");
                prod.setCategory(cat);
                return prod;
            } else {
                return null;
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    
    }

      @Override
    public List<Product> findAllByName(String productName) {
        ArrayList<Category> categorias = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        try {

            String sql = "SELECT * FROM product  "
                    + "WHERE ProductName like ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, productName);

            ResultSet rs = pstmt.executeQuery();
            
            String sql2 = "SELECT * FROM ProductCategories";
            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery(sql2);
            
            
            while (rs.next()) {
                Product newProduct = new Product();
                
                do{
                    Category newCategory = new Category();
                    if(rs.getInt("productId") == rs2.getInt("productId")){
                        newCategory.setCategoryId(rs2.getInt("categoryId"));
                        //obtiene el id category de productCategories y usa la funcion 
                        //buscar categoria por id para obtener la categoria y luego
                        //obtiene el nombre de esa categoria
                        newCategory.setCategoryName(findByCategoryId(rs2.getInt("categoryId")).getCategoryName());
                        categorias.add(newCategory);
                    }
                    newProduct.setCategoriasSecundarias(categorias); 
                }while(rs2.next());
                
                newProduct.setProductId(rs.getInt("productId"));
                newProduct.setProductName(rs.getString("productName"));
                newProduct.setProductDescripcion(rs.getString("productDescripcion"));

                Category cat = new Category(rs.getInt("categoryId"), "");
                newProduct.setCategory(cat);
                products.add(newProduct);
            }
            return products;
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return products;
        }
    }
    
        @Override
    public Product findByName(String name) {
        ArrayList<Category> categorias = new ArrayList<>();
        try {
            //String sql = "SELECT p.*, c.productName AS category_name FROM product p LEFT JOIN categories c ON p.categoryId = c.categoryId WHERE p.productName = ?";
            String sql = "SELECT * FROM product  "
                    + "WHERE productName like ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);

            ResultSet res = pstmt.executeQuery();
            
            String sql2 = "SELECT * FROM ProductCategories";
            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery(sql2);
            

            if (res.next()) {
                Product product = new Product();
                do{
                    Category newCategory = new Category();
                    if(res.getInt("productId") == rs2.getInt("productId")){
                        newCategory.setCategoryId(rs2.getInt("categoryId"));
                        //obtiene el id category de productCategories y usa la funcion 
                        //buscar categoria por id para obtener la categoria y luego
                        //obtiene el nombre de esa categoria
                        newCategory.setCategoryName(findByCategoryId(rs2.getInt("categoryId")).getCategoryName());
                        categorias.add(newCategory);
                    }
                    product.setCategoriasSecundarias(categorias); 
                }while(rs2.next());
                product.setProductId(res.getInt("productId"));
                product.setProductName(res.getString("productName"));
                product.setProductDescripcion(res.getString("productDescripcion"));
                // Obtener el nombre de la categoría del producto
                Integer categoryId = res.getInt("categoryId");
                Category category = new Category();
                category.setCategoryId(categoryId);
                product.setCategory(category);
                product.setProductPrice(res.getDouble("price"));
                return product;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Category findByCategoryId(int categoryId) {
        try {
            //String sql = "SELECT p.*, c.productName AS category_name FROM product p LEFT JOIN categories c ON p.categoryId = c.categoryId WHERE p.productName = ?";
            String sql = "SELECT * FROM Categories  "
                    + "WHERE categoryId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, categoryId);
            
            ResultSet res = pstmt.executeQuery();

            //if (res.next()) {
                Category categoria = new Category();
                categoria.setCategoryId(res.getInt("categoryId"));
                System.out.println("ESTA ES LA CATEGORIA QUE ESTA RECIBIENDO");
                System.out.println(categoria.getCategoryId());
                categoria.setCategoryName(res.getString("categoryName"));
                System.out.println("ESTA ES EL NOMBRE CATEGORIA QUE ESTA RECIBIENDO");
                System.out.println(categoria.getCategoryName());
                return categoria;
            //} else {
            //    return null;
            //}
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
@Override
public List<Product> findAllByCategoryId(int categoryId) {
    List<Product> products = new ArrayList<>();
    try {
        String sql = "SELECT DISTINCT p.* FROM Product p " +
                     "JOIN ProductCategories pc ON p.productId = pc.productId " +
                     "WHERE pc.categoryId = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, categoryId);
        ResultSet rs = pstmt.executeQuery();

        Map<Integer, List<Integer>> productIdToCategoryIdsMap = new HashMap<>();
        while (rs.next()) {
            int productId = rs.getInt("productId");

            // Obtener todas las categorías secundarias del producto
            String sqlSecondaryCategories = "SELECT categoryId FROM ProductCategories WHERE productId = ?";
            PreparedStatement pstmtSecondaryCategories = conn.prepareStatement(sqlSecondaryCategories);
            pstmtSecondaryCategories.setInt(1, productId);
            ResultSet rsSecondaryCategories = pstmtSecondaryCategories.executeQuery();

            List<Integer> secondaryCategoryIds = new ArrayList<>();
            while (rsSecondaryCategories.next()) {
                int secondaryCategoryId = rsSecondaryCategories.getInt("categoryId");
                secondaryCategoryIds.add(secondaryCategoryId);
            }

            productIdToCategoryIdsMap.put(productId, secondaryCategoryIds);
        }

        for (Map.Entry<Integer, List<Integer>> entry : productIdToCategoryIdsMap.entrySet()) {
            int productId = entry.getKey();
            List<Integer> secondaryCategoryIds = entry.getValue();

            Product newProduct = new Product();
            newProduct.setProductId(productId);
            newProduct.setProductName(findById(productId).getProductName()); // Reemplaza esto con tu lógica para obtener el nombre del producto
            newProduct.setProductDescripcion(findById(productId).getProductDescripcion()); // Reemplaza esto con tu lógica para obtener la descripción del producto

            // Obtener la categoría principal del producto
            int mainCategoryId = findById(productId).getCategory().getCategoryId(); // Reemplaza esto con tu lógica para obtener el categoryId principal del producto
            Category mainCategory = new Category(mainCategoryId, findByCategoryId(mainCategoryId).getCategoryName());
            newProduct.setCategory(mainCategory);

            // Obtener las categorías secundarias del producto
            ArrayList<Category> secondaryCategories = new ArrayList<>();
            for (int id : secondaryCategoryIds) {
                Category secondaryCategory = new Category(id, findByCategoryId(id).getCategoryName());
                secondaryCategories.add(secondaryCategory);
            }
            newProduct.setCategoriasSecundarias(secondaryCategories);

            products.add(newProduct);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return products;
}
}

  
    

