package DAO;

import model.service.TypeService;
import views.Benefices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class DevisDAO {

    /** LISTES */
    public static Vector<TypeService> listeServices(Connection connection) throws Exception {
        Object[] type=new TypeService().findAll(connection,"");
        Vector<TypeService> typeServices=new Vector<>();
        for (int i = 0; i < type.length; i++) {
            typeServices.add((TypeService) type[i]);
        }
        return typeServices;
    }

//    liste benefices
    public static Vector<Benefices> listebenefices(Connection connection) throws Exception {
        Object [] li=new Benefices().findAll(connection,"");
        Vector<Benefices> ben=new Vector<>();
        for (int i = 0; i < li.length; i++) {
            ben.add((Benefices) li[i]);
        }
        return ben;
    }

    /** AUTRES */

    public static double coutServiceEmployes(int idDemandeDevis, Connection connection) throws Exception
    {
        String querry="select sum(duree_service*devis.salaireHoraire) cout from devis where iddemande_devis="+idDemandeDevis;
        PreparedStatement preparedStatement= connection.prepareStatement(querry);
        ResultSet res= preparedStatement.executeQuery();
        double cout=0;
        while (res.next()) {
            cout=res.getDouble(res.findColumn("cout"));
        }
        return cout;
    }
}
