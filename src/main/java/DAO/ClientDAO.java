package DAO;

import manipDb.Connexion;
import model.userBasic.Client;
import model.pieces.Vehicule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ClientDAO {

    public static boolean checkClient(int idClient, Connection connection) throws Exception {
        Client c= (Client) new Client().find(connection," where id = "+idClient);
        return c != null;
    }

//    liste vehicules
    public static Vector<Vehicule> listeVehicule(Connection connection) throws Exception {
        Object[] vehicule=new Vehicule().findAll(connection,"");
        Vector<Vehicule> vehicules=new Vector<>();
        for (int i = 0; i < vehicule.length; i++) {
            vehicules.add((Vehicule) vehicule[i]);
        }
        return vehicules;
    }

    public static int getVehicleId(String immatriculation,Connection connection) throws SQLException {
        String querry="select id from vehicule where immatriculation='"+immatriculation+"'";
        PreparedStatement preparedStatement= connection.prepareStatement(querry);
        ResultSet res=preparedStatement.executeQuery();
        int id=-1;
        while(res.next())
        {
            id=res.getInt(res.findColumn("id"));
        }
        return id;
    }


    public static void main(String[] args) throws Exception {
        System.out.println(checkClient(1,new Connexion().getConnexion()));
    }
}
