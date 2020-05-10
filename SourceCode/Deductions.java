import java.util.*;
import java.time.*;
public class Deductions
{
	public Due d;
	public UnionCharges uc;
	Deductions(double duerate)
	{
		d = new Due();
		uc = new UnionCharges(duerate);
	}
	public void updateDue(LocalDate date,double dueamount)
	{
		d.update(date,dueamount);
	}
	public double getDue(LocalDate date)
	{
		if(d.getDue(date)!=null)
		{
			return d.getDue(date);
		}
		return 0.0;
	}
	public void updateFee(LocalDate date,double fee)
	{
		uc.updateFee(date,fee);
	}
	public double getFee(LocalDate date)
	{
		if(uc.getFee(date)!=null)
		{
			return uc.getFee(date);
		}
		return 0.0;
	}
	//Weekly due part of Union Charges
	public void updateWeeklyDue(LocalDate date)
	{
		uc.updateDue(date);
	}
	// public double getWeeklyDue(LocalDate date)
	// {
	// 	if(wc.getDue(date)!=null)
	// 	{
	// 		return wc.getDue(date);
	// 	}
	// 	return 0.0;
	// }
	public void DisplayFees()
	{
		System.out.println(uc.Fees);
	}
	public void updateDueRate(double duerate)
	{
		uc.updateDueRate(duerate);
	}
	public void clearDeductions()
	{
		d.clearDues();
		uc.clearDues();
		uc.clearFees();
	}
	public double calculateDeductions(LocalDate date)
	{
		double dues = d.calculateDue(date);
		double servicecharges = uc.calculateCharge(date);
		return dues+servicecharges;
	}

}