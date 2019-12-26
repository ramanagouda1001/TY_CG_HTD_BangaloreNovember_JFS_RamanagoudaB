package com.capgemini.map;
public class Student 
{
	int stuAge;
	String stuName;
	public Student(int stuAge, String stuName) {
		super();
		this.stuAge = stuAge;
		this.stuName = stuName;
	}
	@Override
	public String toString() {
		return "Student [stuAge=" + stuAge + ", stuName=" + stuName + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + stuAge;
		result = prime * result + ((stuName == null) ? 0 : stuName.hashCode());
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
		Student other = (Student) obj;
		if (stuAge != other.stuAge)
			return false;
		if (stuName == null) {
			if (other.stuName != null)
				return false;
		} else if (!stuName.equals(other.stuName))
			return false;
		return true;
	}
	
}
