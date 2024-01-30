package project.server.utility.client;

import org.springframework.lang.NonNull;

public class PasswordUtils {

    public static int getPasswordHash(@NonNull String password) {
        int hash = 0;

        for (int i = 0; i < password.length(); i++) {
            hash = hash * 256;
            hash = hash + password.charAt(i);
        }

        return hash;
    }
}
