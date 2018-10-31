package nl.han.dea.abdul.springboottwo.controllers;

import net.moznion.random.string.RandomStringGenerator;
import nl.han.dea.abdul.springboottwo.models.TokenEntity;
import nl.han.dea.abdul.springboottwo.services.LoginService;
import nl.han.dea.abdul.springboottwo.models.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    private RandomStringGenerator generator = new RandomStringGenerator();

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity  login(@RequestBody UserEntity userEntity) {

        String userName = userEntity.getUser();
        String password = userEntity.getPassword();
       String token = loginService.generateNewToken();

        if (loginService.checkUsernamePassword(userName, password)){


            loginService.setNewToken(userName, token);

            return ResponseEntity.ok(new TokenEntity(userName,token));


        }
        return ResponseEntity.status(401).build();
    }
}
