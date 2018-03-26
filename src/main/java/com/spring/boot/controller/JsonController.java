package com.spring.boot.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonController {
    @RequestMapping("/json/employee")
    public JSONObject employee() throws JSONException {
        JSONObject object = new JSONObject();
        object.put("id", 12345);
        object.put("name", "Howards");
        object.put("something", "Nothing");
        return object;
    }
}
