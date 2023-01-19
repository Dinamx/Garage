package DAO;

import manipDb.Connexion;
import model.*;
import views.AchatVente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class PiecesDAO {

    /** LISTES */
    public static Vector<Piece> listePiece(Connection connection, String extracondition) throws Exception {
        Object[] piece=new Piece().findAll(connection, extracondition);
        Vector<Piece> pieces=new Vector<>();
        for (int i = 0; i < piece.length; i++) {
            pieces.add((Piece) piece[i]);
        }
        return pieces;
    }
    public static Vector<Marque> listeMarque(Connection connection) throws Exception {
        Object[] marque=new Marque().findAll(connection,"");
        Vector<Marque> marques=new Vector<>();
        for (int i = 0; i < marque.length; i++) {
            marques.add((Marque) marque[i]);
        }
        return marques;
    }
    public static Vector<Unite> listeUnite(Connection connection) throws Exception {
        Object[] unite=new Unite().findAll(connection,"");
        Vector<Unite> unites=new Vector<>();
        for (int i = 0; i < unite.length; i++) {
            unites.add((Unite) unite[i]);
        }
        return unites;
    }
    public static Vector<Modele> listeModele(Connection connection) throws Exception {
        Object[] modele=new Modele().findAll(connection,"");
        Vector<Modele> modeles=new Vector<>();
        for (int i = 0; i < modele.length; i++) {
            modeles.add((Modele) modele[i]);
        }
        return modeles;
    }

    public static Vector<AchatPiece> listeProduitStock(Connection connection) throws Exception {
        Object[] modele=new AchatPiece().findAll(connection,"");
        Vector<AchatPiece> stockProduits=new Vector<>();
        for (int i = 0; i < modele.length; i++) {
            stockProduits.add((AchatPiece) modele[i]);
        }
        return stockProduits;
    }

    public static Vector<AchatVente> listeAchatVente(Connection connection) throws Exception{
        Object[] achatVente=new AchatVente().findAll(connection,"");
        Vector<AchatVente> stockProduits=new Vector<>();
        for (int i = 0; i < achatVente.length; i++) {
            stockProduits.add((AchatVente) achatVente[i]);
        }
        return stockProduits;
    }

    /** IDS */
    public static int getPieceId(Piece piece,Connection connection) throws SQLException {
        String querry="select id from piece where piece='"+piece.getPiece()+"' and idunite="
                +piece.getIdUnite()+" and idModele="+piece.getIdModele();
        PreparedStatement preparedStatement= connection.prepareStatement(querry);
        ResultSet res= preparedStatement.executeQuery();
        int r=-1;
        while(res.next())
        {
            r= res.getInt(res.findColumn("id"));
        }
        return r;
    }

    public static void main(String[] args) throws Exception {
        Connection connection=new Connexion().getConnexion();

        Vector<Piece> pieces = PiecesDAO.listePiece(connection, "");
        System.out.println(pieces.size());

    }
}
