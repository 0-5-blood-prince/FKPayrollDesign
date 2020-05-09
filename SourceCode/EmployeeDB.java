import java.util.*;
public class EmployeeDB{
	//static vs non static
	//Will decide later
	//		static is best
	//Integer cause No primitive in generics
	private static HashMap < Integer, Employee > DB = new HashMap <Integer , Employee>();
	private static int LatestId  = 0;
	EmployeeDB()
	{
		System.out.println("DataBase_Object_Obtained");
	}
	public int getLatestId()
	{
		LatestId+=1;
		return LatestId;
	}
	public void addEmployee(int id , Employee e)
	{
		DB.put(id,e);
	}
	public void removeEmployee(int id , Employee e)
	{
		DB.remove(id);
	}
	public Employee getEmployee(int id)
	{
		return DB.get(id);
	}
	public Boolean isPresent(int id)
	{
		return DB.containsKey(id);
	}
	public void DisplayEmployees()
	{
		System.out.println("EmployeeID	Name");
		for (Map.Entry<Integer,Employee> entry : DB.entrySet())
		{
			System.out.println(entry.getKey()+"		"+entry.getValue().name);
		}
	}

}