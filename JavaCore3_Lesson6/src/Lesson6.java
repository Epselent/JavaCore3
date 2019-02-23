public class Lesson6 {


    public int[] arrayAfter4(int[] arr) throws RuntimeException{
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
    public boolean inaArray1or4(int[] arr){
        boolean rezult = false;
        for (int a:arr) {
            if((a == 1) || (a == 4)){
                rezult = true;
            }
        }
        return rezult;
    }


}
