public class UpdateComRate implements UpdateDetails{
    double rate;
    EmployeeDB db;
    int id;
    UpdateComRate(int id,double rate,EmployeeDB db)
    {
        this.rate = rate;
        this.db = db;
        this.id = id;
    }
    public void update()
    {
        Employee e = db.getEmployee(id);
        if(e.isSalaryPay())
        {
            PaymentInfo p = e.getPaymentInfo();
            ((SalaryPay)p).ChangeCommision(rate);
        }
    }
}
