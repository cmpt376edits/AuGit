// TODO (rmartin) Consider incorporating Javadoc
// TODO (rmartin) Write code to give only the code within the first set of curly brackets for
// detecting functions
// it will then be very unlikely to have duplicates and reserved words.

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JavaDetectorImpl extends DetectorImpl {

  private List<String> reserved;
  private List<FunctionDescription> listDiffFunctions;
  private List<ClassDescription> listDiffClasses;

  // TODO (rmartin) Hacky please fix
  public JavaDetectorImpl() {
    this.reserved = new ArrayList();
    this.listDiffFunctions = new ArrayList();
    this.listDiffClasses = new ArrayList();
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
        + ", listDiffFunctions="
        + listDiffFunctions
        + ", listDiffClasses="
        + listDiffClasses
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    JavaDetectorImpl that = (JavaDetectorImpl) o;
    return Objects.equals(reserved, that.reserved)
        && Objects.equals(listDiffFunctions, that.listDiffFunctions)
        && Objects.equals(listDiffClasses, that.listDiffClasses);
  }

  @Override
  public int hashCode() {

    return Objects.hash(reserved, listDiffFunctions, listDiffClasses);
  }

  /**
   * This function detects functions and sets the listDiffFunctions full of them
   *
   * @param code the code to operate on
   */
  public void detectFunctions(String code, String old) {

  }

  /**
   * This function detects classes in code and sets the listDiffClasses full of them
   *
   * @param code the code the operate on
   */
  public void detectClasses(String code, String old) {}

  public List<String> getReserved() {
    return reserved;
  }

  public void setReserved(List<String> reserved) {
    this.reserved = reserved;
  }

  public List<FunctionDescription> getListDiffFunctions() {
    return listDiffFunctions;
  }

  public void setListDiffFunctions(List<FunctionDescription> listDiffFunctions) {
    this.listDiffFunctions = listDiffFunctions;
  }

  public List<ClassDescription> getListDiffClasses() {
    return listDiffClasses;
  }

  public void setListDiffClasses(List<ClassDescription> listDiffClasses) {
    this.listDiffClasses = listDiffClasses;
  }

  /**
   * Generates a message for summarizing the functions passed in
   *
   * @return The message
   */
  public String getMessageFunctionsJava() {
    StringBuilder message = new StringBuilder();

    for (FunctionDescription functionDescription : this.listDiffFunctions) {
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

    for (ClassDescription classDescription : this.listDiffClasses) {
      message.append(classDescription.toMessage()); // TODO args
    }

    return message.toString();
  }
}