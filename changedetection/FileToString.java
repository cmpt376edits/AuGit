import java.io.*;

public class FileToString{
    /**
     * Returns a String containing all the characters from the file at filePath, with all the newlines and spaces
     * removed.
     *
     * @param filePath : String
     * @return String/null
     */
<<<<<<< HEAD
    public static String convertToString(String filePath) {
=======
    public static String convertToString(String filePath){
>>>>>>> Merge
        File file = new File(filePath);
        StringBuilder s = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String buf = in.readLine();
            while (buf != null){
<<<<<<< HEAD
=======
                System.out.println(buf);
>>>>>>> Merge
                if (!(buf.trim().equals(""))){
                    s.append(buf.trim());
                    s.append(" ");
                }
                buf = in.readLine();
            }
            return s.toString();
<<<<<<< HEAD
        } catch(IOException iox) {
=======
        }catch(IOException iox) {
>>>>>>> Merge
            iox.printStackTrace();
        }
        return null;
    }

<<<<<<< HEAD
    public static void main(String[] args) {
=======
    public static void main(String[] args){
>>>>>>> Merge
        String filePath = "/Users/Reece/Ellen's stuff/Projects/AuGit/changedetection/FunctionDescription.java";
        String res = convertToString(filePath);
        System.out.println(res);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> Merge
