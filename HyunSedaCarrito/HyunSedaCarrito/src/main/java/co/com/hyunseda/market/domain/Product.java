package co.com.hyunseda.market.domain;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    
    @JsonProperty("productId")
    private int productId;
    
    @JsonProperty("productName")
    private String productName;
    
    @JsonProperty("productDescripcion")
    private String productDescripcion;
    
    @JsonProperty("productPrice")
    private double productPrice;
    
    @JsonProperty("productStock")
    private int productStock;
    
    @JsonProperty("keywords")
    private String keywords;
    
    @JsonProperty("productCaracteristc")
    private String productCaracteristc;
    
    Category category;
    
    @JsonProperty("categoriasSecundarias")
    private ArrayList<Category> categoriasSecundarias;
    Location location;
    User user;

    public Product(int productId, String productName, String productDescripcion) {
        this.productId = productId;
        this.productName = productName;
        this.productDescripcion = productDescripcion;
    }
    
     public Product(int productId, String productName, double productPrice,String productDescripcion,int productStock) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescripcion = productDescripcion;
        this.productStock = productStock;
    }
   
    public Product(int productId, String productName, String productDescripcion, double productPrice, int productStock, String keywords, String productCaracteristc) {
        this.productId = productId;
        this.productName = productName;
        this.productDescripcion = productDescripcion;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.keywords = keywords;
        this.productCaracteristc = productCaracteristc;
    }
    
    public Product(int productId, String productName, String productDescripcion, double productPrice, int productStock, String keywords, String productCaracteristc, ArrayList<Category> categoriasSecundarias) {
        this.productId = productId;
        this.productName = productName;
        this.productDescripcion = productDescripcion;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.keywords = keywords;
        this.productCaracteristc = productCaracteristc;
        this.categoriasSecundarias = categoriasSecundarias;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ArrayList<Category> getCategoriasSecundarias() {
        return categoriasSecundarias;
    }

    public void setCategoriasSecundarias(ArrayList<Category> categoriasSecundarias) {
        this.categoriasSecundarias = categoriasSecundarias;
    }

    public String getProductDescripcion() {
        return productDescripcion;
    }

    public void setProductDescripcion(String productDescripcion) {
        this.productDescripcion = productDescripcion;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getProductCaracteristc() {
        return productCaracteristc;
    }

    public void setProductCaracteristc(String productCaracteristc) {
        this.productCaracteristc = productCaracteristc;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public User getUser() {
        return user;
    }

   public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    
    @Override
    public String toString() {
        return "Product{productId=" + productId 
                +", productName='" + productName 
                + "', productDescripcion='" + productDescripcion 
                + ", productPrice='" + productPrice
                + ", productStock='" + productStock
                + ", keywords='" + keywords
                + ", productCharacteristics='"
                + productCaracteristc 
                + "'}";
    }
}

