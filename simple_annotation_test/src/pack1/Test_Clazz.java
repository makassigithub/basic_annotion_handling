package pack1;

import java.lang.reflect.*;
public class Test_Clazz {

	// let's annotate a method that uses the interface annotations
	@Interf(method_1 = "initialise the interface annotation method_1", method_2= 20)
	public static void this_meth(){
	//get an obj of the class using the annotation
		Test_Clazz c = new Test_Clazz();
	// get the corresponding Class obj. of this class
	// this method is subject to throwing an exception 
		try{
		Class <?> cl = c.getClass();
	 //get the method using the annotation
		
		Method m = cl.getMethod("this_meth");
	//get the annotation from this method, stored in reference of the container
		
	Interf itf = m.getAnnotation(Interf.class);
	
	//get the attribute values from the interface and print
	  System.out.println("The Attr. class value in the first method :" +itf.method_1()+ "\n" +
			 " The Attr. class value in the first method :" + itf.method_2());
	
		
		
		}catch(NoSuchMethodException nse) {
			System.out.println(nse.getMessage());
		}
	}
	public static void main(String[] args) {
	  this_meth();

	}

}
