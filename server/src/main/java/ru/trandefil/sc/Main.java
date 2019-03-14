package ru.trandefil.sc;

import java.io.InputStream;

public class Main {
    public static void main(String[] args) {

        try {
            InputStream inputStream = ClassLoader.getSystemResourceAsStream("META-INF/apache-deltaspike.properties");
            System.out.println(inputStream);
            System.out.println("sldgjs");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
