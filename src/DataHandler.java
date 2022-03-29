import java.util.Scanner;
import java.util.ArrayList;

public class DataHandler {

    public static void getData () {
        
        try {
            tryGetData();
        } catch (Exception e) {
            System.err.println("error");
            System.exit(500);
        }
    }

    public static ArrayList<String> tryGetData() {
        Scanner sc = new Scanner(System.in);
    
        String data = null;
        ArrayList<String> dataList = new ArrayList<>();
    
        String[] infos = {
          "Név",
          "Település",
          "Cím",
          "Havi jövedelem"
        };
    
        for(int i= 0; i<infos.length;i++) {
          System.out.print(infos[i] + ": ");
          data = sc.nextLine();
    
          dataList.add(data);
    
        }
    
        Integer index = Verification.verifyFile() + 1;
    
        dataList.add(0, index.toString());
    
        sc.close();
    
        // return data as arraylist
        return dataList; 
      }

      public static String splitDataList () {
        ArrayList<String> dataList = tryGetData();
    
        String dataString = String.join(", ", dataList).replace(", ", ":");
    
        return dataString;
    
      }
}
