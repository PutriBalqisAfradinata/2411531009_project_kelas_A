package payment;

public class CashPayment implements Payment {

	@Override
	public String pay(double amount) {
	    return "SUCCESS";
	}

}
