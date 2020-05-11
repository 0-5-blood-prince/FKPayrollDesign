public class UpdateDueRate implements UpdateDetails{
    double rate;
    EmployeeDB db;
    int id;
    UpdateDueRate(int id,double rate,EmployeeDB db)
    {
        this.rate = rate;
        this.db = db;
        this.id = id;
    }
    public void update()
    {
        Employee e = db.getEmployee(id);
        if(e.isDeductOpen())
        {
            Deductions d = e.getDeductionInfo();
            d.updateDueRate(rate);
        }
    }
}
