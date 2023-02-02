package DAO;

import manipDb.Connexion;
import model.service.TypeService;
import model.userBasic.NiveauEtude;
import model.specialite.Specialite;
import views.EmployeDetail;
import views.Service;
import views.SpecEmp;

import java.sql.*;
import java.util.Vector;

public class EmployeDAO {
    /** LISTES */
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
        System.out.println(spec.length);
        return gen;
    }

    public static Vector<EmployeDetail> listeEmployeDetail2(Connection connection) throws SQLException {
        String querry="select * from employedetail order by nom asc";
        PreparedStatement preparedStatement= connection.prepareStatement(querry);
        ResultSet res= preparedStatement.executeQuery();
        Vector<EmployeDetail> emp=new Vector<>();
        while (res.next())
        {
            int idemp=res.getInt(res.findColumn("id_employe"));
            String nom=res.getString(res.findColumn("nom"));
            String prenom=res.getString(res.findColumn("prenom"));
            Date dateNaissance=res.getDate(res.findColumn("dateNaissance"));
            String niveauEtude=res.getString(res.findColumn("niveauetude"));
            String telephone=res.getString(res.findColumn("numerotelephone"));
            String genre=res.getString(res.findColumn("genre"));
            double salaireMontant=res.getDouble(res.findColumn("salairemontant"));
            double salaireHoraire=res.getDouble(res.findColumn("salairehoraire"));
            emp.add(new EmployeDetail(idemp,nom,prenom,dateNaissance,genre,telephone,salaireMontant,salaireHoraire,niveauEtude));
        }
        return emp;
    }
//    liste des specialites employes en fonction de l'id de l'employe
    public static Vector<SpecEmp> listSpecialiteEmp(Connection connection,int id_emp) throws Exception {
        Object [] spec=new SpecEmp().findAll(connection,"idemploye="+id_emp);
        Vector<SpecEmp> gen=new Vector<>();
        for (int i = 0; i < spec.length; i++) {
            gen.add((SpecEmp) spec[i]);
        }
        System.out.println(spec.length);
        return gen;
    }
//    liste specialites employes avec conditions
    public static Vector<SpecEmp> listSpecialiteEmp(Connection connection,String extraCondition) throws Exception {
        Object [] spec=new SpecEmp().findAll(connection,"where "+extraCondition);
        Vector<SpecEmp> gen=new Vector<>();
        for (int i = 0; i < spec.length; i++) {
            gen.add((SpecEmp) spec[i]);
        }
        System.out.println(spec.length);
        return gen;
    }

//    liste des employes selon une specialites
    public static Vector<SpecEmp> getAllEmployes(Connection connection,int idSpecialites) throws Exception {
        Object [] spec=new SpecEmp().findAll(connection,"idspecialite="+idSpecialites);
        Vector<SpecEmp> gen=new Vector<>();
        for (int i = 0; i < spec.length; i++) {
            gen.add((SpecEmp) spec[i]);
        }
        System.out.println(spec.length);
        return gen;
    }

//    liste emp-spec e fonction des specialites
    public static Vector<Vector<SpecEmp>> listSpecialiteEmp(Connection connection, Vector<Service> services) throws Exception {
        Vector<Vector<SpecEmp>> employeParSpec=new Vector<>();
        for (int i = 0; i < services.size(); i++) {
            employeParSpec.add(getAllEmployes(connection,services.get(i).getIdSpecialites()));
        }
        return employeParSpec;
    }

    public static Vector<SpecEmp> listSpecialiteEmp(int id_emp) throws Exception {
        Connection connection=new Connexion().getConnexion();
        Vector<SpecEmp> gen=listSpecialiteEmp(connection,id_emp);
        connection.close();
        return gen;
    }

    public static Vector<Vector<SpecEmp>> specialitesEmplist(Connection connection,Vector<EmployeDetail> empdetails) throws Exception {
        Vector<Vector<SpecEmp>> spec=new Vector<>();
        for (int i = 0; i < empdetails.size(); i++) {
//
            spec.add(listSpecialiteEmp(connection,empdetails.get(i).getId_employe()));
        }
        return spec;
    }

    /** LIST IDS */

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


    /** GET IDS */
    public static int getNiveauEtudeID(String niveauEtude,Connection connection) throws Exception {
        Vector<NiveauEtude> niv=listeNiveauEtude(connection,"");
        Vector<Integer> id=listeIdNiveauEtude(connection);
        int index=-1;
        for (int i = 0; i < niv.size(); i++) {
            if(niv.get(i).getDescription().equals(niveauEtude))
            {
                index=i;
            }
        }
        return id.get(index);
    }

    public static int getSpecialiteId(Connection connection,String specialites) throws Exception {
        Vector<Specialite> spec=listeSpecialites(connection,"");
        Vector<Integer> id=listeIdSpecialites(connection);
        int index=-1;
        for (int i = 0; i < spec.size(); i++) {
            if(spec.get(i).getSpecialite().equals(specialites))
            {
                index=i;
            }
        }
        return id.get(index);
    }



    public static void main(String[] args) throws Exception {
        Connection connection=new Connexion().getConnexion();

            Vector<EmployeDetail> e=listeEmployeDetail2(connection);
            Vector<Vector<SpecEmp>> se=specialitesEmplist(connection,e);
            Vector<TypeService> listeService=ServiceDAO.listeTypeService(connection);
            Vector<Service> services=ServiceDAO.listeservice(connection,2);
            Vector<Vector<SpecEmp>> specialitesEmp= EmployeDAO.listSpecialiteEmp(connection, services);

        for (int i = 0; i < specialitesEmp.size(); i++) {
            System.out.println("specialite : "+services.get(i).getSpecialite());
            for (int j = 0; j < specialitesEmp.get(i).size(); j++) {
                System.out.println(specialitesEmp.get(i).get(j).getNom());
            }
        }
        System.out.println(e.size());
        connection.close();
    }

}
