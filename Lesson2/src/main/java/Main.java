import java.util.Arrays;

public class Main {

    public static int[] invertArray(int[] arr){
        int[] retArr = new int[arr.length];
        for (int i=0; i<arr.length; i++) {
            retArr[i] = arr[i] == 0 ? 1 : 0;
        }

        return retArr;
    }

    private static void printArray(int[] array){
        System.out.println("Array = "+ Arrays.toString(array));
    }

    public static void main (String[] args){
        /***************** Инверсия массива **********************************/
        int[] arr ={1,0,1,0};
        printArray(invertArray(arr));
        /****************** Заполнение массива с шагом 3 *********************************/
        int[] arr8 = new int[8];
        int i = 0;
        int j = 0;
        do {
            arr8[i] = j;
            j += 3;
            i++;
        } while (i < 8);
        printArray(arr8);
        /******************* Числа < 6 умножить на 2 ********************************/
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int k = 0; k< arr3.length; k++) {
            int val = arr3[k];
            if (val < 6)
                arr3[k] = val * 2;
        }
        printArray(arr3);
        /******************* Матрица, в диагоналях единицы ********************************/
        int arrayDimensions = 10;
        int[][] arr4 = new int[arrayDimensions][arrayDimensions];
        for (int k = 0; k < arr4.length; k++) {
            arr4[k][k] =1;
            arr4[arr4.length-1-k][k] = 1;
        }
        System.out.println("Array = "+ Arrays.deepToString(arr4));
        /****************** max и min *********************************/
        int[] arr5 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int maxItem = arr5[0];
        int minItem = arr5[0];
        for (int k = 0; k< arr5.length; k++) {
            if (arr5[k] > maxItem) maxItem = arr5[k];
            if (arr5[k] < minItem) minItem = arr5[k];
        }
        System.out.println("max = "+ maxItem+ " min = "+ minItem);

        /**************** Ищем границу, на которой равны суммы правой и левой частей ***********************************/
        int[] arr6 = {1, 1, 1, 1, 3};
        int sum1 = 0;
        for (int k = 0; k <= arr6.length - 2; k++) {
            int sum2 = 0;
            sum1 += arr6[k];
            for (int m = k + 1; m < arr6.length; m++) {
                sum2 += arr6[m];
            }
            if (sum1 == sum2) System.out.println("Граница на "+(k + 1)+" элементе");
        }
        /**************** Сдвигаем массив ***********************************/
        int[] arr7 = {1, 2, 3, 4, 5};
        shiftArray(arr7, -3);
    }

    private static int[] shiftRight(int[] arr){
        for (int k = arr.length - 1; k >= 1 ; k--) {
            int el1 = arr[k-1];
            arr[k] = el1;
        }
        arr[0] = 0;
        return arr;
    }

    private static int[] shiftLeft(int[] arr){
        for (int k = 0; k < arr.length - 1; k++) {
            int el1 = arr[k+1];
            arr[k] = el1;
        }
        arr[arr.length-1] = 0;
        return arr;
    }

    private static void shiftArray(int[] arr7, int n) {
        System.out.print("Исходный массив: " + Arrays.toString(arr7));
        for (int k = 0; k < Math.abs(n) ; k++) {
            if (n>0)
                arr7 = shiftRight(arr7);
            else
                arr7 = shiftLeft(arr7);
        }
        System.out.println(" сдвинули на " + (n) + ": " + Arrays.toString(arr7));
    }
}

