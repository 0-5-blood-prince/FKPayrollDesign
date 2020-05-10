// package SourceCode;
import java.time.LocalDate;
public abstract class PaymentInfo
{
	//type 1 Hourly
	//type 2 Salary
	public PaymentInfo()
	{
	}
	public abstract int gettype();
	//If 0 not time
	public abstract Boolean isPay(LocalDate d);
	public abstract double calculatePay(LocalDate d);

}