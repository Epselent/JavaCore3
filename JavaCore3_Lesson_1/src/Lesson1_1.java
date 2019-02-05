import java.util.ArrayList;
import java.util.Random;




public class Lesson1_1 {
    public static void main(String[] args) {

        Integer[] arr = new Integer[10];
        System.out.println("массив целых чисел");
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = i + 1;
            System.out.print(arr[i] + "  ");
        }
        System.out.println();

        arr = Unilities.exchange(arr,0, 2);
        System.out.println("Меняем эллементы массива с индексами 0 и 2 местами" );
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
        String[] arrSt = {"A","B","C","D"};
        for (int i = 0; i < arrSt.length; i++) {
            System.out.print(arrSt[i] + "  ");
        }
        System.out.println();
        arrSt = Unilities.exchange(arrSt,1, 2);
        for (int i = 0; i < arrSt.length; i++) {
            System.out.print(arrSt[i] + "  ");
        }
        System.out.println();
        ArrayList<String> letters = new ArrayList<String>();
        letters = Unilities.arrToArrayList(arrSt);
        System.out.println(letters);
    }
}
class Unilities {

/*
метод, который меняет два элемента массива местами
 */
    public static  <T> T[] exchange(T[] arr, int ex1, int ex2){
        T arr2 = arr[ex1];

        arr[ex1] = arr[ex2];
        arr[ex2] = arr2;
        return arr;

    }
/*
 метод, который преобразует массив в ArrayList;
 */
    public static <T> ArrayList<T> arrToArrayList (T[] arr){
        ArrayList<T> arrToArray = new ArrayList<T>();
        for (int i = 0; i < arr.length ; i++) {
            arrToArray.add(i,arr[i]);
        }

        return arrToArray;
    }
}
