package mccann.kevin.typeinformation;

import java.lang.reflect.Method;
import java.util.Comparator;

/**
 * Created by kevinmccann on 2/15/17.
 */
public class MethodComparator implements Comparator<Method> {
    @Override
    public int compare(Method o1, Method o2) {
        return o1.getName().compareTo(o2.getName());
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}