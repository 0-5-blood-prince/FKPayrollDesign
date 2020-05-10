// package SourceCode;
// import SourceCode.*;

//import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

// import java.io.IOException;
// // import com.fasterxml.jackson.core.JsonGenerationException;
// import com.fasterxml.jackson.databind.JsonMappingException;
// import com.fasterxml.jackson.databind.ObjectMapper;
public class EmployeeDB{
	//static vs non static
	//Will decide later
	//		static is best
	//Integer cause No primitive in generics
//	Gson gson = new Gson();
	private static HashMap < Integer, Employee > DB = new HashMap<>();
	private static HashMap < Integer, Employee > UnionDB = new HashMap<>();
	private static int LatestId  = 0; 
//	private static int LatestMemId = 0;
	EmployeeDB()
	{
		System.out.println("DataBase_Object_Obtained");
//		String jsonString = gson.toJson("String");
//		System.out.println(jsonString);
	}
	public int getLatestId()
	{
		LatestId+=1;
		return LatestId;
	}

	public void addMember(int id , Employee e)
	{
		UnionDB.put(id,e);
	}
	public void removeMember(int id , Employee e)
	{
		UnionDB.remove(id);
	}
	public Boolean isInUnion(int id)
	{
		return UnionDB.containsKey(id);
	}
	public void addEmployee(int id , Employee e)
	{
		DB.put(id,e);
	}
	public void removeEmployee(int id , Employee e)
	{
		DB.remove(id);
		if(this.isInUnion(id)) this.removeMember(id,e);
	}
	public Employee getEmployee(int id)
	{
		return DB.get(id);
	}
	public Employee getMember(int id)
	{
		Employee e = UnionDB.get(id);
		if(e.equals(getEmployee(id))) {
			return e;
		}
		else
		{
			return null;
		}
	}
	public Boolean isPresent(int id)
	{
		return DB.containsKey(id);
	}
	public HashMap<Integer,Employee> getDB()
	{
		return DB;
	}
	public void DisplayEmployees()
	{
		System.out.println("EmployeeID	Name");
		for (Map.Entry<Integer,Employee> entry : DB.entrySet())
		{
			System.out.println(entry.getKey()+"		"+entry.getValue().name);
		}
	}
	public void DisplayMembers()
	{
		System.out.println("MemberID	Name");
		for (Map.Entry<Integer,Employee> entry : UnionDB.entrySet())
		{
			System.out.println(entry.getKey()+"		"+entry.getValue().name);
		}
	}

}