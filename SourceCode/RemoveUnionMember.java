public class RemoveUnionMember implements Action{
	private int id;
	private EmployeeDB db;
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
		assert db.isPresent(id);
		if(db.isPresent(id))
		{
//			System.out.println(id);
//			System.out.println("Remove Union"+db.isInUnion(id));
			assert db.isInUnion(id);

			if(db.isInUnion(id))
			{
				Employee e = db.getEmployee(id);
				//Closing Union Service Account ie weekly due rate zero
				Deductions deduct = e.getDeductionInfo();
				deduct.updateDueRate(0);
				e.UpdateDeductionInfo(deduct);
				//So this means Deduction Account is open once opened
				db.removeMember(id);
			}

		}
		assert !db.isInUnion(id);
		assert db.isPresent(id);

	}
}