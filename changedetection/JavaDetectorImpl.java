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

  public JavaDetectorImpl(
      List<String> reserved,
      List<FunctionDescription> funcDescList,
      List<ClassDescription> classDescList) {
    this.reserved = reserved;
    this.funcDescList = funcDescList;
    this.classDescList = classDescList;
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
    reserved.add("abstract");
    reserved.add("assert");
    reserved.add("boolean");
    reserved.add("break");
    reserved.add("byte");
    reserved.add("case");
    reserved.add("catch");
    reserved.add("char");
    reserved.add("class");
    reserved.add("const");
    reserved.add("continue");
    reserved.add("default");
    reserved.add("double");
    reserved.add("do");
    reserved.add("else");
    reserved.add("enum");
    reserved.add("extends");
    reserved.add("false");
    reserved.add("final");
    reserved.add("finally");
    reserved.add("float");
    reserved.add("for");
    reserved.add("goto");
    reserved.add("if");
    reserved.add("implements");
    reserved.add("import");
    reserved.add("instanceof");
    reserved.add("int");
    reserved.add("interface");
    reserved.add("long");
    reserved.add("native");
    reserved.add("new");
    reserved.add("null");
    reserved.add("package");
    reserved.add("private");
    reserved.add("protected");
    reserved.add("public");
    reserved.add("return");
    reserved.add("short");
    reserved.add("static");
    reserved.add("strictfp");
    reserved.add("super");
    reserved.add("switch");
    reserved.add("synchronized");
    reserved.add("this");
    reserved.add("throw");
    reserved.add("throws");
    reserved.add("transient");
    reserved.add("true");
    reserved.add("try");
    reserved.add("void");
    reserved.add("void");
    reserved.add("volatile");

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
    }
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
   * @param functionDescriptions The functions to be described
   * @return The message
   */
  public String getMessageFunctionsJava(ArrayList<FunctionDescription> functionDescriptions) {
    StringBuilder message = new StringBuilder();

    for (FunctionDescription functionDescription : functionDescriptions) {
      message.append(functionDescription.getMessage()); // TODO args
    }

    return message.toString();
  }

  /**
   * Generates a message for summarizing the classes passed in
   *
   * @param classDescriptions The classes to be described
   * @return The message
   */
  public String getMessageClassesJava(ArrayList<ClassDescription> classDescriptions) {
    StringBuilder message = new StringBuilder();

    for (ClassDescription classDescription : classDescriptions) {
      message.append(classDescription.getMessage()); // TODO args
    }

    return message.toString();
  }
}
