
import java.util.*;
public class Tester
{
	public static void TestAddEmployee(EmployeeDB db)
	{
		AddEmployee a = new AddEmployee("Mooizz","Hey jude",0.9,db);
		AddEmployee b = new AddEmployee("ABdul","Hey JUne",10000.0,0.8,db);
		a.Do();
		b.Do();
	}
	public static void main(String[] args) {
		EmployeeDB db = new EmployeeDB();
		TestAddEmployee(db);
		db.DisplayEmployees();

	}
}