package exeptions;

public class EmptyFieldException extends Exception{
    public EmptyFieldException() {
        super("certains champs ne peuvent pas être vide");
    }
}
