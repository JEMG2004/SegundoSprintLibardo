package co.com.hyunseda.market.domain;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author USUARIO
 */
public class ShoppingCart {
    
    private Product product;
    private User user;
    private ArrayList<Product> carro;

    public ShoppingCart() {
    }
    

    public ShoppingCart(Product product, User user, ArrayList<Product> carro) {
        this.product = product;
        this.user = user;
        this.carro = carro;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Product> getCarro() {
        return carro;
    }

    public void setCarro(ArrayList<Product> carro) {
        this.carro = carro;
    }
    
}
