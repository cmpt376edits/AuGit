import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class JavaDetectorImplTest {

  private static final String SAMPLE_CODE_ORIGIN = "";


  private static final String SAMPLE_CODE_CURRENT = "";

  @Test
  public void detectFunctionsTest() {
    JavaDetectorImpl detector = new JavaDetectorImpl();
    detector.detectFunctions(SAMPLE_CODE_ORIGIN, SAMPLE_CODE_CURRENT);
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
