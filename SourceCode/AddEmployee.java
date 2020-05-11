public class AddEmployee implements Action{
	private String name;
	private String address;
	private Double hourlyrate;
	private Double salary;
	private Double commissionrate;
	private EmployeeDB db;
	private int type;
	public AddEmployee(String name ,String address,double hourlyrate,EmployeeDB db)
	{
		this.name = name;
		this.address = address;
		this.hourlyrate = hourlyrate;
		this.db = db;
		this.type = 1;
	}
	public AddEmployee(String name, String address , double salary , double commissionrate,EmployeeDB db)
	{
		this.name = name;
		this.address= address;
		this.salary = salary;
		this.commissionrate = commissionrate;
		this.db = db;
		this.type = 2;
	}
	public void Do()
	{
		int empid = db.getLatestId();
		if(type==1)
		{
			HourlyPay p = new HourlyPay(hourlyrate);
			Employee e = new Employee(empid,name,address);
			e.UpdatePaymentInfo(p);
			db.addEmployee(empid,e);
		}
		else
		{
			SalaryPay p = new SalaryPay(salary,commissionrate);
			Employee e = new Employee(empid,name,address);
			e.UpdatePaymentInfo(p);
			db.addEmployee(empid,e);
		}
		assert db.isPresent(empid);
	}
}