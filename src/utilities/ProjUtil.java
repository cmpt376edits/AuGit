// TODO Add Unittest

package changedetection;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProjUtil {

  /**
   * Returns a String containing all the characters from the file at filePath, with all the newlines
   * and spaces removed.
   *
   * @param filePath : String
   * @return String/null
   */
  public static String convertToString(String filePath) {
    File file = new File(filePath);
    StringBuilder s = new StringBuilder();
    try {
      BufferedReader in = new BufferedReader(new FileReader(file));
      String buf = in.readLine();
      while (buf != null) {
        if (!(buf.trim().equals(""))) {
          s.append(buf.trim());
          s.append(" ");
        }
        buf = in.readLine();
      }
      return s.toString();
    } catch (IOException iox) {
      iox.printStackTrace();
    }
    return null;
  }

  // TODO (rmartin) add javadoc
  public static List<String> getReserved(String filePath) {
    File file = new File(filePath);
    StringBuilder s = new StringBuilder();
    List<String> reservedVals = new ArrayList();
    try {
      BufferedReader in = new BufferedReader(new FileReader(file));
      String buf = in.readLine();
      while (buf != null) {
        reservedVals.add(buf);
        buf = in.readLine();
      }
      return reservedVals;
    } catch (IOException iox) {
      iox.printStackTrace();
    }
    return null;
  }
  
  // TODO (rmartin) validate this function works as expected
  /**
   * Compares two strings and returns the index of the first difference between the strings
   *
   * @param str1 the first string
   * @param str2 the second string to be compared with the first
   * @return String
   */
  public static int indexOfDifference(String str1, String str2) {
    if (str1.equals(str2)) {
      return -1;
    }
    if (str1 == null || str2 == null) {
      return 0;
    }
    int i;
    for (i = 0; i < str1.length() && i < str2.length(); i++) {
      if (str1.charAt(i) != str2.charAt(i)) {
        return i;
      }
    }
    return -1;
  }
  
  // TODO (rmartin) validate this function works as expected
  /**
   * Returns a substring of the second string from the point where the strings differ until the end
   * of the second string
   *
   * @param str1 the first string
   * @param str2 the second string to be compared with the first
   * @return String
   */
  public static String difference(String str1, String str2) {
    if (str1 == null && str2 == null) {
      return "";
    }

    // if str1 is null indexOfDifference will return 0 and str2 will be returned
    if (str2 == null) {
      return str1;
    }
    int changeIndex = indexOfDifference(str1, str2);
    if (changeIndex == -1) {
      return "";
    }
    return str2.substring(changeIndex);
  }

  public static void main(String[] args) {
    // String filePath = "/* Bring up Dialog Potentially to get file or use cwd */";
    // String res = convertToString(filePath);
    String filePath = "ReservedData/java_reserved.txt";
    File file = new File(filePath);
    System.out.println(file.getAbsolutePath());
  }
  
  public static String getFunctionLevel(String code) {
    // TODO (rmartin) Return everything within the class but exclude the inside of methods/functions/enums
  }
}
