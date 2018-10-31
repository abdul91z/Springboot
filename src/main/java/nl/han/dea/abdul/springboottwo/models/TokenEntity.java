package nl.han.dea.abdul.springboottwo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class TokenEntity {

    @Id
    @GeneratedValue
    private String user;
    private String token;

    public TokenEntity(String user, String token) {
        this.user = user;
        this.token = token;
    }

    public TokenEntity() {
    }

    public String getUser() {
        return user;
    }

    public String getToken() {
        return token;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
