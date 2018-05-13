import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;

public class FuncDetection {
    private ArrayList<FunctionDescription> funcs;
    private int funcNum = 0;


  /**
   * This function is from:
   * http://www.java2s.com/Tutorial/Java/0040__Data-Type/ComparestwoStringsandreturnstheportionwheretheydiffer.htm
   * Priority: Create our own version.
   *
   * @param str1
   * @param str2
   * @return String
   */
  public static String difference(String str1, String str2) {
    if (str1 == null) {
      return str2;
    }
    if (str2 == null) {
      return str1;
    }
    int at = indexOfDifference(str1, str2);
    if (at == -1) {
      return "";
    }
    return str2.substring(at);
  }

  /**
   * This function is from:
   * http://www.java2s.com/Tutorial/Java/0040__Data-Type/ComparestwoStringsandreturnstheportionwheretheydiffer.htm
   * Priority: Create our own version.
   *
   * @param str1
   * @param str2
   * @return int
   */
  public static int indexOfDifference(String str1, String str2) {
    if (str1 == str2) {
      return -1;
    }
    if (str1 == null || str2 == null) {
      return 0;
    }
    int i;
    for (i = 0; i < str1.length() && i < str2.length(); ++i) {
      if (str1.charAt(i) != str2.charAt(i)) {
        break;
      }
    }
    if (i < str2.length() || i < str1.length()) {
      return i;
    }
    return -1;
  }

  /**
   * @param origin
   * @param current
   */
  public static void detectFunctions(String origin, String current) {

    String diff = difference(origin, current);
  }

  public String getMessage(){

      return "";
  }

}

