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
  private boolean delStat;

  public FunctionDescription(
      String functionName,
      int numArgs,
      List<String> args,
      String retType,
      String accessMod,
      boolean delStat) {
    this.functionName = functionName;
    this.numArgs = numArgs;
    this.args = args;
    this.retType = retType;
    this.accessMod = accessMod;
    this.delStat = delStat;
  }

  public String toMessage() {
    StringBuilder message = new StringBuilder();
    if (this.isDelStat()) {
      message.append("Deleted function ");
    }else{
      message.append("Created function ");
    }
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

  public String toMessage(int arg) {
    StringBuilder message = new StringBuilder();
    if (this.isDelStat()) {
      message.append("Deleted ");
    }else{
      message.append("Created ");
    }
    message.append(this.getAccessMod());
    message.append(" function ");
    if (arg == 0 || arg == 1 || arg == 2) {
      message.append(this.getFunctionName());
      message.append('.');
    }
    if (arg == 1 || arg == 2) {
      message.deleteCharAt(message.length() - 1);
      if (this.getNumArgs() > 0) {
        message.append(" with the following argument(s) ");
        for (String s : this.getArgs()) {
          message.append(s + " ");
        }
        message.append('.');
      } else {
        message.append("with no arguments.");
      }
    }
    if (arg == 2) {
      message.deleteCharAt(message.length() - 1);
      message.append("and ");
      message.append(this.getRetType());
      message.append(" return type.");
    }
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

  private String getFunctionName() {
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

  public List<String> getArgs() {
    return args;
  }

  public void setArgs(ArrayList<String> args) {
    this.args = args;
  }

  private String getRetType() {
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

  public void setArgs(List<String> args) {
    this.args = args;
  }

  public boolean isDelStat() {
    return delStat;
  }

  public void setDelStat(boolean delStat) {
    this.delStat = delStat;
  }
}
