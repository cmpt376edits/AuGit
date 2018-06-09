// TODO Add Unittest, Consider incorporating Javadoc

import java.util.ArrayList;
import java.util.List;

/*
Notes: Have someone write code to give only the code within the first set of curly brackets for detecting functions
it will then be very unlikely to have duplicates and reserved words.
 */

public class JavaDetectorImpl extends DetectorImpl {

  private List<String> reserved = new ArrayList();

  /**
   * TODO Finish this function
   *
   * @return List<String> of the reserved words for our libraries
   */
  public static List<String> getReservedLibraries(List<String> libraries) {
    return null;
  }

  /**
   * @param origin The previous code
   * @param current The current code
   */
  public void detectFunctions(String origin, String current) {
    origin = origin.toLowerCase();
    current = current.toLowerCase();
    String diff = difference(origin, current);

    // TODO Add Vanilla Javas reserved words to our List
    // TODO Detect Java Version for these?
    // TODO make sure to check we arent adding these
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
      List<String> arguments = new ArrayList<>();

      int curIndex = (int) checkedIndice;
      // Grab the return valued and access modifier
      while (curIndex > 0 && diff.charAt(curIndex) != ' ') {
        curIndex--;
      }
      name = diff.substring(curIndex, (int) checkedIndice);
      // curIndex -> x is the functions name

      // Grab return type and accessMod

      // Grabbing the words before each indice

      // Move Down and create the agruments

      // Create new function description and add it to array

      // This needs to be called on preformatted code within the outer { brackets } so that it is
      // primarily variables and method names
    }
  }

  public String getMessageFunctionsJava(ArrayList<FunctionDescription> functionDescriptions) {
    StringBuilder message = new StringBuilder();

    for (FunctionDescription functionDescription : functionDescriptions) {
      message.append("Created function ");
      if (functionDescription.getRetType().equals("void")) {
        message.append("with void return type, called ");
      } else {
        message.append("with ");
        message.append(functionDescription.getRetType());
        message.append(" return type, called ");
      }
      message.append(functionDescription.getFunctionName());
      message.append(" and arguments as follows: ");
      for (int j = 0; j < functionDescription.getArgs().size(); j++) {
        message.append(functionDescription.getArgs().get(j));
        if (j + 1 == functionDescription.getArgs().size()) {

        } else {
          message.append(", ");
        }
      }
      message.append(".");
    }

    System.out.println(message.toString());
    return "";
  }

  public String getMessageClassesJava(ArrayList<ClassDescription> classDescriptions) {
    /* Generate a message for classes, use getMessageFunctionsJava */

    return "";
  }

  public static void main(String[] args) {
    ArrayList<String> arguments = new ArrayList<>();
    JavaDetectorImpl j = new JavaDetectorImpl();
    arguments.add("String name");
    arguments.add("int Time");
    FunctionDescription test =
        new FunctionDescription("randomFunction", 2, arguments, "Object", "private");

    ArrayList<FunctionDescription> fun = new ArrayList<>();
    fun.add(test);
    j.getMessageFunctionsJava(fun);
  }
}