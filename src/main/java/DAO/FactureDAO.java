package DAO;

import exeptions.MontantInvalide;
import exeptions.RestePayementException;
import model.facture.Facture_service;
import model.userBasic.Client;
import views.DetailFacturePromus;
import views.EmployeDetail;
import views.FactureDetails;

import java.sql.*;
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

    public static Vector<FactureDetails> ListeDetailFactureA(Connection connection) throws SQLException {
        String querry="select * from facturedetails ";
        PreparedStatement preparedStatement= connection.prepareStatement(querry);
        ResultSet res= preparedStatement.executeQuery();
        Vector<FactureDetails> emp=new Vector<>();
        while (res.next())

            {
           Date date= Date.valueOf((res.getString(res.findColumn("datefacture"))));;
            int id_facture= Integer.parseInt(res.getString(res.findColumn("id_facture")));;
            int idclient= Integer.parseInt(res.getString(res.findColumn("idclient")));;
            double prixTotal= Double.parseDouble(res.getString(res.findColumn("total")));;
            double payee= Double.parseDouble(res.getString(res.findColumn("payee")));;
            double reste= Double.parseDouble(res.getString(res.findColumn("reste")));;
            emp.add(new FactureDetails(id_facture,idclient,prixTotal,payee,reste,date));
        }
        return emp;
    }


    public static boolean factureAnnuelle(Connection connection , int idClient) throws SQLException {
        String querry = "select * from facturedetails where to_char(datefacture,'yyyy')='2023' and idclient=" + idClient;
        PreparedStatement preparedStatement = connection.prepareStatement(querry);
        ResultSet res = preparedStatement.executeQuery();
        System.out.println("check commande annee");

        Vector<FactureDetails> emp=new Vector<>();
        while (res.next())

        {
            Date date= Date.valueOf((res.getString(res.findColumn("datefacture"))));;
            int id_facture= Integer.parseInt(res.getString(res.findColumn("id_facture")));;
            int idclient= Integer.parseInt(res.getString(res.findColumn("idclient")));;
            double prixTotal= Double.parseDouble(res.getString(res.findColumn("total")));;
            double payee= Double.parseDouble(res.getString(res.findColumn("payee")));;
            double reste= Double.parseDouble(res.getString(res.findColumn("reste")));;
            emp.add(new FactureDetails(id_facture,idclient,prixTotal,reste,payee,date));
        }
    if(emp.size()==0)
    {
        return true;
    }
    else return false;
    }


}
