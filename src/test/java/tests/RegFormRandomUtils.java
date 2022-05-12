package tests;

import java.util.Random;

public class RegFormRandomUtils {
    public static String getRandomDay(int min, int max) {
        Random day = new Random();

        return String.valueOf(day.nextInt((max - min) + 1) + min);
    }

    public static String getRandomYear(int min, int max) {
        Random year = new Random();

        return String.valueOf(year.nextInt((max - min) + 1) + min);
    }

    public static String getRandomMonth() {
        int r = (int) (Math.random()*12);
        return new String [] {"January","February","March", "April", "May",
                "June","July","August","September", "October","November", "December"}[r];
    }


    public static String getPhoneNumber(int length) {
        String number = "1234567890";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * number.length());
            result.append(number.charAt(index));
        }
        return number;
    }

    public static String getGender(){
        int r = (int) (Math.random()*3);
        return new String [] {"Male","Female","Other"}[r];
    }

    public static String getHobby(){
        int r = (int) (Math.random()*3);
        return new String [] {"Reading","Sports","Music"}[r];
    }
}