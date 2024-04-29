package co.com.hyunsedaOrder.Entity;


/**
 * Estado de la orden: Enviado. Recibe 5 productos gratis
 *
 */
public class SentState extends State {
    public SentState(Order account) {
        super(account);
    }

    public SentState(State source) {
        super(source);
    }

    public State transitionState() {
        double productsQuantity = getContext().getProductsQuantity();
        if (productsQuantity > Order.MIN_PRODUCTSQUANTITY && productsQuantity < Order.MAX_PRODUCTSQUANTITY) {
            getContext().setState(new SentState(this));
        }else {
            getContext().setState(new CancelledState(this));
        }
        return getContext().getState();
    }

    public boolean shipment(double additionalProducts) {
        double productsQuantity = getContext().getProductsQuantity();
        getContext().setProductsQuantity(productsQuantity + Order.FREE_PRODUCTS_SENT);
        System.out.println("You will receive 5 free products due to your order status (Sent)");
        return super.shipment(additionalProducts);
    }
	/*
	public boolean withdraw(double amount) {
		double balance = getContext().getBalance();
		if ((balance - Order.TRANS_FEE_NORMAL - amount) > Order.OVERDRAW_LIMIT) {
			getContext().setBalance(balance - Order.TRANS_FEE_NORMAL);
			System.out.println("Transaction Fee was charged due to "
					+ "account status " + "(less than minimum balance)");
			return super.withdraw(amount);
		} else {
			System.out.println(Order.ERR_OVERDRAW_LIMIT_EXCEED);
			return false;
		}
	}
	 */
}
