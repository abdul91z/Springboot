package nl.han.dea.abdul.springboottwo.services;

import nl.han.dea.abdul.springboottwo.datasource.LoginRepository;
import nl.han.dea.abdul.springboottwo.models.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;


        public boolean checkUsernamePassword(String userName, String password){
            UserEntity user = loginRepository.findUserByUserName(userName);

            return user.getPassword().equals(password);

    }

    public void setNewToken(String userName, String token) {
        loginRepository.setNewToken(userName,token);
    }

    public String generateNewToken(){

        Random rand = new Random();

        int  n = rand.nextInt(9);
        int  n1 = rand.nextInt(9);
        int  n2 = rand.nextInt(9);
        int  n3 = rand.nextInt(9);
        int  n4 = rand.nextInt(9);
        int  n5 = rand.nextInt(9);
        int  n6 = rand.nextInt(9);
        int  n7 = rand.nextInt(9);
        int  n8 = rand.nextInt(9);
        int  n9 = rand.nextInt(9);
        int  n10 = rand.nextInt(9);
        int  n11 = rand.nextInt(9);

        String token = "" + n+n1+n2+n3+"-"+n4+n5+n6+n7+"-"+n8+n9+n10+n11;
        return token;
    }
}
