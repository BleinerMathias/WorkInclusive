package br.edu.ifsp.domain.usecases.utils;

import java.time.LocalDate;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Validator<T> {
    public abstract Notification validate(T type);

    private static boolean applyPattern(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if(matcher.find())
            return true;
        else
            return false;
    }


    public static boolean isEmail(String email){
        String pattern = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        return applyPattern(pattern, email);
    }
    public static boolean isCNPJOrCPF(String input){
        String pattern = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})$";
        return applyPattern(pattern, input);
    }
    public static boolean isPhone(String input) {
        String pattern = "^(\\(?\\d{2}\\)?\\s?)?(\\d{4,5}(\\-|\\s)?\\d{4})\\s?(\\(\\d{4}\\))?$";
        return applyPattern(pattern, input);
    }

    public static boolean isPostCode(String input){
        String pattern = "^\\d{5}-\\d{3}$";
        return applyPattern(pattern, input);
    }

    public static boolean nullOrEmpty(String string){
        return string == null || string.isEmpty();
    }

    public static boolean nullOrEmpty(Collection collection){
        return collection == null || collection.isEmpty();
    }

    public static boolean validateDateAfterToday(LocalDate date){ return date == null || date.isAfter(LocalDate.now()); }
}
