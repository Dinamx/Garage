package DAO;

import database.core.Config;
import database.core.DBConnection;
import database.core.DBObject;
import database.core.Database;
import model.Report;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Vector;

public class ReportDAO {
    public static Report getLastReport (Timestamp date, DBConnection dbConnection) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String condition=" \"dateReport\" <'"+date+"' order by \"dateReport\" desc limit 1";
//        Dina
        Report report= (Report) new Report().get(dbConnection, condition);
        return report;
    }

    public static double getDepense  (Report r, Connection connection) throws SQLException {
        String requette="select sum(montant) as montant from depense where datedepense between '"+r.getDateReport()+"' and now()";
        PreparedStatement preparedStatement= connection.prepareStatement(requette);
        ResultSet resultSet = preparedStatement.executeQuery();
        double depense=0;
        while (resultSet.next())
        {
            depense= resultSet.getDouble(resultSet.findColumn("montant"));
        }
        return depense;
    }

    public static double getRecette (Report r, Connection connection) throws SQLException {
        String requette="select sum(payee) as montant from facturedetail2 where date_facture between '"+r.getDateReport()+"' and now()";
        PreparedStatement preparedStatement= connection.prepareStatement(requette);
        ResultSet resultSet = preparedStatement.executeQuery();
        double recette=0;
        while (resultSet.next())
        {
            recette= resultSet.getDouble(resultSet.findColumn("montant"));
        }
        return recette+r.getMontantReport();
    }



    public static void main(String[] args) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Database database= Config.getPgDb();
        DBConnection dbConnection=database.createConnection();
        Report r=getLastReport(Timestamp.from(Instant.now()), dbConnection);

        System.out.println(r.getDateReport()+"  montant="+r.getMontantReport());

        dbConnection.close();
        dbConnection.commit();
    }
}
