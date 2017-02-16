package mccann.kevin.typeinformation;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kevinmccann on 2/15/17.
 */
public class TypeInfoTest {

    private TypeInfo typeInfo;
    private MyClass myClass;

    @Before
    public void setUp() {
        typeInfo = new TypeInfo();
        myClass = new MyClass();
    }

    @Test
    public void classImplementsInterfaceStringTest() throws ClassNotFoundException{
        assertTrue(typeInfo.classImplementsInterface("mccann.kevin.typeinformation.MyClass", "MyInterface"));
    }

    @Test
    public void classImplementsInterfaceClassTest(){
        assertTrue("MyClass doesn't implement MyInterface", typeInfo.classImplementsInterface(MyClass.class, "MyInterface"));
    }

    @Test
    public void classImplementsInterfaceObjectTest() {
        assertTrue(typeInfo.classImplementsInterface(myClass, "MyInterface"));
    }

    @Test
    public void listAllMembersTest() throws NoSuchMethodException {
        String expected = "MyClass  myField\nMyClass mccann.kevin.typeinformation.MyClass\nMyClass public myMethod\n" +
                "MySuperClass mccann.kevin.typeinformation.MySuperClass\nMySuperClass public sayGirlSay\n" +
                "Object java.lang.Object\nObject protected native clone\nObject public equals\n" +
                "Object protected finalize\nObject public final native getClass\nObject public native hashCode\n" +
                "Object public final native notify\nObject public final native notifyAll\n" +
                "Object private static native registerNatives\nObject public toString\n" +
                "Object public final wait\n";
        String actual = typeInfo.listAllMembers(myClass);
        assertEquals(expected,actual);
    }

    @Test
    public void getClassHierarchyTest() {
        String expected = "MyClass\n\tMySuperClass\n\t\tObject\n";
        String actual = typeInfo.getClassHierarchy(myClass);
        assertEquals(expected,actual);
    }

    @Test
    public void instantiateClassHierarchyTest() throws Exception{
        List<Object> classHierarchy = typeInfo.instantiateClassHierarchy(myClass);
        assertTrue(classHierarchy.get(0) instanceof MyClass);
        assertTrue(classHierarchy.get(1) instanceof MySuperClass);
        assertTrue(classHierarchy.get(2) instanceof java.lang.Object);

    }

}