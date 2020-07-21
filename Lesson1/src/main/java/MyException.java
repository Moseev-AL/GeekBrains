public abstract class MyException extends Exception {
    private String exceptionMessage;

    public MyException() {}

    public String showExceptionMessage(){
        return exceptionMessage;
    };

    public abstract String getExceptionMessage();
}
