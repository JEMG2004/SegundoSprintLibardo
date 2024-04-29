package co.com.hyunsedaOrder.Entity;

/**
 * Define el comportamiento común de todas las cuentas. Es una clase base concreta.
 *
 */
public class State {
    private Order context;

    public State(Order account) {
        setContext(account);
    }

    public Order getContext() {
        return context;
    }

    public void setContext(Order newAccount) {
        context = newAccount;
    }

    public State transitionState() {
        return null;
    }

    public State(State source) {
        setContext(source.getContext());
    }

    public static State InitialState(Order account) {
        return new NotSentState(account);
    }
    //deposito
    public boolean shipment(double additionalProducts) {
        double customerProducts = getContext().getProductsQuantity();
        getContext().setProductsQuantity(customerProducts + additionalProducts);
        transitionState();
        System.out.println("An amount of " + getContext().getProductsQuantity() + " will be delivered to your house");
        return true;
    }
	/*
	//Retiro
	public boolean withdraw(double amount) {
		double balance = getContext().getBalance();
		getContext().setBalance(balance - amount);
		transitionState();
		System.out.println("An amount " + amount + " is withdrawn ");
		return true;
	}

	 */
}
