//Pressure calculation

public class Pressure
{
	public static void main(String[] args)
	{
		double force = 172.5;
		double area = 27.5;
		double pressure;
		
		pressure = area / force;
		
		System.out.println("The pressure is " + pressure);
	}
}
