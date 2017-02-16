package mccann.kevin.typeinformation;

/**
 * Created by kevinmccann on 2/15/17.
 */
public class MyClass extends MySuperClass implements MyInterface {
    int myField;


    @Override
    public int myMethod() {
        return myField;
    }
}
