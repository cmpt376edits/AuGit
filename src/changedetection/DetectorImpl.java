package changedetection;

public abstract class DetectorImpl implements Detector {

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
}
