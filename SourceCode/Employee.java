

import java.util.*;
// import SourceCode.*;
public class Employee{
	public int id;
	public String name;
	public String address;
	private Boolean isHourlyPay;
	private Boolean isSalaryPay;
	public PaymentInfo payment;

	public Employee(int id,String name,String address)
	{
		this.id = id;
		this.name = name;
		this.address = address;
	}
	void UpdateName(String name)
	{
		this.name = name;
	}
	void UpdateAddress(String address)
	{
		this.address = address;
	}
	void UpdatePaymentInfo(PaymentInfo p)
	{
			this.payment = p;
	}
	void setHourly()
	{
		return;
	}
	void setSalary()
	{
		return;
	}
}