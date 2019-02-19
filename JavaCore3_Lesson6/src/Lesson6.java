public class Lesson6 {


    public static int[] arrayAfter4(int arr[]) throws RuntimeException{
        int j = 0;
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] == 4){
                j = i;
            }

        }
        if (j == 0){
            throw new RuntimeException("Нет цифры 4 в массиве");
        }
        int value = arr.length-(j+1);
        int[] array = new int[value];
        System.arraycopy(arr,j+1,array, 0,value);
        return array;
    }
    public static boolean inaArray1or4(int arr[]){
        boolean rezult = false;
        for (int a:arr) {
            if((a == 1) || (a == 4)){
                rezult = true;
            }
        }
        return rezult;
    }

    public static void main(String[] args) {
        int[] mas = {4, 1, 1, 3 , 5};
        int[] mas1 = {1, 3 , 4, 5, 6, 4, 7, 7};
//        try {
//            int[] mas2 = arrayAfter4(mas);
//            int[] mas3 = arrayAfter4(mas1);
//            for (int a:mas2 ) {
//                System.out.print(a);
//            }
//            System.out.println();
//            for (int a:mas3 ) {
//                System.out.print(a);
//            }
//        }catch (RuntimeException e){
//            e.printStackTrace();
//        }
        System.out.println(inaArray1or4(mas));
    }
}
