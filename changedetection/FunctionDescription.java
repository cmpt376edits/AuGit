// TODO add javadoc

import java.util.ArrayList;
import java.util.Objects;

public class FunctionDescription {
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

  /*



  BOILERPLATE BELOW! Replace with Lombok . . .



   */

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    FunctionDescription that = (FunctionDescription) o;
    return numArgs == that.numArgs
        && Objects.equals(retType, that.retType)
        && Objects.equals(functionName, that.functionName)
        && Objects.equals(args, that.args)
        && Objects.equals(accessMod, that.accessMod);
  }

  @Override
  public String toString() {
    return "FunctionDescription{"
        + "retType='"
        + retType
        + '\''
        + ", functionName='"
        + functionName
        + '\''
        + ", numArgs="
        + numArgs
        + ", args="
        + args
        + ", accessMod='"
        + accessMod
        + '\''
        + '}';
  }

  @Override
  public int hashCode() {

    return Objects.hash(retType, functionName, numArgs, args, accessMod);
  }

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
}
