package DAO;

import manipDb.Connexion;
import model.userBasic.Client;
import model.pieces.Vehicule;
import views.EmployeDetail;

import java.sql.*;
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
    public static int getIdClient(Connection connection)
    {
       return 0;
    }
    public static Vector<Client> listeClient(Connection connection) throws Exception {
        Object[] client=new Client().findAll(connection,"");
        Vector<Client> clients=new Vector<>();
        for (int i = 0; i < client.length; i++) {
            clients.add((Client) client[i]);
        }
        return clients;
    }

    public  static Vector<Client> listAllClient(Connection connection, String condition ) throws SQLException {
        String querry="select * from client "+condition;
        PreparedStatement preparedStatement= connection.prepareStatement(querry);
        ResultSet res= preparedStatement.executeQuery();
        Vector<Client> clients=new Vector<>();
        while (res.next())
        {
            int id=res.getInt(res.findColumn("id"));
            String nom=res.getString(res.findColumn("nom"));;
            String prenom=res.getString(res.findColumn("prenom"));;
            String numero=res.getString(res.findColumn("numero")); ;
            Date dateNaissance=res.getDate(res.findColumn("dateDeNaissance"));
            clients.add(new Client(id, nom,prenom, numero, dateNaissance));
        }
        return clients;
    }






    public static void main(String[] args) throws Exception {
        System.out.println(checkClient(1,new Connexion().getConnexion()));
    }
}
