import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
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
	public static void TestSalesReceipt(EmployeeDB db)
	{
		SalesReceipt a = new SalesReceipt(1,LocalDate.now(),7000,db);
		a.Do();
				SalesReceipt b = new SalesReceipt(6,LocalDate.now(),5000,db);
				b.Do();
			System.out.println( ((SalaryPay)db.getEmployee(6).payment).Sales );

	}
	public static void CheckUnionMemberChanges(EmployeeDB db)
	{
		AddUnionMember a = new AddUnionMember(1,600,db);
		AddUnionMember b = new AddUnionMember(3,800,db);
		a.Do();b.Do();
		db.DisplayMembers();
		RemoveUnionMember c = new RemoveUnionMember(2,db);
		RemoveUnionMember d = new RemoveUnionMember(1,db);
		c.Do();d.Do();
		db.DisplayMembers();

	}
	public static void TestServiceFee(EmployeeDB db)
	{
		ServiceFee a = new ServiceFee(1,LocalDate.now(),7000,db);
		a.Do();
				ServiceFee b = new ServiceFee(3,LocalDate.now(),5000,db);
				b.Do();
		db.getEmployee(3).deduct.DisplayFees();

	}
	public void createEmployeeDBandMemberDB()
	{

	}
	public static void main(String[] args) throws IOException {
		EmployeeDB db = new EmployeeDB();



		//Testing Add
		TestAddEmployee(db);
		db.DisplayEmployees();
		Gson gson = new Gson();

		String jsonString = gson.toJson(db.getDB());
		Type type = new TypeToken<HashMap<Integer, Employee>>(){}.getType();
		HashMap<Integer, Employee> clonedMap = gson.fromJson(jsonString, type);
		FileWriter myWriter = new FileWriter("Database.json");
		myWriter.write(jsonString);
		myWriter.close();
		System.out.println(jsonString);
		//Testing Remove
		TestRemoveEmployee(db);
		db.DisplayEmployees();
		TestPostTimeCard(db);
		db.DisplayEmployees();
		TestSalesReceipt(db);
		db.DisplayEmployees();
		CheckUnionMemberChanges(db);
		TestServiceFee(db);
		System.out.println("Cloned Map is");
		System.out.println(clonedMap);

	}
}