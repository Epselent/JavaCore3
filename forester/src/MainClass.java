import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        int m = 379;
        int n = 5;
        File file = new File("D:\\HomeWork\\forester\\src","forest.txt");
        int[] forest = new int[m];
        Scanner sc = null;
            try {
                sc = new Scanner(file);
                    for (int i = 0; i <forest.length ; i++) {
                        if(sc.hasNext()) {
                            forest[i] = sc.nextInt();
                        }else break;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }finally {
                sc.close();
            }
        ArrayList<Counter> arrCount = new ArrayList<>();
        for (int i = 1; i <=n ; i++) {
            arrCount.add(new Counter(i));
        }
        for (int a:forest) {
                arrCount.get(a-1).increm();
        }
        for (Counter a: arrCount) {
            a.info();
        }




//
//    {
//        try( FileReader forest = new FileReader("forest.txt")) {
//           char [] arrForest = new char[256];
//           int c;
//           while ((c = forest.read(arrForest)) > 0){
//
//           }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    }
}
