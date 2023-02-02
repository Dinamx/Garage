package DAO;

import exeptions.MontantInvalide;
import exeptions.RestePayementException;
import model.facture.Facture_service;
import model.userBasic.Client;
import views.DetailFacturePromus;
import views.FactureDetails;

import java.sql.Connection;
import java.util.Vector;

public class FactureDAO {
    public static Vector<Facture_service> listeFactureService(Connection connection, String condition) throws Exception {
        Object[] facture=new Facture_service().findAll(connection,"");
        Vector<Facture_service> factures=new Vector<>();
        for (int i = 0; i < facture.length; i++) {
            factures.add((Facture_service) facture[i]);
        }
        return factures;
    }
    public static Vector<FactureDetails> listeFactureDetails(Connection connection) throws Exception {
        Object[] facture=new FactureDetails().findAll(connection,"");
        Vector<FactureDetails> factures=new Vector<>();
        for (int i = 0; i < facture.length; i++) {
            factures.add((FactureDetails) facture[i]);
        }
        return factures;
    }
    public static boolean checkMontantPayementFacture(int idFacture, double montant , Connection connection) throws Exception {
        FactureDetails facture= (FactureDetails) new FactureDetails().find(connection, " where id_facture="+idFacture);
        if(montant<=0)
        {
            throw new MontantInvalide();
        }
        else if(montant>facture.getReste())
        {
            throw new RestePayementException(montant-facture.getReste());
        }
        else{
            return true;
        }
    }

    // liste des details factures avect promotion -> tokony afficher-na ao @
    public static Vector<DetailFacturePromus> listeFactureEtPromotion(int idFacture, Connection connection) throws Exception {

        Vector<DetailFacturePromus> detail=new Vector<>();
        try{
            Object[] liste = new DetailFacturePromus().findAll(connection, " id_facture=" + idFacture);

            detail= new Vector<>();
            for (int i = 0; i < liste.length; i++) {
                detail.add((DetailFacturePromus) liste[i]);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return detail;
    }

}
