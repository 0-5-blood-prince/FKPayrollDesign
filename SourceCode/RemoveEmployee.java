public class RemoveEmployee implements Action{
	private int id;
	private EmployeeDB db;
	// int type;
	public RemoveEmployee(int id,EmployeeDB db)
	{
		this.id = id;
		this.db = db;
		// this.type = 1;
	}
	public void Do()
	{
		//Implement Ispresent DB
		assert(db.isPresent(id));
		if(db.isPresent(id)) db.removeEmployee(id);
		assert !db.isPresent(id);
	}
}