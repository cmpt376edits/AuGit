import java.util.ArrayList;

public interface Detector {

  void detectFunctions(String origin, String current);

  void detectClasses(String origin, String current);

  String getMessageFunctionsJava(ArrayList<FunctionDescription> functionDescriptions);

  String getMessageClassesJava(ArrayList<ClassDescription> classDescriptions);
}
