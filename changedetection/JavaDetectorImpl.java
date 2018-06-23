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

    // set this.funcdesclist to something

  }

  /**
   * This function detects classes in code and sets the classDescList full of them
   *
   * @param origin The previous code
   * @param current The current code
   */
  public void detectClasses(String origin, String current) {}

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
