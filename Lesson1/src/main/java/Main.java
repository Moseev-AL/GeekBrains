
public class Main {

    /**
     * Пытаемся преобразовать строку в Int
     * @param text
     * @return
     */
    public static Object tryParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Проверка массива на превышение длины
     * @param arr
     * @return True, если массив содержит элемент некорректной длины
     */
    public static boolean checkArrayLength(String[][] arr){
        int arrayMaxLength = 4;
        if (arr.length > arrayMaxLength){
           return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length > arrayMaxLength) {
                return false;
            }
        }

        return true;
    }

    public static void generateArrayException(String[][] arr) {
        try {
            if (!checkArrayLength(arr)) {
                throw new ArraySizeException();
            }

            int arrSum = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    Object val = tryParse(arr[i][j]);
                    if (val == null) {
                        throw new ArrayDataException(i, j);
                    }
                    arrSum += (int) val;
                }
            }
            System.out.println("Сумма элементов = " + arrSum);
        } catch (ArrayDataException | ArraySizeException ex) {
            System.out.println(ex.getExceptionMessage());
        }

    }

    public static void main(String[] args) {
        String[][] arr = new String[][]{{"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};
        generateArrayException(arr);

    }

}

