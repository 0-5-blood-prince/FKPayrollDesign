// import org.joda.time.LocalDate;
import java.util.*;
import java.time.LocalDate;
public class HourlyPay extends PaymentInfo
{
	private double hourlyrate;
	public HashMap <LocalDate , Double> HourMap;
	HourlyPay(double hourlyrate)
	{
		this.hourlyrate = hourlyrate;
		// this.commissionrate = commissionrate;
		this.HourMap = new HashMap<>();
	}  
	
	public void UpdateHourlyrate(double rate)
	{
		this.hourlyrate = rate;
	}
	public void UpdateHours(LocalDate d,double hours)
	{
		HourMap.put(d, hours);
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
	public void Clear()
	{
		HourMap.clear();
	}
	public double calculatePay(LocalDate d)
	{
		if(isPay(d))
		{
			double pay = 0;
			Iterator it = HourMap.entrySet().iterator(); 
	        while (it.hasNext()) { 
	        	Map.Entry elem = (Map.Entry)it.next();
	        	double hours =((Double)elem.getValue()).doubleValue();
	        	if(hours>8.0)
	        	{
	        		pay+= ( hourlyrate * hours)+(hourlyrate*(hours-8)/2);
	        	}
	        	else
	        	{
	        		pay+= hourlyrate * hours;
	        	}
	        	return pay;
	        
	        }
		}
			return 0;
	}


}