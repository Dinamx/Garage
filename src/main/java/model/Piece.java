package model;

import DAO.PiecesDAO;
import database.core.DBObject;
import manipDb.Connexion;
import manipDb.ObjetBDD;

import java.sql.Connection;
import java.sql.SQLException;

public class Piece extends ObjetBDD {

    String piece;
    int idUnite;
    int idModele;



    public Piece(String piece, int idUnite, int idModele) {
        this.piece = piece;
        this.idUnite = idUnite;
        this.idModele = idModele;
    }

    public Piece() {
    }



    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }

    public int getIdUnite() {
        return idUnite;
    }

    public void setIdUnite(int idUnite) {
        this.idUnite = idUnite;
    }

    public int getIdModele() {
        return idModele;
    }

    public void setIdModele(int idModele) {
        this.idModele = idModele;
    }

    public static void main(String[] args) throws Exception {
        Connection connection= new Connexion().getConnexion();
        Piece p=new Piece("huile", 2,1);
            ;
        System.out.println(PiecesDAO.getPieceId(p,connection));
        connection.close();
    }
}
