package mccann.kevin.typeinformation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * Created by kevinmccann on 2/15/17.
 */
public class TypeInfo {
  boolean classImplementsInterface(String className, String interfaceName) throws ClassNotFoundException{
      try {
          return classImplementsInterface(Class.forName(className), interfaceName);
      } catch (ClassNotFoundException e){
          System.out.println("Class not found");
          e.printStackTrace();
      }
        return false;
  }

  boolean classImplementsInterface(Object o, String interfaceName) {
      Class clazz = o.getClass();
      return classImplementsInterface(clazz, interfaceName);
  }

  boolean classImplementsInterface(Class clazz, String interfaceName) {
      System.out.println(clazz.getInterfaces()[0]);
      return clazz.getInterfaces()[0].toString().contains(interfaceName);
  }

  String listAllMembers(Object o) throws NoSuchMethodException{
      StringBuilder sb = new StringBuilder();
      try{
          Class c = o.getClass();
          while(c!=null) {
              String name = c.getSimpleName();
              Field[] fields = c.getDeclaredFields();
              SortedSet<Field> sortedFields = new TreeSet<Field>(new FieldComparator());
              sortedFields.addAll(Arrays.asList(fields));
              Constructor constructor = c.getConstructor();
              Method[] methods = c.getDeclaredMethods();
              SortedSet<Method> sortedMethods = new TreeSet<Method>(new MethodComparator());
              sortedMethods.addAll(Arrays.asList(methods));
              for (Field f : sortedFields) {
                  sb.append(name + " " + Modifier.toString(f.getModifiers()) + " " + f.getName() + "\n");
              }
              sb.append(name + " " + constructor.getName() + "\n");
              for (Method m : sortedMethods) {
                  sb.append(name + " " + Modifier.toString(m.getModifiers()) + " " + m.getName() + "\n");
              }
              c=c.getSuperclass();
          }
      } catch (NoSuchMethodException e) {
          e.printStackTrace();
      }
      return sb.toString();
  }

  String getClassHierarchy(Object o) {
      StringBuilder sb = new StringBuilder();
      Class clazz = o.getClass();
      String currentIndent = "";
      while(clazz!=null) {
          String name = clazz.getSimpleName();
          sb.append(currentIndent + name+"\n");
          clazz=clazz.getSuperclass();
          currentIndent = currentIndent + "\t";
      }
      return sb.toString();
  }

  List<Object> instantiateClassHierarchy (Object o) throws Exception{
      Class c = o.getClass();
      ArrayList<Object> listOfNewObjects = new ArrayList<>();
      try {
          while (c != null) {
              listOfNewObjects.add(c.newInstance());
              c=c.getSuperclass();
          }
      } catch (Exception e) {
          e.printStackTrace();
      }
      return listOfNewObjects;
  }
}
