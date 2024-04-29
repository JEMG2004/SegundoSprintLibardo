package co.com.hyunsedaOrder.Entity;

/**
 * Estado cancelado: Recibe 0 productos gratis
 *
 */
public class CancelledState extends State {
    public void sendMailToAccountHolder() {
        System.out.println("Attention: Your order was cancelled");
    }

    public CancelledState(Order account) {
        super(account);
        sendMailToAccountHolder();
    }

    public CancelledState(State source) {
        super(source);
        sendMailToAccountHolder();
    }

    public State transitionState() {
        double productsQuantity = getContext().getProductsQuantity();
        if (productsQuantity > Order.MIN_PRODUCTSQUANTITY && productsQuantity < Order.MAX_PRODUCTSQUANTITY) {
            getContext().setState(new CancelledState(this));
        }else {
            getContext().setState(new CancelledState(this));
        }
        return getContext().getState();
    }

    public boolean shipment(double additionalProducts) {
        double productsQuantity = getContext().getProductsQuantity();
        getContext().setProductsQuantity(productsQuantity + Order.FREE_PRODUCTS_CANCELLED);
        System.out.println("You will receive 0 free products due to your order status (Cancelled)");
        return super.shipment(additionalProducts);
    }
/*
	public boolean withdraw(double amount) {
		double balance = getContext().getBalance();
		if ((balance - Order.TRANS_FEE_OVERDRAW - amount) > Order.OVERDRAW_LIMIT) {
			getContext().setBalance(
					balance - Order.TRANS_FEE_OVERDRAW);
			System.out.println("Transaction Fee was charged due to "
					+ "account status(Overdrawn)");
			return super.withdraw(amount);
		} else {
			System.out.println(Order.ERR_OVERDRAW_LIMIT_EXCEED);
			return false;
		}
	}

 */
}
