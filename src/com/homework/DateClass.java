package com.homework;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateClass {

    public static void lastWeekDate(Group group) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateTimeFormatter formatterForMonday = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, d MMMM yyyy");
        LocalDate startDateCourse = LocalDate.parse(group.getCourseStartDate(), formatter);
        LocalDate endDate = startDateCourse.plusWeeks(group.getWeeks());
        LocalDate monday = LocalDate.parse(endDate.with(WeekFields.of(
                Locale.FRANCE).dayOfWeek(), 1L).format(formatterForMonday));
        Calendar calendar = new GregorianCalendar(monday.getYear(),
                monday.getMonth().getValue() - 1,
                monday.getDayOfMonth());

        System.out.println("Начало последней недели курса - " + dateFormat.format(calendar.getTime()));
    }

    public static String starCourseDate(Group group) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate startDateCourse = LocalDate.parse(group.getCourseStartDate(), formatter);
        String result = "" + startDateCourse.getDayOfMonth()
                + startDateCourse.getMonth()
                + startDateCourse.getYear();
        return result.toLowerCase();
    }
}
