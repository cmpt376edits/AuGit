// TODO Add Unittest
// TODO Add diff function

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

  public static void main(String[] args) {
    // String filePath = "/* Bring up Dialog Potentially to get file or use cwd */";
    // String res = convertToString(filePath);
    String filePath = "ReservedData/java_reserved.txt";
    File file = new File(filePath);
    System.out.println(file.getAbsolutePath());
  }
}
