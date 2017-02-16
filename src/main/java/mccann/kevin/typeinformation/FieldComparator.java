package mccann.kevin.typeinformation;

import java.lang.reflect.Field;
import java.util.Comparator;

/**
 * Created by kevinmccann on 2/15/17.
 */
public class FieldComparator implements Comparator<Field>{
    @Override
    public int compare(Field o1, Field o2) {
        return o1.getName().compareTo(o2.getName());
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
