package ChangeDetectionTests;

import changedetection.ClassDescription;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FunctionDescriptionTest {

  private FunctionDescription func;

  private void setUp() {
    List<String> args = new ArrayList<>();
    args.add("a");
    args.add("b");
    args.add("c");
    this.func = new FunctionDescription("genericFunction", 3, args, "void", "public", false);
  }

  private void setUpDel() {
    List<String> args = new ArrayList<>();
    args.add("a");
    args.add("b");
    args.add("c");
    this.func = new FunctionDescription("genericFunction", 3, args, "void", "public", true);
  }

  @Test
  void toMessageTestNoArgs() {
    setUp();
    String message = this.func.toMessage();
    assert (message)
        .equals(
            "Created function with void return type, called genericFunction and arguments as follows: a, b, c.");
  }

  @Test
  void toMessageTestDeletedNoArgs() {
    setUpDel();
    String message = this.func.toMessage();
    assert (message)
        .equals(
            "Deleted function with void return type, called genericFunction and arguments as follows: a, b, c.");
  }

  @Test
  void toMessageTestZeroArg() {
    setUp();
    String message = this.func.toMessage(0);
    assert (message).equals("Created public function genericFunction.");
  }

  @Test
  void toMessageTestOneArg() {
    setUp();
    String message = this.func.toMessage(1);
    assert (message)
        .equals("Created public function genericFunction with the following argument(s) a b c .");
  }

  @Test
  void toMessageTestTwoArg() {
    setUp();
    String message = this.func.toMessage(2);
    assert (message)
        .equals(
            "Created public function genericFunction with the following argument(s) a b c and void return type.");
  }

  @Test
  void toMessageTestDeletedZeroArg() {
    setUpDel();
    String message = this.func.toMessage(0);
    assert (message).equals("Deleted public function genericFunction.");
  }

  @Test
  void toMessageTestDeletedOneArg() {
    setUpDel();
    String message = this.func.toMessage(1);
    assert (message)
        .equals("Deleted public function genericFunction with the following argument(s) a b c .");
  }

  @Test
  void toMessageTestDeletedTwoArg() {
    setUpDel();
    String message = this.func.toMessage(2);
    assert (message)
        .equals(
            "Deleted public function genericFunction with the following argument(s) a b c and void return type.");
  }
}
