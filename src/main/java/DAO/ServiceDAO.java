package DAO;

import Alea.Produit;
import model.service.TypeService;
import views.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ServiceDAO {
//    maka liste ana service + toutes ses specialites oh : mecanicien ect...
    public static Vector<Service> listeservice(Connection connection, int idService) throws Exception {
        Object [] service=new Service().findAll(connection, " id="+idService);
        Vector<Service> services=new Vector<>();
        for (int i = 0; i < service.length; i++) {
            services.add((Service) service[i]);
        }
        return services;
    }

    public static double getMarge(double nombre, Connection connection) throws SQLException {
        String column="marge";
        String nomFunction="";
        String querry="select getmargebeneficiaire("+nombre+") as marge";

        PreparedStatement preparedStatement= connection.prepareStatement(querry);
        ResultSet res=preparedStatement.executeQuery();
        double result=-1;
        while(res.next())
        {
            result=res.getDouble(res.findColumn(column));
        }
        return result;
    }
    public static Vector<Produit> listeProduit(Connection connection) throws Exception {
        Object [] service=new Produit().findAll(connection, "");
        Vector<Produit> services=new Vector<>();
        for (int i = 0; i < service.length; i++) {
            services.add((Produit) service[i]);
        }
        return services;
    }

    public static Vector<TypeService> listeTypeService(Connection connection) throws Exception {
        Object [] service=new TypeService().findAll(connection, "");
        Vector<TypeService> services=new Vector<>();
        for (int i = 0; i < service.length; i++) {
            services.add((TypeService) service[i]);
        }
        return services;
    }


   /* public static void main(String[] args) {
        Connection
    }*/
}
