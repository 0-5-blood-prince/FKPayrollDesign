// import SourceCode.*;
public class Employee{
	enum PaymentType
	{
		HOURLY , SALARY ;
	}
	public int id;
	public String name;
	public String address;
	public transient PaymentInfo payment;
    private PaymentType ptype;
    public transient Deductions deduct;
	public Employee(int id,String name,String address)
	{
		this.id = id;
		this.name = name;
		this.address = address;
		// this.deduct = new Deductions();
	}
	public void UpdateName(String name)
	{
		this.name = name;
	}
	public void UpdateAddress(String address)
	{
		this.address = address;
	}
	public void UpdatePaymentInfo(PaymentInfo p)
	{
			this.payment = p;
			if(p.gettype()==1)
			{	
				this.ptype = PaymentType.HOURLY;
			}
			if(p.gettype()==2)
			{
			    this.ptype = PaymentType.SALARY;
			}
	}
	public Deductions getDeductionInfo()
	{
		return this.deduct;
	}
	public Boolean isDeductOpen()
	{
		return this.deduct!=null;
	}
	public void UpdateDeductionInfo(Deductions d)
	{
		this.deduct = d;
	}
	public Boolean isHourlyPay()
	{
		return this.ptype.ordinal()==0;
	}
	public Boolean isSalaryPay()
	{
		return this.ptype.ordinal()==1;
	}
	public PaymentInfo getPaymentInfo()
	{
		return this.payment;
	}
	
}