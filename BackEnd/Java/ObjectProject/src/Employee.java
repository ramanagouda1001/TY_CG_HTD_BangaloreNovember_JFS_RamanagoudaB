public class Employee 
{
	int empId;
	String empName;
	
	
	public Employee(int empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empId != other.empId)
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		return true;
	}


	public static void main(String[] args) 
	{
		Employee e1=new Employee(22,"rohan");
		Employee e2=new Employee(22,"rohan");
		Employee e3=new Employee(2299,"ro");

		System.out.println(e1.equals(e2));
		System.out.println(e1.hashCode());

		System.out.println(e2.hashCode());

		System.out.println(e3.hashCode());
	}
}
