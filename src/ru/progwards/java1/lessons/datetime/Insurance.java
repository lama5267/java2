package ru.progwards.java1.lessons.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Insurance {
    public Insurance(ZonedDateTime start) {
        this.start = start;
    }

    public static enum FormatStyle {SHORT, LONG, FULL} //- стиль формата даты-времени

    private ZonedDateTime start;// - дата-время начала действия страховки.
    private Duration duration;// - продолжительность действия.

    public Insurance(String strStart, FormatStyle style) {//- установить дату-время начала действия страховки
        if (style == FormatStyle.SHORT) {
            LocalDate ld = LocalDate.from(DateTimeFormatter.ISO_LOCAL_DATE.parse(strStart));
            start = ld.atStartOfDay(ZoneId.systemDefault());
        } else if (style == FormatStyle.LONG) {
            LocalDateTime ldt = LocalDateTime.from(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse(strStart));
            start = ldt.atZone(ZoneId.systemDefault());
        } else if (style == FormatStyle.FULL) {
            start = ZonedDateTime.from(DateTimeFormatter.ISO_ZONED_DATE_TIME.parse(strStart));
        }
    }

    public void setDuration(Duration duration) {//- установить продолжительность действия страховки.
        this.duration = duration;
    }

    public void setDuration(ZonedDateTime expiration)
    //- установить продолжительность действия страховки, задав дату-время окончания.
    {
        setDuration(Duration.between(start, expiration));
    }

    public void setDuration(int months, int days, int hours)
    //- установить продолжительность действия страховки,
    // задав целыми числами количество месяцев, дней и часов.
    {
        setDuration(start.plusMonths(months).plusDays(days).plusHours(hours));
    }
    public void setDuration(String strDuration, FormatStyle style){
     if (style == FormatStyle.SHORT)
    duration = Duration.ofMillis(Long.parseLong(strDuration));
        else if (style == FormatStyle.LONG) {
        LocalDateTime ld1 = LocalDateTime.parse(strDuration, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        ZonedDateTime zdt1 = start.plusYears(ld1.getYear()).
                plusMonths(ld1.getMonthValue()).
                plusDays(ld1.getDayOfMonth()).
                plusHours(ld1.getHour()).
                plusMinutes(ld1.getMinute()).
                plusSeconds(ld1.getSecond());
        duration = Duration.between(start, zdt1);

    } else
    duration = Duration.parse(strDuration);//преобразовываем из строки
}

    public boolean checkValid(ZonedDateTime dateTime) {
        if (duration == null) {
            if (start.isBefore(ZonedDateTime.now())) return true;//start меньше
            else return false;
        }

        ZonedDateTime end = start.plusNanos(duration.toNanos());

        if (dateTime.isAfter(start) && dateTime.isBefore(end)) return true; //больше start и меньше end
        return false;
    }

    public String toString() {
        String valid = checkValid(ZonedDateTime.now()) ? " is valid" : " is not valid";
        return "Insurance issued on " + start + valid;
    }


    public static void main(String[] args) {
        Insurance inS = new Insurance("2020-07-30", FormatStyle.SHORT);
        Insurance inL = new Insurance("2020-07-30T10:15:30", FormatStyle.LONG);
        Insurance inF = new Insurance("2020-07-30T10:15:30+01:00[Europe/Paris]", FormatStyle.FULL);
        System.out.println(inL.toString());
        System.out.println(inL.toString());
        System.out.println(inF.toString());

        inS.setDuration("PT100H", FormatStyle.FULL);
        inL.setDuration("0000-10-03T10:15:30", FormatStyle.LONG);
        inF.setDuration("12960000000", FormatStyle.SHORT);
        System.out.println(inF.duration.toString());
        System.out.println(inF.start.toString());

        System.out.println(inS.toString());
        System.out.println(inL.toString());
        System.out.println(inF.toString());

    }
}