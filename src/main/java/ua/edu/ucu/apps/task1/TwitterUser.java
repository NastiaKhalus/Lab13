package ua.edu.ucu.apps.task1;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class TwitterUser {
    private String email;
    private String country;
    private String lastActiveTime;

    public String getUserMail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public String getLastActiveTime() {
        return lastActiveTime;
    }
}
