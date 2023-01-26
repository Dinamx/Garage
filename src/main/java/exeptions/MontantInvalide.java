package exeptions;

public class MontantInvalide extends Exception{
    public MontantInvalide() {
        super("montant inferieure a 0 invalide ");
    }
}
