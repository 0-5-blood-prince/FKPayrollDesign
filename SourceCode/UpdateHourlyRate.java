public class UpdateHourlyRate implements UpdateDetails{
    double rate;
    EmployeeDB db;
    int id;
    UpdateHourlyRate(int id,double rate,EmployeeDB db)
    {
        this.rate = rate;
        this.db = db;
        this.id = id;
    }
    public void update()
    {
        Employee e = db.getEmployee(id);
        if(e.isHourlyPay())
        {
            PaymentInfo p = e.getPaymentInfo();
            ((HourlyPay)p).UpdateHourlyrate(rate);
        }
    }
}
