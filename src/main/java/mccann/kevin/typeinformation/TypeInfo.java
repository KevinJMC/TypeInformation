package mccann.kevin.typeinformation;

import java.util.List;

/**
 * Created by kevinmccann on 2/15/17.
 */
public class TypeInfo {
  boolean classImplementsInterface(String className, String interfaceName) {}

  boolean classImplementsInterface(Object o, String interfaceName) {}

  boolean classImplementsInterface(Class clazz, String interfaceName) {}

  String listAllMembers(Object o) {}

  String getClassHierarchy(Object o) {}

  List<Object> instantiateClassHierarchy (Object o) {}
}
