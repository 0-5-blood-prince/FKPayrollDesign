
import java.util.*;
import java.time.*;
public class Tester
{
	public static void TestAddEmployee(EmployeeDB db)
	{
		AddEmployee a = new AddEmployee("Mooizz","Hey jude",0.9,db);
		AddEmployee b = new AddEmployee("ABdul","Hey JUne",90000.0,0.8,db);
		AddEmployee c = new AddEmployee("buchhu","Hey jude",0.9,db);
		AddEmployee d = new AddEmployee("Tuss","Hey JUne",1000.0,0,db);
		AddEmployee e = new AddEmployee("Hass","Hey jude",0.9,db);
		AddEmployee f = new AddEmployee("Buss","Hey JUne",100,0.8,db);
		a.Do();
		b.Do();c.Do();d.Do();e.Do();f.Do();
	}
	public static void TestRemoveEmployee(EmployeeDB db)
	{
		RemoveEmployee a = new RemoveEmployee(2,db);
		RemoveEmployee b = new RemoveEmployee(5,db);
		a.Do();
		b.Do();
	}
	public static void TestPostTimeCard(EmployeeDB db)
	{
		PostTimeCard a = new PostTimeCard(1,LocalDate.now(),7,db);
		a.Do();
				PostTimeCard b = new PostTimeCard(4,LocalDate.now(),5,db);
				b.Do();
			System.out.println( ((HourlyPay)db.getEmployee(1).payment).HourMap );

	}
	public static void main(String[] args) {
		EmployeeDB db = new EmployeeDB();
		//Testing Add
		TestAddEmployee(db);
		db.DisplayEmployees();
		//Testing Remove
		TestRemoveEmployee(db);
		db.DisplayEmployees();
		TestPostTimeCard(db);
		db.DisplayEmployees();
	}
}