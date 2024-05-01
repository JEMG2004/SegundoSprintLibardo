package co.com.hyunseda.market.service;

import co.com.hyunseda.market.domain.ShoppingCart;
import co.com.hyunseda.market.domain.Product;
import co.com.hyunseda.market.domain.User;
import co.com.hyunseda.market.infrastructure.Subject;
import java.util.ArrayList;
import java.util.Objects;
/**
 *
 * @author USUARIO
 */
public class ShoppingCartService extends Subject{
    private ShoppingCart carrito;
    
    public ShoppingCartService(User user) {
        ShoppingCart aux = new ShoppingCart();
        aux.setUser(user);
        aux.setCarro(new ArrayList<Product>());
        this.carrito = aux;
    }

    public ShoppingCart getCart() {
        return carrito;
    }

    public void setCart(ShoppingCart carrito) {
        this.carrito = carrito;
    }
    
    public void aniadirProducto(Product producto){
        ArrayList<Product> auxiliar = carrito.getCarro();
        auxiliar.add(producto);
        carrito.setCarro(auxiliar);
        this.notifyAllObserves();
    }
    
    public void eliminarProducto(Long idEliminar){
        ArrayList<Product> auxiliar = carrito.getCarro();
        int i;
        for(i = 0; i<auxiliar.size();i++){
            if(Objects.equals(auxiliar.get(i).getProductId(), idEliminar)){
                auxiliar.remove(i);
                break;
            }
        }
        carrito.setCarro(auxiliar);
        this.notifyAllObserves();
    }
    
    public boolean verificarExistencia(Long buscado){

        for(Product p : carrito.getCarro()){
            if(Objects.equals(p.getProductId(), buscado)){
                return true;
            }
        }
        return false;
    }
}