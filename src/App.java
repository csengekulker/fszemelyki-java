import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
  public static void main(String[] args) throws Exception {
    System.out.println("2022.03.23, Balogh Csenge, Szoft_I_N");
    System.out.println("Személyek adatainak bekérése");

    tryGetData();
  }

  public static void getData () {
    


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

    for(int i = 0; i<infos.length;i++) {
      System.out.print(infos[i] + ": ");
      data = sc.nextLine();

      dataList.add(data);
    }

    sc.close();

    System.out.println(dataList);

    // return data as arraylist
    return dataList;
    
  }

  public static void writeData () {
    //write to file
  }
}


