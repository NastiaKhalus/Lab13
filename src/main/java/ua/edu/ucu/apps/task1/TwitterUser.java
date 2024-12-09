package ua.edu.ucu.apps.task1;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString

public class TwitterUser {
    private String email;
    private String country;
    private String lastActiveTime;

    public TwitterUser(String email, String country, String lastActiveTime) {
        this.email = email;
        this.country = country;
        this.lastActiveTime = dalastActiveTimete;
    }

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
