package services;

public class PaypalService implements OnlinePaymentService {

	private static final double PAYMENTE_FEE = 0.02;
	private static final double MONTHLY_INTEREST = 0.01;

	
	@Override
	public Double paymentFee(double amount) {
		return amount * PAYMENTE_FEE;
	}

	@Override
	public Double interest(double amount, int months) {
		return amount * months * MONTHLY_INTEREST;
	}

}
