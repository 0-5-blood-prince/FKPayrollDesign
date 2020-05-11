import java.time.*;
public class SalesReceipt implements Action{
	private int id;
	private LocalDate date;
	private double amount;
	private EmployeeDB db;
	// int type;
	public SalesReceipt(int id,LocalDate date,double amount,EmployeeDB db)
	{
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.db = db;
		// this.type = 1;
	}
	public void Do()
	{
		//Implement Ispresent DB
		assert db.isPresent(id);
		if(db.isPresent(id))
		{
			Employee e = db.getEmployee(id);
			assert e.isSalaryPay();
			// db.removeEmployee(id,db.getEmployee(id));
			if(e.isSalaryPay())
			{
				//Not creating New References here
				SalaryPay p = (SalaryPay)e.getPaymentInfo();
				assert p.isCommission();
				if(p.isCommission())
				{
					p.UpdateSales(date,amount);
					e.UpdatePaymentInfo(p);
				}

			}

		}
	}
}