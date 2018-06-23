import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FunctionDescriptionTest {

  private FunctionDescription func;

  public void setUp() {
    System.out.println("Hello");
    List<String> args = new ArrayList<>();
    args.add("a");
    args.add("b");
    args.add("c");
    this.func = new FunctionDescription("genericFunction", 3, args, "void", "public");
  }

  @Test
  public void toMessageTest() {}
}
