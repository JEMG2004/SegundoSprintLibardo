package co.com.hyunsedaProduct.presentatiton.exception;

import java.util.List;

/**
 * Lista de errores del dominio para un producto
 */

public class ProductDomainException extends Exception {

    /** Listado de errores*/
    public final List<ProductError> errors;
    public ProductDomainException(List<ProductError> errors) {
        this.errors = errors;
    }
}
