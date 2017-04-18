package ua.skillsup.betandlose.model.enumeration;

import java.util.Arrays;
import java.util.List;

public enum Sex {
    Man, Woman;

    public static List<String> getAllSex() {
        return Arrays.asList(Man.name(), Woman.name());
    }

}
