package threadtest.api.reflect;

import java.util.Arrays;

public class ObjectA {
    String args[]=new String[]{"a","b","c"};

    @Override
    public String toString() {
        return "ObjectA{" +
                "args=" + Arrays.toString(args) +
                '}';
    }
}
