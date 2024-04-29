package co.com.hyunsedaItem.entity;

public class ItemProduct {

    private Product product;
    private Integer productAmount;

    public ItemProduct() {
    }
    public ItemProduct(Product producto, Integer cantidad) {
        this.product = producto;
        this.productAmount = cantidad;
    }

    public Product getProducto() {
        return product;
    }

    public void setProducto(Product producto) {
        this.product = producto;
    }

    public Integer getCantidad() {
        return productAmount;
    }

    public void setCantidad(Integer cantidad) {
        this.productAmount = cantidad;
    }

    public Double getTotal() {
        return product.getProductPrice() * productAmount.doubleValue();
    }
}
