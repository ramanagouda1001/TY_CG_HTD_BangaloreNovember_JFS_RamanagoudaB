// filename: Main.java 
class Test2 { 
	static int i; 
	final  static int j; 
	
	// start of static block 
	static { 
		i = 10; 
		j=10;
		System.out.println("static block called "); 
	} 
	// end of static block 
} 

class TestAnimal { 
	public static void main(String args[]) { 

		// Although we don't have an object of Test, static block is 
		// called because i is being accessed in following statement. 
		System.out.println(Test2.i); 
	} 
} 

