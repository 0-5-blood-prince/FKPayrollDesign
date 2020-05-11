public class AddUnionMember implements Action{
	private int id;
    private double weeklydue;
	private EmployeeDB db;
	// int type;
	public AddUnionMember(int id,double weeklydue,EmployeeDB db)
	{
		this.id = id;
		this.db = db;
		// this.type = 1;
		this.weeklydue = weeklydue;
	}
	public void Do()
	{
		//Implement Ispresent DB
		assert (db.isPresent(id));
		if(db.isPresent(id))
		{
			assert !db.isInUnion(id);
			if (db.isInUnion(id)) {
				return;
			}
			//Modify deduct account in Employee
			//Opening a deduction Account

			Employee e = db.getEmployee(id);
			if(e.isDeductOpen())
			{
				//Can be if Only due is present then update weeklydue
				Deductions deduct = e.getDeductionInfo();
				deduct.updateDueRate(weeklydue);
				e.UpdateDeductionInfo(deduct);
			}
			else
			{
				Deductions deduct = new Deductions(weeklydue);
				e.UpdateDeductionInfo(deduct);
			}
			db.addMember(id,e);
		}
		assert db.isInUnion(id);
	}
}