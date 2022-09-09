package Day5Lesson.com.example.Day5Lesson.models;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Response {
    
    private int respCode=0;
    private String message;
    private String data="{}";

    public int getRespCode() {
        return respCode;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public void setRespCode(int respCode) {
        this.respCode = respCode;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public JsonObject toJson(){
        return Json.createObjectBuilder()
            .add("message", message)
            .add("code",respCode)
            .build();
    }
    
}
