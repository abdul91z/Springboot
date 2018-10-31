package nl.han.dea.abdul.springboottwo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id @GeneratedValue
    private int id;
    private String user;
    private String pass;



    public UserEntity(int id, String user, String pass){
        this.id = id;
        this.user = user;
        this.pass = pass;

    }

    public UserEntity(){

    }

    public String getUser() {
        return user;
    }

    public String getPassword(){
        return pass;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.pass = password;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}