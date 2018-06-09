// TODO add unittest, research Kotlin Test Frameworks

import java.util.ArrayList

class ClassDescription(functionName: String, numArgs: Int, args: ArrayList<FunctionDescription>, modifier: String) {

    var accessModifier: String? = null
        get() = retType
    var className: String? = null
    var numFunctions: Int = 0
        private set
    var functions: ArrayList<FunctionDescription>? = null

    fun setNumArgs(numFunctions: Int) {
        this.numFunctions = numFunctions
    }

    init {
        this.className = className
        this.numFunctions = numFunctions
        this.functions = functions
        this.accessMdifier = modifier
    }
}