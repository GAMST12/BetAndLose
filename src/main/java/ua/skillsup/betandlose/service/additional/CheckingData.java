package ua.skillsup.betandlose.service.additional;

import java.util.Arrays;

public class CheckingData {
    public static boolean checkAnyStringsIsEmpty(String...strings) {
        return Arrays.stream(strings).anyMatch(s -> s == null || s.isEmpty());
    }

    public static boolean checkAnyNumbersIsEmpty(Number...numbers) {
        return Arrays.stream(numbers).anyMatch(s -> s == null || s.doubleValue() == 0.0);
    }

}
