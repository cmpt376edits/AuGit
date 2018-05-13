import java.io.*;

public class FileToString{
    /**
     * Returns a String containing all the characters from the file at filePath, with all the newlines and spaces
     * removed.
     *
     * @param filePath : String
     * @return String/null
     */
    public static String convertToString(String filePath){
        File file = new File(filePath);
        StringBuilder s = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String buf = in.readLine();
            while (buf != null){
                if (!(buf.trim().equals(""))){
                    s.append(buf.trim());
                    s.append(" ");
                }
                buf = in.readLine();
            }
            return s.toString();
        }catch(IOException iox) {
            iox.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args){
        String filePath = "/Users/Reece/Ellen's stuff/Projects/AuGit/changedetection/FunctionDescription.java";
        String res = convertToString(filePath);
        System.out.println(res);
    }
}