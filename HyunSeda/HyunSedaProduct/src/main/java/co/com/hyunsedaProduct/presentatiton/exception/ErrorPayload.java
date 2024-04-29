package co.com.hyunsedaProduct.presentatiton.exception;

/**
 * Clase utilizada por la clase GlobalDefaultExceptionHandler para manejar los errores.
 */

import java.util.ArrayList;
import java.util.List;

public class ErrorPayload {

    public final List<ErrorJSON> errors;

    public ErrorPayload(List<ProductError> applicationErrors) {
        this.errors = new ArrayList<>();
        applicationErrors.forEach(applicationError -> errors.add(fromApplicationError(applicationError)));
    }

    private ErrorJSON fromApplicationError(ProductError error) {
        return new ErrorJSON(error.code, error.field, error.description);
    }
}
