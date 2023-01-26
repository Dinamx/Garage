package exeptions;

public class EmptyFieldException extends Exception{
    String champ;

    public String getChamp() {
        return champ;
    }

    public void setChamp(String champ) {
        this.champ = champ;
    }

    public EmptyFieldException() {
        super("certains champs ne peuvent pas être vide");
    }
    public EmptyFieldException(String champ) {
        super("le champ "+ champ+" ne peut pas etre vide");
    }
}
