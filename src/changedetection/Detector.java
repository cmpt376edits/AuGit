package changedetection;

import java.util.ArrayList;

// TODO (rmartin) add some comments

public interface Detector {

  void detectFunctions(String origin, String current);

  void detectClasses(String origin, String current);

  String getMessageFunctionsJava();

  String getMessageClassesJava();
}
