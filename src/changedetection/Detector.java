package changedetection;

import java.util.ArrayList;

// TODO (rmartin) add some comments

public interface Detector {

  // This function takes the origin (last commited code), and current code and finds the newly defined or deleted
  // functions between the two and sets the detectors function list to a list of function description objects.
  void detectFunctions(String origin, String current);

  void detectClasses(String origin, String current);

  String getMessageFunctionsJava();

  String getMessageClassesJava();
}
