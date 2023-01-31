package model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MargeService {
  /*  public double getMarge(double prix)
    {
        if ( prix < 1000 &&  prix > 0 ){
            return 50;
        }
        else if ( prix < 2000 &&  prix > 1001 ){
            return 10;
        }
        else if ( prix < 5000 &&  prix > 2001 ){
            return 10;
        }
        else
            return 0;
    }*/
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
}
