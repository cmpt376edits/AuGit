// TODO add javadoc

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FunctionDescription {
  private String retType;
  private String functionName;
  private int numArgs;
  private List<String> args;
  private String accessMod;

  public FunctionDescription(
      String functionName, int numArgs, List<String> args, String retType, String accessMod) {
    this.functionName = functionName;
    this.numArgs = numArgs;
    this.args = args;
    this.retType = retType;
    this.accessMod = accessMod;
  }

  public String toMessage() { // Todo Args
    StringBuilder message = new StringBuilder();
    message.append("Created function ");
    if (this.getRetType().equals("void")) {
      message.append("with void return type, called ");
    } else {
      message.append("with ");
      message.append(this.getRetType());
      message.append(" return type, called ");
    }
    message.append(this.getFunctionName());
    message.append(" and arguments as follows: ");
    for (int j = 0; j < this.getArgs().size(); j++) {
      message.append(this.getArgs().get(j));
      if (j + 1 == this.getArgs().size()) {

      } else {
        message.append(", ");
      }
    }
    message.append(".");
    return message.toString();
  }

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
