package Day5Lesson.com.example.Day5Lesson.controllers;

import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Day5Lesson.com.example.Day5Lesson.models.Registration;
import Day5Lesson.com.example.Day5Lesson.models.Response;

// @RestController
// @RequestMapping(path="api")
// public class RegistrationRESTController {

//     @PostMapping(consumes={"application/json"},
//     produces={"application/json"}, path="/registration")
//     public String register(){

//         return "registerPage";
//     }
    
// }

@RestController
@RequestMapping(path="/api/registration", produces=MediaType.APPLICATION_JSON_VALUE)
    //It will always produces JSON but may not always consume JSON(?)
public class RegistrationRESTController{
    
    private Logger logger = Logger.getLogger(RegistrationRESTController.class.getName());

    @PostMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postRegistration(@RequestBody String payload){

        Registration reg;
        Response resp;
        //Read the payload and save the data to database
        String id = UUID.randomUUID().toString().substring(0,8);
        

        try{
            reg = Registration.create(payload);
            reg.setId(id);
        } catch(Exception ex){
            resp = new Response();
            resp.setRespCode(400);
            resp.setMessage(ex.getMessage());
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(resp.toJson().toString());
        }
        

        //Save to database

        resp = new Response();
        resp.setRespCode(201);
        resp.setMessage(id);


        return ResponseEntity.status(HttpStatus.CREATED).body(resp.toJson().toString());
    }
}

    



