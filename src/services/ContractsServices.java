package services;

import java.util.Calendar;
import java.util.Date;

import entities.Contracts;
import entities.Installments;

public class ContractsServices {

	private OnlinePaymentService onlinePaymentService;
	
	public ContractsServices(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContracts(Contracts contracts, int months) {
		double basicQuota = contracts.getTotalValue() / months;
		for(int i=1; i<= months; i++) {
			double updateQuota = basicQuota + onlinePaymentService.interest(basicQuota, i);
			
			double fullQuota = updateQuota + onlinePaymentService.paymentFee(updateQuota);
			
			Date dueDate = addMonths(contracts.getDate(), i);
			
			contracts.getInstallments().add(new Installments(dueDate,fullQuota));
			
		}
	}
	
	private Date addMonths(Date date,int m) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, m);
		
		return calendar.getTime();
	}
	
}
