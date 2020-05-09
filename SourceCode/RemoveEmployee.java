public class RemoveEmployee implements Action{
	int id;
	EmployeeDB db;
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
		if(db.isPresent(id))
		{
			db.removeEmployee(id,db.getEmployee(id));
		}
		else
		{
			System.out.println("Error: Given Id Not Found");
		}
	}
}