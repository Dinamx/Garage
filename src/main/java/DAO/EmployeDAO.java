package DAO;

import model.Genre;
import model.NiveauEtude;
import model.Specialite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class EmployeDAO {
 /*   public static Vector<Genre> listeGenre(Connection connection, String extraCondition) throws Exception {
        Genre g=new Genre();
        Object [] genre=g.findAll(connection,extraCondition);
        Vector<Genre> gen=new Vector<>();
        for (int i = 0; i < genre.length; i++) {
            gen.add((Genre) genre[i]);
        }
        return gen;
    }*/

    public static Vector<NiveauEtude> listeNiveauEtude(Connection connection,String extracondition) throws Exception {
        Object [] nivEtude=new NiveauEtude().findAll(connection,extracondition);
        Vector<NiveauEtude> gen=new Vector<>();
        for (int i = 0; i < nivEtude.length; i++) {
            gen.add((NiveauEtude) nivEtude[i]);
        }
        return gen;
    }
    public static Vector<Specialite> listeSpecialites(Connection connection, String extracondition) throws Exception {
        Object [] spec=new Specialite().findAll(connection,extracondition);
        Vector<Specialite> gen=new Vector<>();
        for (int i = 0; i < spec.length; i++) {
            gen.add((Specialite) spec[i]);
        }
        return gen;
    }

    public static Vector<Integer> listeIdSpecialites(Connection connection) throws SQLException {
        String querry="select id from specialite";
        PreparedStatement preparedStatement= connection.prepareStatement(querry);
        ResultSet res=preparedStatement.executeQuery();
        Vector<Integer> id=new Vector<>();
        while (res.next())
        {
            id.add(res.getInt(res.findColumn("id")));
        }
        return id;
    }

    public static Vector<Integer> listeIdNiveauEtude(Connection connection) throws SQLException {
        String querry="select id from niveauetude";
        PreparedStatement preparedStatement= connection.prepareStatement(querry);
        ResultSet res=preparedStatement.executeQuery();
        Vector<Integer> id=new Vector<>();
        while (res.next())
        {
            id.add(res.getInt(res.findColumn("id")));
        }
        return id;
    }

}
