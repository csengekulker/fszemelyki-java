import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class myFileWriter {
    public static void writeFile () {
        try {
          tryWriteFile();
        } catch (IOException e) {
          System.err.println("Error: Cannot write to file");
          System.exit(500);
        }
      }
    
      public static void tryWriteFile () throws IOException {
        FileWriter fw = new FileWriter("data.txt", true);
        PrintWriter pw = new PrintWriter(fw);
    
        String dataString = DataHandler.splitDataList();
    
        try {
          pw.println(dataString);
    
          pw.close();
        } catch (Exception e) {
          System.out.println("Something went wrong");
        }
    
      }
}
