import com.sun.deploy.util.StringUtils;

public class funcDetection {

  /**
   * Returns a substring of the second string from the point where
   * the strings differ until the end of the second string
   *
   * @param str1 the first string
   * @param str2 the second string to be compared with the first
   * @return String
   */
  public static String difference(String str1, String str2) {
    if (str1 == null && str2 == null) {
      return "";
    }

    //if str1 is null indexOfDifference will return 0 and str2 will be returned
    if (str2 == null){
      return str1;
    }

    int changeIndex = indexOfDifference(str1, str2);

    if (changeIndex == -1){
      return "";
    }

    return str2.substring(changeIndex);

  }

  /**
   * Compares two strings and returns the index of the first
   * difference between the strings
   *
   * @param str1 the first string
   * @param str2 the second string to be compared with the first
   * @return String
   */
  public static int indexOfDifference(String str1, String str2){
    if (str1.equals(str2)){
      return -1;
    }
    if (str1 == null || str2 == null){
      return 0;
    }

    int i;
    for (i = 0; i < str1.length() && i < str2.length(); i++){
      if (str1.charAt(i) != str2.charAt(i)){
        return i;
      }
    }
    return -1;
  }

    /**
     *
     * @param origin
     * @param current
     */
  public static void detectFunction(String origin, String current) {
    String diff = difference(origin, current);
      
  }

  public static void main(String[] args) {

  }
}
