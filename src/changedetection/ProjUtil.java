// TODO Add Unittest

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

  public static void main(String[] args) {
    // String filePath = "/* Bring up Dialog Potentially to get file or use cwd */";
    // String res = convertToString(filePath);
    String filePath = "ReservedData/java_reserved.txt";
    File file = new File(filePath);
    System.out.println(file.getAbsolutePath());
  }
}
