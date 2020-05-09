import java.time.*;
public class PostTimeCard implements Action{
	private int id;
	private LocalDate date;
	private double hours;
	private EmployeeDB db;
	// int type;
	public PostTimeCard(int id,LocalDate date,double hours,EmployeeDB db)
	{
		this.id = id;
		this.date = date;
		this.hours =hours;
		this.db = db;
		// this.type = 1;
	}
	public void Do()
	{
		//Implement Ispresent DB
		if(db.isPresent(id))
		{
			Employee e = db.getEmployee(id);
			// db.removeEmployee(id,db.getEmployee(id));
			if(e.isHourlyPay())
			{
				//Not creating New References here
				HourlyPay p = (HourlyPay)e.getPaymentInfo();
				p.UpdateHours(date,hours);
				e.UpdatePaymentInfo(p);
			}
			else
			{
				System.out.println("Error: Not Hourly Pay");
			}
			
		}
		else
		{
			System.out.println("Error: Given Id Not Found");
		}
	}
}