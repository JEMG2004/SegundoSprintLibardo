package co.com.hyunsedaItem.entity;

public class Product {

    private long productId;
    private String productName;
    private String productDescripcion;
    private double productPrice;
    private long productStock;
    private String keywords;
    private String productCaracteristc;

    Category category;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public long getProductStock() {
        return productStock;
    }

    public void setProductStock(long productStock) {
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
}
