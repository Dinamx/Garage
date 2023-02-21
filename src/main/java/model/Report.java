package model;

import database.core.*;
import database.exception.SQL.AttributeMissingException;
import database.exception.SQL.AttributeTypeNotExistingException;
import manipDb.ObjetBDD;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Report extends DBObject {
    Timestamp dateReport;
    double montantReport;

    public Report(Timestamp dateReport, double montantReport) {
        this.dateReport = dateReport;
        this.montantReport = montantReport;
    }

    public Report() {
    }

    public Timestamp getDateReport() {
        return dateReport;
    }

    public void setDateReport(Timestamp dateReport) {
        this.dateReport = dateReport;
    }

    public double getMontantReport() {
        return montantReport;
    }

    public void setMontantReport(double montantReport) {
        this.montantReport = montantReport;
    }
    public static Sequence getSequence()
    {
        return new Sequence("",3, "report");
    }

    public static void main(String[] args) throws SQLException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, AttributeTypeNotExistingException, AttributeMissingException {
        Database database= Config.getPgDb();
        DBConnection dbConnection=database.createConnection();
        Report r=new Report();
        r.createTable(dbConnection);
//        r.save(dbConnection);
        dbConnection.commit();
        dbConnection.close();
    }
}
