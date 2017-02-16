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
    public void classImplementsInterfaceStringTest() {
        assertTrue(typeInfo.classImplementsInterface("MyClass", "MyInterface"));
    }

    @Test
    public void classImplementsInterfaceClassTest(){
        assertTrue(typeInfo.classImplementsInterface(MyClass.class, "MyInterface"));
    }

    @Test
    public void classImplementsInterfaceObjectTest() {
        assertTrue(typeInfo.classImplementsInterface(myClass, "MyInterface"));
    }

    @Test
    public void listAllMembersTest() {
        String expected = "MyClass myField\nMyClass public myMethod\nMySuperClass public sayGirlSay\n" +
                "Object protected clone\nObject equals\nObject finalize\nObject getClass\nObject hashCode\n" +
                "Object notify\nObject notifyAll\nObject toString\nObject wait";
        String actual = typeInfo.listAllMembers(myClass);
        assertEquals(expected,actual);
    }

    @Test
    public void getClassHierarchyTest() {
        String expected = "MyClass\n  MySuperClass\n    java.lang.Object";
        String actual = typeInfo.getClassHierarchy(myClass);
        assertEquals(expected,actual);
    }

    @Test
    public void instantiateClassHierarchyTest() {
        List<Object> classHierarchy = typeInfo.instantiateClassHierarchy(myClass);
        assertTrue(classHierarchy.get(0) instanceof MyClass);
        assertTrue(classHierarchy.get(1) instanceof MySuperClass);
        assertTrue(classHierarchy.get(2) instanceof java.lang.Object);

    }

}