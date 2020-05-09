// import org.joda.time.LocalDate;
import java.util.*;
import java.time.*;
public class SalaryPay implements PaymentInfo
{
	private double commissionrate;
	private double salary;
	private HashMap <LocalDate , Double> Sales;
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
		Sales.put(d,new Double(amount));
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
	public double calculatePay(LocalDate d)
	{
		return 0;
	}


}