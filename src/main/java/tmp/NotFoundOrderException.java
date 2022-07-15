package tmp;

public class NotFoundOrderException extends RuntimeException {
    public NotFoundOrderException() {
        System.out.println("NOT FOUND Orders");
    }
}
