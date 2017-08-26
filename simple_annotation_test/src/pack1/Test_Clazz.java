package pack1;

import java.lang.reflect.*;

public class Test_Clazz {

	// let's annotate a method that uses the interface annotations
	@Interf(method_1 = "initialise the interface annotation method_1", method_2 = 20)
	public static void this_meth() {

		//Get an instance of this class
		Test_Clazz c = new Test_Clazz();
		
		// get the corresponding Class obj. of this class using reflexion;
		// getClass() is subject to throwing an exception
		try {
			Class<?> cl = c.getClass();
			
			// get the method that uses the annotation
			Method m = cl.getMethod("this_meth");
			
			//The annotation is of the type of the interface
			Interf annotations = m.getAnnotation(Interf.class);

			// get the attribute values from the interface and print
			System.out.println("The Attr. value in the first method :" + annotations.method_1() + "\n"
					+ "The Attr. value in the first method :" + annotations.method_2());

		} catch (NoSuchMethodException nse) {
			System.out.println(nse.getMessage());
		}
	}

	// the second method takes parameters
	@Interf(method_1 = "the second meth with param", method_2 = 13)
	public static void this_meth2(String s, int i) {

		// Instance of the class that contains the methods
		Test_Clazz tc = new Test_Clazz();

		try {
			// The Class object of the Test_Clazz instance
			Class<?> cl = tc.getClass();

			// get the annotated Method object.Must explicitly provide the
			// parameter list
			Method m = cl.getMethod("this_meth2", String.class, int.class);

			// get the annotation from the method.
			// Interf.class is an Class object of the interface
			Interf intf = m.getAnnotation(Interf.class);

			// get and print the annotations

			System.out.println("method_2 attr1 value: " + intf.method_1());
			System.out.println("method_2 attr value: " + intf.method_2());

		} catch (NoSuchMethodException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		this_meth();
		System.out.println();
		System.out.println("NB: \nthe params in this_meth2() are just used to show" + "\n"
				+ "how annotation works with them, their are not used in method body");
		this_meth2("theStringParam", 30);
	}

}
