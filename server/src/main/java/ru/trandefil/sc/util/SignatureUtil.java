package ru.trandefil.sc.util;

import ru.trandefil.sc.model.Role;
import ru.trandefil.sc.model.Session;
import ru.trandefil.sc.exception.SecurityAuthentificationException;

import java.io.InputStream;
import java.util.Properties;
import java.util.stream.IntStream;

public class SignatureUtil {

    private static String generateSignature(final String allFields) {
        try (InputStream inputStream = ClassLoader.getSystemResourceAsStream("prop.properties")) {
            final Properties properties = new Properties();
            properties.load(inputStream);
            final String salt = properties.getProperty("salt");
            final int cycle = Integer.parseInt(properties.getProperty("cycle"));
            final String superUniqie = getMultiHash(salt, cycle, allFields);
            return superUniqie;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getMultiHash(final String salt, final int cycle, final String allFields) {
        final String solted = salt + allFields + salt;
        final String[] str = new String[1];
        str[0] = solted;
        IntStream.range(0, cycle).forEach((i) -> str[0] = HashUtil.hashPassword(str[0]));
        return str[0];
    }

    public static String createSignature(final String id, final String userId, final long timeStamp, final Role role) {
        final String sessionFields = id + userId + timeStamp + role.name();
        return generateSignature(sessionFields);
    }

    public static boolean checkCorrectSession(Session session) {
        if (session == null) {
            System.out.println("session is null");
            throw new SecurityAuthentificationException("bad security.");
        }
        if (session.getId() == null) {
            throw new SecurityAuthentificationException("bad security.");
        }
        if (session.getRole() == null) {
            throw new SecurityAuthentificationException("bad security.");
        }
        if (session.getUserId() == null) {
            throw new SecurityAuthentificationException("bad security.");
        }
        if (session.getTimestamp() == 0) {
            throw new SecurityAuthentificationException("bad security.");
        }
        if (session.getSignature() == null) {
            throw new SecurityAuthentificationException("bad security.");
        }
        return session.getSignature().equals(createSignature(session.getId(),
                session.getUserId(), session.getTimestamp(), session.getRole()));
    }

}
