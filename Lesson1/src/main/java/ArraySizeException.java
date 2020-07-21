
public class ArraySizeException extends MyException {
    private String exceptionMessage;

    public ArraySizeException() {
        super();
        this.exceptionMessage = "Размерность массива превышает допустимую";
    }

    @Override
    public String getExceptionMessage() {
        return exceptionMessage;
    }
}