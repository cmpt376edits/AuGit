import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FunctionDescriptionTest {

  private FunctionDescription func;

  public void setUp() {
    List<String> args = new ArrayList<>();
    args.add("a");
    args.add("b");
    args.add("c");
    this.func = new FunctionDescription("genericFunction", 3, args, "void", "public", false);
  }

  public void setUpDel() {
    List<String> args = new ArrayList<>();
    args.add("a");
    args.add("b");
    args.add("c");
    this.func = new FunctionDescription("genericFunction", 3, args, "void", "public", true);
  }

  @Test
  public void toMessageTestNoArgs() {
    setUp();
    String message = this.func.toMessage();
    assert (message)
        .equals(
            "Created function with void return type, called genericFunction and arguments as follows: a, b, c.");
  }

  @Test
  public void toMessageTestDeletedNoArgs() {
    setUpDel();
    String message = this.func.toMessage();
    assert (message)
        .equals(
            "Deleted function with void return type, called genericFunction and arguments as follows: a, b, c.");
  }

  @Test
  public void toMessageTestZeroArg() {
    setUp();
    String message = this.func.toMessage(0);
    System.out.println(message);
    assert (message)
        .equals(
            "Deleted function with void return type, called genericFunction and arguments as follows: a, b, c.");
  }
}
