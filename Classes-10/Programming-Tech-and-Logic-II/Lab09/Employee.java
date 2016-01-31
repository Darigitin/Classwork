public abstract class Employee
{
	private String employeeSSN;
	private String employeeName;
	private Department department;
	
	public Employee(String aEmployeeSSN, String aEmployeeName, Department aDepartment)
	{
		setEmployeeSSN(aEmployeeSSN);
		setEmployeeName(aEmployeeName);
		setDepartment(aDepartment);
		aDepartment.setEmployee(this);
	}
		
	//getter or accessor methods
	public String getEmployeeSSN()
	{		return employeeSSN; }
	
	public String getEmployeeName()
	{		return employeeName; }
	
	public Department getDepartment()
	{
		return department;
	}

	
	//setter or mutator methods
	
	public void setEmployeeSSN(String aEmployeeSNN)
	{	employeeSSN = aEmployeeSNN;	}
	
	public void setEmployeeName(String aEmployeeName)
	{	employeeName = aEmployeeName;	}					//attribute = passed argument
	
	public void setDepartment(Department aDepartment)
	{
		department = aDepartment;
	}
	
	public abstract double calcGrossPay();
	
	public String toString()
	{
		String formattedData = "";
		
		formattedData += "\nEmployee SSN: " + getEmployeeSSN() +
						 "\nEmployee Name: " + getEmployeeName();
		return formattedData;
	}
	
}