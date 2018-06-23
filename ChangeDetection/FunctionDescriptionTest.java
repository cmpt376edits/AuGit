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
    assert (message).equals("Created public function genericFunction.");
  }

  @Test
  public void toMessageTestOneArg() {
    setUp();
    String message = this.func.toMessage(1);
    assert (message)
        .equals("Created public function genericFunction with the following argument(s) a b c .");
  }

  @Test
  public void toMessageTestTwoArg() {
    setUp();
    String message = this.func.toMessage(2);
    assert (message)
        .equals(
            "Created public function genericFunction with the following argument(s) a b c and void return type.");
  }

  @Test
  public void toMessageTestDeletedZeroArg() {
    setUpDel();
    String message = this.func.toMessage(0);
    assert (message).equals("Deleted public function genericFunction.");
  }

  @Test
  public void toMessageTestDeletedOneArg() {
    setUpDel();
    String message = this.func.toMessage(1);
    assert (message)
        .equals("Deleted public function genericFunction with the following argument(s) a b c .");
  }

  @Test
  public void toMessageTestDeletedTwoArg() {
    setUpDel();
    String message = this.func.toMessage(2);
    assert (message)
        .equals(
            "Deleted public function genericFunction with the following argument(s) a b c and void return type.");
  }
}
