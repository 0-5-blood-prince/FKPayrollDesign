// import org.joda.time.LocalDate;
import java.util.*;
import java.time.*;
public class SalaryPay extends PaymentInfo
{
	private double commissionrate;
	private double salary;
	public HashMap <LocalDate , Double> Sales;
	SalaryPay(double salary,double commissionrate)
	{
		this.salary = salary;
		this.commissionrate = commissionrate;
		this.Sales = new HashMap <LocalDate , Double>();
	}  
	SalaryPay(double salary)
	{
		this(salary,0);
	}
	public void UpdateSalary(double salary)
	{
		this.salary = salary;
	}
	public Boolean isCommission()
	{
		return commissionrate!=0;
	}
	public void ChangeCommision(double commissionrate)
	{
		this.commissionrate = commissionrate;
	}
	public void UpdateSales(LocalDate d,double amount)
	{
		Sales.put(d, amount);
	}
	public Double getAmount(LocalDate d)
	{
		return Sales.get(d);
	}
	//Interface Methods
	public int gettype()
	{
		return 2;
	}
	public Boolean isPay(LocalDate d)
	{
		return d.getDayOfMonth()==d.lengthOfMonth(); 
	}
	public void clearSales()
	{
		Sales.clear();
	}
	public double calculatePay(LocalDate d)
	{
		if(isPay(d)){
			double pay = salary;
			Iterator it = Sales.entrySet().iterator(); 
	        while (it.hasNext()) { 
	        	Map.Entry elem = (Map.Entry)it.next();
	        	pay += ( (commissionrate ) * ((Double)elem.getValue()).doubleValue() );
	        }
	        return pay;

		}
		else
		{
			return 0;
		}
	}


}