public class RemoveUnionMember implements Action{
	int id;
	EmployeeDB db;
	// int type;
	public RemoveUnionMember(int id,EmployeeDB db)
	{
		this.id = id;
		this.db = db;
		// this.type = 1;
	}
	public void Do()
	{
		//Implement Ispresent DB
		if(db.isPresent(id))
		{
			if(db.isInUnion(id))
			{
				Employee e = db.getEmployee(id);
				//Closing Union Service Account ie weekly due rate zero
				Deductions deduct = e.getDeductionInfo();
				deduct.updateDueRate(0);
				e.UpdateDeductionInfo(deduct);
				//So this means Deduction Account is open once opened
				db.removeMember(id,db.getEmployee(id));
			}
			else
			{
				
				System.out.println("Error: Given id Not in Union");
			}
		}
		else
		{
			System.out.println("Error: Given Id Not Found");
		}
	}
}