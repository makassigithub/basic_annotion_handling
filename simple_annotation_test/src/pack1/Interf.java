package pack1;

import java.lang.annotation.*;

// This annotates the interface
@Retention(RetentionPolicy.RUNTIME)
@interface Interf {
  String method_1();
  int method_2();
	
}
