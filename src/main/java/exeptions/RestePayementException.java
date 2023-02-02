package exeptions;

public class RestePayementException extends Exception{
    double resteMontant;

    public double getResteMontant() {
        return resteMontant;
    }

    public void setResteMontant(double resteMontant) {
        this.resteMontant = resteMontant;
    }

    public RestePayementException(double resteMontant) {
        setResteMontant(resteMontant);
    }
}
