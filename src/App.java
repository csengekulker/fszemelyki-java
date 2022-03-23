import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
  public static void main(String[] args) throws Exception {
    System.out.println("2022.03.23, Balogh Csenge, Szoft_I_N");
    System.out.println("Személyek adatainak bekérése");

    // writeFile();
    verifyFile();
    writeFile();

  }

  public static Integer verifyFile() {
    Integer lastIndex = 0;
    try {
      lastIndex = tryVerifyFile();
    } catch (FileNotFoundException e) {
      System.err.println("kurva");
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

    for(int j = 0; j<infos.length;j++) {
      System.out.print(infos[j] + ": ");
      data = sc.nextLine();

      dataList.add(data);

    }

    Integer index = verifyFile() + 1;

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


