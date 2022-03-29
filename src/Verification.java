import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class Verification {

    public static Integer verifyFile() {
        Integer lastIndex = 0;
        try {
          lastIndex = tryVerifyFile();
        } catch (FileNotFoundException e) {
          System.err.println("Error: File not found");
          System.exit(500);
        }
    
        return lastIndex;
      }
    
      public static Integer tryVerifyFile () throws FileNotFoundException {
        File file = new File("data.txt");
        Scanner sc = new Scanner(file); //exception
    
        Integer lastIndex = 0;
    
        while (sc.hasNextLine()) {
          String values[] = sc.nextLine().split(":");
    
          lastIndex = Integer.parseInt(values[0]);
        }
    
        sc.close();
        // System.out.println(lastIndex);
    
        return lastIndex;
    
      }
}
