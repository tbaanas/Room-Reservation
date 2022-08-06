package com.example.RecruitmentTask;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Component
public class Config {

    public static  LocalDate getDate(String stringDate) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale( Locale.US );

        try {
            return LocalDate.parse(stringDate, formatter);
        } catch (Exception e) {
            System.out.println("Parse error");
            System.out.println(e.getMessage());
        }
        return null;
    }
}
