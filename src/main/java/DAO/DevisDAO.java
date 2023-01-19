package DAO;

import model.TypeService;

import java.sql.Connection;
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

    /** AUTRES */


}
