import java.util.*;
import java.time.*;
public class Due
{
	public HashMap <LocalDate , Double> Dues;
	Due()
	{
		this.Dues = new HashMap <LocalDate , Double> ();
	}
	public void update(LocalDate d, double a)
	{
		Dues.put(d,a);
	}
	public Double getDue(LocalDate d)
	{
		return Dues.get(d);
	}
	public double calculateDue(LocalDate d)
	{
		return 0;
	}
}