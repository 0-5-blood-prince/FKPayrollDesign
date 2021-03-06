import java.time.*;
public class ServiceFee implements Action{
	private int id;
	private LocalDate date;
	private double fee;
	private EmployeeDB db;
	// int type;
	public ServiceFee(int id,LocalDate date,double fee,EmployeeDB db)
	{
		this.id = id;
		this.date = date;
		this.fee = fee;
		this.db = db;
		// this.type = 1;
	}
	public void Do()
	{
		//Implement Ispresent DB
		assert db.isPresent(id);
		if(db.isPresent(id))
		{

			// db.removeEmployee(id,db.getEmployee(id));
			assert db.isInUnion(id);
			if(db.isInUnion(id))
			{
				//Not creating New References here
				Employee e = db.getMember(id);
				Deductions deduct = e.getDeductionInfo();
				deduct.updateFee(date,fee);
				e.UpdateDeductionInfo(deduct);
				
			}

			
		}

	}
}