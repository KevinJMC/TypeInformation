package mccann.kevin.typeinformation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kevinmccann on 2/15/17.
 */
public class TypeInfoTest {

    TypeInfo typeInfo;

    @Before
    public void setUp() {
        typeInfo = new TypeInfo();
    }

    @Test
    public void classImplementsInterfaceTest() {
        ;
        String s = ""
        boolean expected = true;
        boolean actual = typeInfo.classImplementsInterface();
    }

    @Test
    public void classImplementsInterfaceTest2() throws Exception {

    }

    @Test
    public void listAllMembersTest() {

    }

    @Test
    public void getClassHierarchyTest() {

    }

    @Test
    public void instantiateClassHierarchyTest() {

    }

}