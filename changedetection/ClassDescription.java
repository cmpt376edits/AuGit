import java.util.ArrayList;

public class ClassDescription {

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public int getNumFunctions() {
    return numFunctions;
  }

  public void setNumArgs(int numFunctions) {
    this.numFunctions = numFunctions;
  }

  public ArrayList<String> getFunctions() {
    return args;
  }

  public void setFunctions(ArrayList<String> functions) {
    this.functions = functions;
  }

  public String getAccessModifier() {
    return retType;
  }

  public void setAccessModifier(String modifier) {
    this.accessModifier = modifier;
  }

  private String accessModifier;
  private String className;
  private int numFunctions;
  private ArrayList<String> functions;
  
  public FunctionDescription(String functionName, int numArgs, ArrayList<String> args, String modifier) {
    this.className = className;
    this.numFunctions = numFunctions;
    this.functions = functions;
    this.accessMdifier = modifier;
  }
}
