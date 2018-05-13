import java.util.ArrayList;

public class FunctionDescription {
  private String functionName;
  private int numArgs;
  private ArrayList<String> args;

  public FunctionDescription(String functionName, int numArgs, ArrayList<String> args) {
    functionName = functionName;
    numArgs = numArgs;
    args = args;
  }
}
