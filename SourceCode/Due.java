import java.util.*;
import java.time.*;
public class Due
{
	public HashMap <LocalDate , Double> Dues;
	Due()
	{
		this.Dues = new HashMap<>();
	}
	public void update(LocalDate d, double a)
	{
		Dues.put(d,a);
	}
	public Double getDue(LocalDate d)
	{
		return Dues.get(d);
	}
	public void clearDues()
	{
		Dues.clear();
	}
	public double calculateDue(LocalDate d)
	{
		//Not called Unless its PayDay
		double deduce = 0;
			Iterator it = Dues.entrySet().iterator(); 
	        while (it.hasNext()) { 
	        	Map.Entry elem = (Map.Entry)it.next();
	        	deduce += ((Double)elem.getValue()).doubleValue();
	        }
	        return deduce;
	}
}