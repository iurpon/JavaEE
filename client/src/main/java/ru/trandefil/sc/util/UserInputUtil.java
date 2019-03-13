package ru.trandefil.sc.util;

import ru.trandefil.sc.service.TerminalService;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Date;

public class UserInputUtil {

    public static Date getDate(final TerminalService scanner, final String str) {
        boolean correctDate = false;
        Date date = null;
        while (!correctDate) {
            System.out.format("Enter the %s date with format dd-MM-yyyy : ", str);
            final String dateStringInput = scanner.nextLine();

            if (dateStringInput.isEmpty()) {
                return null;
            }
            try {
                date = DateFormatterUtil.parse(dateStringInput);
                correctDate = true;
            } catch (ParseException e) {
                System.out.println("Incorrect date format");
            }

        }
        return date;
    }

    public static String getNotNullString(final TerminalService scanner, final String incomingString) {
        System.out.format("%s : ", incomingString);
        boolean notEmptyInput = false;
        String userInput = null;
        while (!notEmptyInput) {
            userInput = scanner.nextLine();
            if ("return".equals(userInput)) {
                return null;
            }
            if (userInput.isEmpty()) {
                System.out.println("empty string doesn't valid");
                continue;
            }
            notEmptyInput = true;
        }
        return userInput;
    }

    public static String hashPassword(final String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(password.getBytes());
        final byte[] digest = md.digest();
        final String myHash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
        return myHash;
    }

}
