package ua.skillsup.betandlose.model.enumeration;

import java.util.Arrays;
import java.util.List;

public enum Event {
    WIN1, DRAW, WIN2;

    public static List<String> getAllKinds() {
        return Arrays.asList(WIN1.name(), DRAW.name(), WIN2.name());
    }

    }
