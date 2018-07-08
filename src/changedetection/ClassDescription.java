// TODO add javadoc
// Add Test

package changedetection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClassDescription {
    private String accessModifier;
    private String className;
    private int numFunctions;
    private List<FunctionDescription> functions;

    public ClassDescription(
            String className, int numArgs, ArrayList<FunctionDescription> args, String modifier) {
        this.className = className;
        this.numFunctions = numFunctions;
        this.functions = functions;
        this.accessModifier = modifier;
    }

    public String toMessage() { // TODO (rmartin) args?
        return "";
        // This needs to have args to change the message
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassDescription that = (ClassDescription) o;
        return numFunctions == that.numFunctions
                && Objects.equals(accessModifier, that.accessModifier)
                && Objects.equals(className, that.className)
                && Objects.equals(functions, that.functions);
    }

    @Override
    public String toString() {
        return "ClassDescription{"
                + "accessModifier='"
                + accessModifier
                + '\''
                + ", className='"
                + className
                + '\''
                + ", numFunctions="
                + numFunctions
                + ", functions="
                + functions
                + '}';
    }

    @Override
    public int hashCode() {

        return Objects.hash(accessModifier, className, numFunctions, functions);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getNumFunctions() {
        return numFunctions;
    }

    public void setNumArgs(int numFunctions) {
        this.numFunctions = numFunctions;
    }

    public List<FunctionDescription> getFunctions() {
        return functions;
    }

    public void setFunctions(ArrayList<FunctionDescription> functions) {
        this.functions = functions;
    }

    public String getAccessModifier() {
        return this.accessModifier;
    }

    public void setAccessModifier(String modifier) {
        this.accessModifier = modifier;
    }
}
