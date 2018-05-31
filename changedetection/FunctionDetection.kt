// TODO Add Unittest, Consider incorporating Javadoc

import com.sun.deploy.util.StringUtils
/*
Notes: Have someone write code to give only the code within the first set of curly brackets for detecting functions
it will then be very unlikely to have duplicates and reserved words.
 */

object FunctionDetection {

    /**
     * Returns a substring of the second string from the point where
     * the strings differ until the end of the second string
     *
     * @param str1 the first string
     * @param str2 the second string to be compared with the first
     * @return String
     */
    fun difference(str1: String?, str2: String?): String {
        if (str1 == null && str2 == null) {
            return ""
        }

        //if str1 is null indexOfDifference will return 0 and str2 will be returned
        if (str2 == null) {
            return str1
        }
        val changeIndex = indexOfDifference(str1!!, str2)
        return if (changeIndex == -1) {
            ""
        } else str2.substring(changeIndex)
    }

    /**
     * TODO Finish this function
     *
     * @return List<String> of the reserved words for our libraries
    </String> */
    fun getReservedLibraries(libraries: List<String>): List<String>? {
        return null
    }

    /**
     * Compares two strings and returns the index of the first
     * difference between the strings
     *
     * @param str1 the first string
     * @param str2 the second string to be compared with the first
     * @return String
     */
    fun indexOfDifference(str1: String, str2: String?): Int {
        if (str1 == str2) {
            return -1
        }
        if (str1 == null || str2 == null) {
            return 0
        }
        var i: Int
        i = 0
        while (i < str1.length && i < str2.length) {
            if (str1[i] != str2[i]) {
                return i
            }
            i++
        }
        return -1
    }

    /**
     * @param origin
     * @param current
     */
    fun detectFunctions(origin: String, current: String) {
        var origin = origin
        var current = current
        origin = origin.toLowerCase()
        current = current.toLowerCase()
        val diff = difference(origin, current)

        // Add Vanilla Javas reserved words to our List
        // Detect Java Version for these?
        reserved.add("abstract")
        reserved.add("assert")
        reserved.add("boolean")
        reserved.add("break")
        reserved.add("byte")
        reserved.add("case")
        reserved.add("catch")
        reserved.add("char")
        reserved.add("class")
        reserved.add("const")
        reserved.add("continue")
        reserved.add("default")
        reserved.add("double")
        reserved.add("do")
        reserved.add("else")
        reserved.add("enum")
        reserved.add("extends")
        reserved.add("false")
        reserved.add("final")
        reserved.add("finally")
        reserved.add("float")
        reserved.add("for")
        reserved.add("goto")
        reserved.add("if")
        reserved.add("implements")
        reserved.add("import")
        reserved.add("instanceof")
        reserved.add("int")
        reserved.add("interface")
        reserved.add("long")
        reserved.add("native")
        reserved.add("new")
        reserved.add("null")
        reserved.add("package")
        reserved.add("private")
        reserved.add("protected")
        reserved.add("public")
        reserved.add("return")
        reserved.add("short")
        reserved.add("static")
        reserved.add("strictfp")
        reserved.add("super")
        reserved.add("switch")
        reserved.add("synchronized")
        reserved.add("this")
        reserved.add("throw")
        reserved.add("throws")
        reserved.add("transient")
        reserved.add("true")
        reserved.add("try")
        reserved.add("void")
        reserved.add("void")
        reserved.add("volatile")

        // Get reserved words for installed plugins and libraries
        // getReservedLibraries call

        val checkedIndices = ArrayList()
        val functionByName = ArrayList()

        var i = 0
        diff@
        val c: Char
        while (true) {
            if (c === '(') {
                checkedIndices.add(i)
            }
            i++
        }

        // Here we need to go to the first word before the indices and then grab the function and add to our function
        // list iff it is not reserved

        while (true);
        run {
            val arguments = ArrayList()

            // Grab the return valued and access modifier

            // Grabbing the words before each indice

            // Move Down and create the agruments

            // Create new function description and add it to array

            // This needs to be called on preformatted code within the outer { brackets } so that it is primarily variables and method names
        }


    }

    fun getMessageFunctions(functionDescriptions: ArrayList<FunctionDescription>): String {
        val message = StringBuilder()

        for (i in 0 until functionDescriptions.size()) {
            message.append("Created function ")
            if (functionDescriptions.get(i).getRetType().equals("void")) {
                message.append("with void return type, called ")
            } else {
                message.append("with ")
                message.append(functionDescriptions.get(i).getRetType())
                message.append(" return type, called ")
            }
            message.append(functionDescriptions.get(i).getFunctionName())
            message.append(" and arguments as follows: ")
            for (j in 0 until functionDescriptions.get(i).getArgs().size()) {
                message.append(functionDescriptions.get(i).getArgs().get(j))
                if (j + 1 == functionDescriptions.get(i).getArgs().size()) {

                } else {
                    message.append(", ")
                }
            }
            message.append(".")
        }

        println(message.toString())
        return ""
    }

    fun getMessageClasses(classDescriptions: ArrayList<ClassDescription>): String {
        /* Generate a message for classes, use getMessageFunctions */
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val argu = ArrayList()
        argu.add("String name")
        argu.add("int Time")
        val test = FunctionDescription("randomFunction", 2, argu, "Object")


        val `fun` = ArrayList()
        `fun`.add(test)
        getMessage(`fun`)

    }
}
