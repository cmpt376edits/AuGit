// TODO add javadoc

import java.util.ArrayList;

public class FunctionDescription {

  public String getFunctionName() {
    return functionName;
  }

  public void setFunctionName(String functionName) {
    this.functionName = functionName;
  }

  public int getNumArgs() {
    return numArgs;
  }

  public void setNumArgs(int numArgs) {
    this.numArgs = numArgs;
  }

  public ArrayList<String> getArgs() {
    return args;
  }

  public void setArgs(ArrayList<String> args) {
    this.args = args;
  }

  public String getRetType() {
    return retType;
  }

  public void setRetType(String retType) {
    this.retType = retType;
  }

  public String getAccessMod() {
    return accessMod;
  }

  public void setAccessMod(String accessMod) {
    this.accessMod = accessMod;
  }

  private String retType;
  private String functionName;
  private int numArgs;
  private ArrayList<String> args;
  private String accessMod;

  public FunctionDescription(
      String functionName, int numArgs, ArrayList<String> args, String retType, String accessMod) {
    this.functionName = functionName;
    this.numArgs = numArgs;
    this.args = args;
    this.retType = retType;
    this.accessMod = accessMod;
  }
}
