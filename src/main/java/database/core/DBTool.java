package database.core;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DBTool {
    public static String upperFirst(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }

    /** Get all fields in the superclass and the object */
    public static Field[] getFieldWithSuperclass(Object object) {
        Class<?> clazz = object.getClass();
        List<Field> fieldList = new ArrayList<>();
        while (clazz != null) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                fieldList.add(field);
            }
            clazz = clazz.getSuperclass();
        }
        return fieldList.toArray(new Field[fieldList.size()]);
    }

//    Tsy mahazaka List.of sy .addAll ny java ako du coup j'ai modifié un peu le truc
//    Misy switch nosoloko koa any ho any fa tsy tadidiko tsara.
//    public static Field[] getFieldWithSuperclass(Object object) {
//        List<Field> fieldList = new ArrayList<>(List.of(object.getClass().getSuperclass().getDeclaredFields()));
//        fieldList.addAll(List.of(object.getClass().getDeclaredFields()));
//        return fieldList.toArray(new Field[0]);
//    }
}
