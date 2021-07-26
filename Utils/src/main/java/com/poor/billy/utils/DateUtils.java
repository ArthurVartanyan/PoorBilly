package com.poor.billy.utils;

import java.time.LocalDate;

public final class DateUtils {

    public static LocalDate firstDayOfCurrentMonth() {
        return LocalDate.now().withDayOfMonth(1);
    }

    public static LocalDate lastDayOfCurrentMonth() {
        return LocalDate.now().withDayOfMonth(LocalDate.now().lengthOfMonth());
    }
}