
import java.time.LocalDate;
public interface PaymentInfo
{
	//type 1 Hourly
	//type 2 Salary
	public int gettype();
	//If 0 not time
	public Boolean isPay(LocalDate d);
	public double calculatePay(LocalDate d);

}