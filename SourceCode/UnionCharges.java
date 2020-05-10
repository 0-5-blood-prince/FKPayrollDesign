import java.time.LocalDate;
import java.util.*;

public class UnionCharges
{
	public HashMap <LocalDate , Double> Fees;
	public HashMap <LocalDate , Double> Dues;
	public double weeklyDueRate;
	UnionCharges(double weeklyDueRate)
	{
		this.Fees = new HashMap<>();
		this.Dues = new HashMap<>();
		this.weeklyDueRate = weeklyDueRate;
	}
	UnionCharges()
	{
		this.Fees = new HashMap<>();
		this.Dues = new HashMap<>();
		this.weeklyDueRate = 0;
	}
	public void updateFee(LocalDate d, double a)
	{
		Fees.put(d,a);
	}
	public Double getFee(LocalDate d)
	{
		return Fees.get(d);
	}
	public void updateDueRate(double duerate)
	{
		this.weeklyDueRate = duerate;
	}
	public void updateDue(LocalDate d)
	{
		Dues.put(d,this.weeklyDueRate);
	}

	public void clearDues()
	{
		Dues.clear();
	}
	public void clearFees()
	{
		Fees.clear();
	}
	public double calculateCharge(LocalDate d)
	{
		double deduce = 0;
			Iterator it = Dues.entrySet().iterator(); 
	        while (it.hasNext()) { 
	        	Map.Entry elem = (Map.Entry)it.next();
	        	deduce += ( ((Double)elem.getValue()).doubleValue());
	        }
			it = Fees.entrySet().iterator(); 
	        while (it.hasNext()) { 
	        	Map.Entry elem = (Map.Entry)it.next();
	        	deduce += (((Double)elem.getValue()).doubleValue());
	        }
		return deduce;
	}
}