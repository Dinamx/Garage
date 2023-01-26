package DAO;

import views.Service;

import java.sql.Connection;
import java.util.Vector;

public class ServiceDAO {
//    liste services;
    public static Vector<Service> listeservice(Connection connection, int idService) throws Exception {
        Object [] service=new Service().findAll(connection, " id="+idService);
        Vector<Service> services=new Vector<>();
        for (int i = 0; i < service.length; i++) {
            services.add((Service) service[i]);
        }
        return services;
    }
}
