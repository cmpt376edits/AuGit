// TODO (rmartin) Consider incorporating Javadoc
// TODO (rmartin) Write code to give only the code within the first set of curly brackets for
// detecting functions
// it will then be very unlikely to have duplicates and reserved words.

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JavaDetectorImpl extends DetectorImpl {

  private List<String> reserved = new ArrayList();
  private List<FunctionDescription> funcDescList = new ArrayList();
  private List<ClassDescription> classDescList = new ArrayList();

  // TODO (rmartin) Hacky please fix
  public JavaDetectorImpl() {
    this.reserved = null;
    this.funcDescList = null;
    this.classDescList = null;
  }

  /**
   * TODO (rmartin) Finish this function
   *
   * @return List<String> of the reserved words for our libraries
   */
  public static List<String> getReservedLibraries(List<String> libraries) {
    return null;
  }

  @Override
  public String toString() {
    return "JavaDetectorImpl{"
        + "reserved="
        + reserved
        + ", funcDescList="
        + funcDescList
        + ", classDescList="
        + classDescList
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    JavaDetectorImpl that = (JavaDetectorImpl) o;
    return Objects.equals(reserved, that.reserved)
            && Objects.equals(funcDescList, that.funcDescList)
            && Objects.equals(classDescList, that.classDescList);
  }

  @Override
  public int hashCode() {

    return Objects.hash(reserved, funcDescList, classDescList);
  }

  /**
   * This function detects functions and sets the funcDescList full of them
   *
   * @param origin The previous code
   * @param current The current code
   */
  public void detectFunctions(String origin, String current) {
    origin = origin.toLowerCase();
    current = current.toLowerCase();
    String diff = difference(origin, current);

    // TODO (rmartin) Add Vanilla Javas reserved words to our List
    // TODO (rmartin) Detect Java Version for these?
    // TODO (rmartin) make sure to check we arent adding these
    //ProjUtil.getReserved("ReservedData\\java_reserved.txt");

    // Get reserved words for installed plugins and libraries
    // getReservedLibraries call

    List checkedIndices = new ArrayList();
    List<FunctionDescription> functionByName = new ArrayList<>();

    for (int i = 0; i < diff.length(); i++) {

      // TODO (rmartin) turn this into a regex where the bracket needs to be lead by a char
      if (diff.charAt(i) == '(') {
        checkedIndices.add(i);
      }
      i++;
    }

    // Here we need to go to the first word before the indices and then grab the function and add to
    // our function
    // list iff it is not reserved

    for (Object checkedIndice : checkedIndices) {
      String name = "";
      String accessMod = "";
      String retType = "";
      boolean stat = false;
      List<String> arguments = new ArrayList<>();

      int curIndex = (int) checkedIndice;
      int lastLoc = 0;

      // Function Name
      while (curIndex > 0 && diff.charAt(curIndex) != ' ') {
        curIndex--;
      }
      lastLoc = curIndex - 1;
      name = diff.substring(curIndex, (int) checkedIndice);

      // Return Value
      while (curIndex > 0 && diff.charAt(curIndex) != ' ') {
        curIndex--;
      }
      retType = diff.substring(curIndex, (lastLoc));
      lastLoc = curIndex - 1;

      // Static (boolean)
      while (curIndex > 0 && diff.charAt(curIndex) != ' ') {
        curIndex--;
      }
      lastLoc = curIndex - 1;
      stat = diff.substring(curIndex, (int) checkedIndice).contains("static");

      if (stat) {
        // Function is Static
        // Access Modifier
        while (curIndex > 0 && diff.charAt(curIndex) != ' ') {
          curIndex--;
        }
        accessMod = diff.substring(curIndex, (lastLoc));
        lastLoc = curIndex - 1;
      } else {
        // Function isn't Static
        // Access Modifier
        accessMod = diff.substring(curIndex, (int) checkedIndice);
      }
      functionByName.add(new FunctionDescription(name, arguments.size(), (ArrayList<String>) arguments, retType, accessMod));
    }

    this.funcDescList = functionByName;
  }

  /**
   * This function detects classes in code and sets the classDescList full of them
   *
   * @param origin The previous code
   * @param current The current code
   */
  public void detectClasses(String origin, String current) {
    //    StringBuilder message = new StringBuilder();
    //
    //    for (ClassDescription classDescription : ) {
    //      // Message Logic
    //    }
  }

  public List<String> getReserved() {
    return reserved;
  }

  public void setReserved(List<String> reserved) {
    this.reserved = reserved;
  }

  public List<FunctionDescription> getFuncDescList() {
    return funcDescList;
  }

  public void setFuncDescList(List<FunctionDescription> funcDescList) {
    this.funcDescList = funcDescList;
  }

  public List<ClassDescription> getClassDescList() {
    return classDescList;
  }

  public void setClassDescList(List<ClassDescription> classDescList) {
    this.classDescList = classDescList;
  }

  /**
   * Generates a message for summarizing the functions passed in
   *
   * @return The message
   */
  public String getMessageFunctionsJava() {
    StringBuilder message = new StringBuilder();

    for (FunctionDescription functionDescription : this.funcDescList) {
      message.append(functionDescription.toMessage()); // TODO args
    }

    return message.toString();
  }

  /**
   * Generates a message for summarizing the classes passed in
   *
   * @param classDescriptions The classes to be described
   * @return The message
   */
  public String getMessageClassesJava() {
    StringBuilder message = new StringBuilder();

    for (ClassDescription classDescription : this.classDescList) {
      message.append(classDescription.toMessage()); // TODO args
    }

    return message.toString();
  }
}
