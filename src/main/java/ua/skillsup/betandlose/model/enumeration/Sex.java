package ua.skillsup.betandlose.model.enumeration;

import java.util.Arrays;
import java.util.List;

public enum Sex {
    MAN, WOMAN;

    public static List<String> getAllKinds() {
        return Arrays.asList(MAN.name(), WOMAN.name());
    }

}
