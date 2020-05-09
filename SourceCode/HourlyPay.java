// import org.joda.time.LocalDate;
import java.util.*;
import java.time.LocalDate;
public class HourlyPay implements PaymentInfo
{
	private double hourlyrate;
	public HashMap <LocalDate , Double> HourMap;
	HourlyPay(double hourlyrate)
	{
		this.hourlyrate = hourlyrate;
		// this.commissionrate = commissionrate;
		this.HourMap = new HashMap <LocalDate , Double>();
	}  
	
	public void UpdateHourlyrate(double rate)
	{
		this.hourlyrate = rate;
	}
	public void UpdateHours(LocalDate d,double hours)
	{
		HourMap.put(d,new Double(hours));
	}
	public Double getHours(LocalDate d)
	{
		return HourMap.get(d);
	}
	//Interface Methods
	public int gettype()
	{
		return 1;
	}
	public Boolean isPay(LocalDate d)
	{
		return d.getDayOfWeek().getValue()==5; 
	}
	public double calculatePay(LocalDate d)
	{
		return 0;
	}


}