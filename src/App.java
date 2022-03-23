import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
  public static void main(String[] args) throws Exception {
    System.out.println("2022.03.23, Balogh Csenge, Szoft_I_N");
    System.out.println("Személyek adatainak bekérése");

    writeFile();
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

    Integer rowID = 1;

    for(int i = 0; i<infos.length;i++) {
      System.out.print(infos[i] + ": ");
      data = sc.nextLine();

      dataList.add(data);
    }

    dataList.add(0, rowID.toString());

    sc.close();

    // return data as arraylist
    return dataList;
    
  }

  public static String splitDataList () {
    ArrayList<String> dataList = tryGetData();

    String dataString = String.join(", ", dataList).replace(", ", ":");

    return dataString;

  }

  public static void writeFile () {
    try {
      tryWriteFile();
    } catch (IOException e) {
      System.err.println("Error writing to file");
      System.exit(500);
    }
  }

  public static void tryWriteFile () throws IOException {
    FileWriter fw = new FileWriter("data.txt", true);
    PrintWriter pw = new PrintWriter(fw);

    String dataString = splitDataList();

    try {
      pw.println(dataString);

      pw.close();
    } catch (Exception e) {
      System.out.println("nem jo ");
    }

  }
}


