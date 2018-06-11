// TODO add javadoc

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

  public ArrayList<FunctionDescription> getFunctions() {
    return functions;
  }

  public void setFunctions(ArrayList<FunctionDescription> functions) {
    this.functions = functions;
  }

  public String getAccessModifier() {
    return this.accessModifier;
  }

  public void setAccessModifier(String modifier) {
    this.accessModifier = modifier;
  }

  private String accessModifier;
  private String className;
  private int numFunctions;
  private ArrayList<FunctionDescription> functions;

  public ClassDescription(
      String className, int numArgs, ArrayList<FunctionDescription> args, String modifier) {
    this.className = className;
    this.numFunctions = numFunctions;
    this.functions = functions;
    this.accessModifier = modifier;
  }
}
