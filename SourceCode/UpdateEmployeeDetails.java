public class UpdateEmployeeDetails implements UpdateDetails {
    private String name;
    private String address;
    private EmployeeDB db;
    private int id;
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
