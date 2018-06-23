import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class JavaDetectorImplTest {

  private static final String SAMPLE_CODE_ORIGIN = "";

  private static final String SAMPLE_CODE_CURRENT =
      "  public boolean equals(Object o) {\n"
          + "    if (this == o) return true;\n"
          + "    if (o == null || getClass() != o.getClass()) return false;\n"
          + "    JavaDetectorImpl that = (JavaDetectorImpl) o;\n"
          + "    return Objects.equals(reserved, that.reserved)\n"
          + "        && Objects.equals(funcDescList, that.funcDescList)\n"
          + "        && Objects.equals(classDescList, that.classDescList);\n"
          + "  }\n";

  @Test
  public void detectFunctionsTest() {
    JavaDetectorImpl detector = new JavaDetectorImpl();
    detector.detectFunctions(SAMPLE_CODE_ORIGIN, SAMPLE_CODE_CURRENT);
    detector.getMessageFunctionsJava();
  }

  @Ignore
  public void detectClassesTest() {

  }

  @Ignore
  public void getMessageFunctionsJavaTest() {
    // Test Code Here
  }

  @Ignore
  public void getMessageClassesJavaTest() {
    // Test Code Here
  }
}
