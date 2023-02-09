package DAO;

import manipDb.Connexion;
import model.depenses.TypeDepense;
import views.DetailBudjet;

import java.sql.Connection;
import java.util.Vector;

public class DepensesDAO {

    public static Vector<TypeDepense>getListDepenses(Connection connection) throws Exception {
        Object[] depense=new TypeDepense().findAll(connection,"");
        Vector<TypeDepense> depenses=new Vector<>();
        for (int i = 0; i < depense.length; i++) {
            depenses.add((TypeDepense)depense[i]);
            System.out.println(((TypeDepense) depense[i]).getType());

        }
        return depenses;
    }

    public static Vector<TypeDepense>getListDepense(Connection connection) throws Exception {
        Object[] liste=new TypeDepense().findAll(connection,"");
        Vector <TypeDepense> depenses=new Vector<>();
        for (int i = 0; i < liste.length; i++) {
            depenses.add(new TypeDepense(((TypeDepense)liste[i]).getId(),((TypeDepense)liste[i]).getType()));
        }
        return depenses;
    }

    public static Vector<DetailBudjet> listDetailBudjet(Connection connection) throws Exception {
        Object[] depense=new DetailBudjet().findAll(connection,"");
        Vector<DetailBudjet> depenses=new Vector<>();
        for (int i = 0; i < depense.length; i++) {
            depenses.add((DetailBudjet)depense[i]);
        }
        return depenses;
    }

    public static double TotalRecette (Vector<DetailBudjet> detail)
    {
        double res=0;
        for (int i = 0; i < detail.size(); i++) {
            res+=detail.get(i).getRecette();
        }
        return res;
    }
    public static double depensesTotal(Vector<DetailBudjet> detail) {
        double res = 0;
        for (int i = 0; i < detail.size(); i++) {
            res += detail.get(i).getTotaldepense();
        }
        return res;
    }
    public static double Caisse(Vector<DetailBudjet> detail) {
       return TotalRecette(detail)-depensesTotal(detail);
    }


    public static void main(String[] args) throws Exception {
        Vector<TypeDepense> p=getListDepense(new Connexion().getConnexion());
        for (int i = 0; i < p.size(); i++) {
            System.out.println(p.get(i).getType());
        }
        Object[] depense=new TypeDepense().findAll(new Connexion().getConnexion(),"");
        Vector<TypeDepense> depenses=new Vector<>();
        for (int i = 0; i < depense.length; i++) {
            depenses.add((TypeDepense) depense[i]);
            System.out.println(((TypeDepense) depense[i]).getType());
        }
        System.out.println(p.size());
    }
}
