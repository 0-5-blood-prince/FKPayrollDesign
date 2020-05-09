

import java.util.*;
// import SourceCode.*;
public class Employee{
	enum PaymentType
	{
		HOURLY , SALARY ;
	}
	public int id;
	public String name;
	public String address;
	public PaymentInfo payment;
    private PaymentType ptype;
	public Employee(int id,String name,String address)
	{
		this.id = id;
		this.name = name;
		this.address = address;
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