package co.com.hyunsedaOrder.Entity;


/**
 * Funcionalidad basica de una cuenta. Con ella el objeto cliente puede hacer operaciones de depósitos y retiros.
 *
 */
public class Order {
    //Contantes para definer los limites de las transacciones
    public static final double MIN_PRODUCTSQUANTITY = 1;
    public static final double MAX_PRODUCTSQUANTITY = 100;
    public static final double FREE_PRODUCTS_NOT_SENT = 1.00;
    public static final double FREE_PRODUCTS_RECEIVED = 2.00;
    public static final double FREE_PRODUCTS_PROCESSED = 3.00;
    public static final double FREE_PRODUCTS_EMBARKED = 4.00;
    public static final double FREE_PRODUCTS_SENT = 5.00;
    public static final double FREE_PRODUCTS_CANCELLED = 0.00;



    //public static final String ERR_OVERDRAW_LIMIT_EXCEED = "Error: Transaction cannot be processed. " + "Overdraw limit exceeded.";
    //Atributos
    private State objState;
    private String accountNumber;
    private double productsQuantity;

    public Order(String accountNum) {
        accountNumber = accountNum; //Número de cuenta del usuario que hizo la orden
        objState = State.InitialState(this); //El estado de esa orden
    }

    public void setState(State newState) {
        objState = newState;
    }

    public State getState() {
        return objState;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public boolean shipment(double additionalProducts) {
        return getState().shipment(additionalProducts);
    }

	/*
	public boolean withdraw(double amount) {
		return getState().withdraw(amount);
	}
	 */

    public double getProductsQuantity() {
        return productsQuantity;
    }

    public void setProductsQuantity(double newProductsQuantity) {
        productsQuantity = newProductsQuantity;
    }
}
