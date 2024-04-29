package co.com.hyunsedaProduct.presentatiton.exception;

import co.com.hyunsedaProduct.domain.service.ErrorCodes;

/**
 *Error de un producto
 */

public class ProductError {

    /**
     * Codigo del error
     */
    public final ErrorCodes code;
    /**
     * Campo del error
     */
    public final String field;
    /**
     * Descripción del error
     */
    public final String description;

    public ProductError(ErrorCodes code, String field, String description) {
        this.code = code;
        this.field = field;
        this.description = description;
    }
}
