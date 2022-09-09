package Day5Lesson.com.example.Day5Lesson.models;

import java.io.StringReader;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Registration {

    private String name;
    private String email;
    private String id; //optional

    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setName(String name) {
        this.name = name;
    }

    //Takes in a json String and returns a Registration object 
    public static Registration create(String json){
        JsonReader reader = Json.createReader(new StringReader(json));
        JsonObject data = reader.readObject();

        final Registration reg = new Registration();
        reg.setName(data.getString("name"));
        reg.setEmail(data.getString("email"));
        if(data.containsKey("id")){
            reg.setId(data.getString("id"));
        }


        return reg;
    }

    public JsonObject toJson(){
        return Json.createObjectBuilder()
            .add(id,"id")
            .add(name,"name")
            .add(email,"email")
            .build();
    }
    
}
