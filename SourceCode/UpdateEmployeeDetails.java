public class UpdateEmployeeDetails implements UpdateDetails {
    public String name;
    public String address;
    public EmployeeDB db;
    public int id;
    UpdateEmployeeDetails(int id,String name,String address,EmployeeDB db)
    {
        this.name = name;
        this.address = address;
        this.db = db;
        this.id = id;
    }
    public void update()
    {
        Employee e = db.getEmployee(id);
        e.UpdateName(name);
        e.UpdateAddress(address);
    }
}
