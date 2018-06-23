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
    this.func = new FunctionDescription("genericFunction", 3, args, "void", "public");
  }

  @Test
  public void toMessageTest() {
    setUp();
    String message = this.func.toMessage();
    assert (message).equals("Created function with void return type, called genericFunction and arguments as follows: a, b, c.");
  }
}
