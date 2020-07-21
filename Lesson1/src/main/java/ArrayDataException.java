public class ArrayDataException extends MyException {
    private String exceptionMessage;
    private int i;
    private int j;

    public ArrayDataException(int i, int j) {
        super();
        this.i = i;
        this.j = j;
        this.exceptionMessage = "Массив содержит не Int в ячейке [" + i + "][" + j + "]";
    }

    @Override
    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
