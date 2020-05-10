import java.time.*;
public class PayrollRun implements Action
{
	LocalDate date;
	EmployeeDB db;
	PayrollRun(EmployeeDB db,LocalDate date)
	{
		this.date = date;
		this.db = db;
	}
	public void Do()
	{
		for(Employee e : db.getDB().values())
		{
			////Posting receipts
			
				if(e.isHourlyPay())
				{
						////Post Time Card from Sales json file
					   if(db.isInUnion(e.id))
					   {
					   		//Frriday
					   		//PostWeeklyDue and UnionFees
					   	  
					   }
				}
				if(e.isSalaryPay())
				{
					if( ((SalaryPay)e.getPaymentInfo()).isCommission())
					{
						//Post Sales Receipt
					}
					 if(db.isInUnion(e.id))
					   {
					   	//Frriday
					   		//PostWeeklyDue and UnionFees
					   }
				}
			if(e.getPaymentInfo().isPay(date))
			{
				if(e.isHourlyPay())
				{
						PaymentInfo p = e.getPaymentInfo();
						double pay = p.calculatePay(date);
						//Clear all Time cards
						((HourlyPay)p).Clear();
						double deduct = 0;
					   if(db.isInUnion(e.id))
					   {
					   		
					   	   if(e.getPaymentInfo().isPay(date))
					   	   {
					   	   		Deductions d = e.getDeductionInfo();
					   	   		deduct += d.calculateDeductions(date);
					   	   		d.clearDeductions();
					   	   }
					   }
					   if(pay-deduct>=0){

					   }
					   else{

					   }
				}
				if(e.isSalaryPay())
				{
					PaymentInfo p = e.getPaymentInfo();
					double pay = p.calculatePay(date);
					//Clearing Sales
					((SalaryPay)p).clearSales();
					double deduct = 0;
					 if(db.isInUnion(e.id))
					   {
					   	   if(e.getPaymentInfo().isPay(date))
					   	   {
					   	   		Deductions d = e.getDeductionInfo();
					   	   		deduct += d.calculateDeductions(date);
					   	   		d.clearDeductions();
					   	   }
					   }

					   if(pay-deduct>=0){

					   }
					   else{

					   }
				}
			}
		}
	}
}