import com.sun.deploy.util.StringUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FuncDetection {

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

  public static String getMessage(ArrayList<FunctionDescription> functionDescriptions) {
    StringBuilder message = new StringBuilder();

    for (int i = 0; i < functionDescriptions.size(); i++) {
      message.append("Created function ");
      if (functionDescriptions.get(i).getRetType().equals("void")) {
        message.append("with void return type, called ");
      } else {
        message.append("with ");
        message.append(functionDescriptions.get(i).getRetType());
        message.append(" return type, called ");
      }
      message.append(functionDescriptions.get(i).getFunctionName());
      message.append(" and arguments as follows: ");
      for (int j = 0; j < functionDescriptions.get(i).getArgs().size(); j++) {
        message.append(functionDescriptions.get(i).getArgs().get(j));
        if (j + 1 == functionDescriptions.get(i).getArgs().size()) {

        } else {
          message.append(", ");
        }
      }
      message.append(".");
    }

    System.out.println(message.toString());
    return "";
  }

  public static void main(String[] args) {
      ArrayList<String> argu = new ArrayList<>();
      argu.add("String name");
      argu.add("int Time");
      FunctionDescription test = new FunctionDescription("randomFunction", 2, argu, "Object");


      ArrayList<FunctionDescription> fun = new ArrayList<>();
      fun.add(test);
      getMessage(fun);

  }
}
