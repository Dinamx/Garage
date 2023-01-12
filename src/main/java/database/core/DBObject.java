package database.core;

import database.exception.SQL.AttributeMissingException;
import database.exception.SQL.AttributeTypeNotExistingException;
import database.exception.object.NotIdentifiedInDatabaseException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

public class DBObject {
    String id;

    public void createTable(DBConnection dbConnection) throws SQLException, AttributeTypeNotExistingException, AttributeMissingException {
        dbConnection.getDatabase().createTable(dbConnection.getConnection(), this);
        dbConnection.getDatabase().createSequence(dbConnection.getConnection(), getClass().getSimpleName()+"_seq");
    }
    public void save(DBConnection dbConnection) throws SQLException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        setId(getIdSequence(dbConnection));
//        setId("default");
        dbConnection.getDatabase().insertObject(dbConnection.getConnection(), this);
    }

    void update(DBConnection dbConnection, String condition) throws SQLException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        dbConnection.getDatabase().updateObject(dbConnection.getConnection(), condition, this);
    }

    public void update(DBConnection dbConnection) throws SQLException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, NotIdentifiedInDatabaseException {
        update(dbConnection,"id='"+getId()+"'");
    }

    void delete(DBConnection dbConnection, String condition) throws SQLException {
        dbConnection.getDatabase().delete(dbConnection.getConnection(), getClass().getSimpleName(), condition);
    }

    public void delete(DBConnection dbConnection) throws SQLException, NotIdentifiedInDatabaseException {
        delete(dbConnection, "id='"+getId()+"'");
    }

    public List<Object> getAll(DBConnection dbConnection, String condition) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return dbConnection.getDatabase().selectListObject(dbConnection.getConnection(), getClass(), condition);
    }

    public List<Object> getAll(DBConnection dbConnection) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return getAll(dbConnection, "1=1");
    }

    public Object get(DBConnection dbConnection, String condition) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return dbConnection.getDatabase().selectObject(dbConnection.getConnection(), getClass(), condition);
    }

    public Object getById(DBConnection dbConnection, String id) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return get(dbConnection, "id='"+id+"'");
    }

    public void historize(DBConnection dbConnection, String action) throws SQLException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        dbConnection.getDatabase().insert(dbConnection.getConnection(), "history", Timestamp.from(Instant.now()), getClass().getSimpleName(), action, toString());
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() throws NotIdentifiedInDatabaseException {
        if(id == null) throw new NotIdentifiedInDatabaseException(this);
        return id;
    }
    public Object createObject(ResultSet res) throws Exception {
        Object s=this.getClass().getConstructor().newInstance();
        Field[] field=s.getClass().getDeclaredFields();


        System.out.println("--------------");
        for (int i = 0; i < field.length; i++) {
            String type=uppercaseFirstLetter(String.valueOf(field[i].getType()));
            String toadd=res.getString(res.findColumn(field[i].getName()));
            s.getClass().getMethod("set"+uppercaseFirstLetter(field[i].getName()),String.class).invoke(s,toadd);
        }
        return s;
    }
    public static String uppercaseFirstLetter(String mot)
    {
        String news;
        news=String.valueOf(mot.charAt(0));
        news=news.toUpperCase();
        if(mot.length()>1)
        {
            for(int i=1; i<mot.length(); i++)
            {
                news=news+String.valueOf(mot.charAt(i));
            }
        }
        return news;
    }
//    later
public String getIdSequence(DBConnection dbConnection) throws SQLException {
    String seq_name="seq"+getClass().getSimpleName().toLowerCase();
    String querry="select nextval('"+seq_name+"')";
    Statement statement=dbConnection.getConnection().createStatement();
    ResultSet result= statement.executeQuery(querry);
    String nextval="";
    if(result.next()) nextval=result.getString(1);
    String prefix=getClass().getSimpleName().toLowerCase().substring(0,3);
    return prefix+nextval;
}
}
