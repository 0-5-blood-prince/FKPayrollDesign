import java.util.*;
import java.time.*;
public class UnionCharges
{
	public HashMap <LocalDate , Double> Fees;
	public HashMap <LocalDate , Double> Dues;
	public double weeklyDueRate;
	UnionCharges(double weeklyDueRate)
	{
		this.Fees = new HashMap <LocalDate , Double> ();
		this.Dues = new HashMap <LocalDate , Double> ();
		this.weeklyDueRate = weeklyDueRate;
	}
	UnionCharges()
	{
		this.Fees = new HashMap <LocalDate , Double> ();
		this.Dues = new HashMap <LocalDate , Double> ();
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
	// public Double getDue(LocalDate d)
	// {
	// 	return Dues.get(d);
	// }
	public double calculateCharge(LocalDate d)
	{
		return 0;
	}
}