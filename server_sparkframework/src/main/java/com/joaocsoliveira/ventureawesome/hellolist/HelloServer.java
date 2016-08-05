package com.joaocsoliveira.ventureawesome.hellolist;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

/**
 * Created by joaocsoliveira on 04/08/16.
 */
class HelloServer {

    private Gson gson = new Gson();

    HelloServer(){

    }

    void start(){
        spark.Spark.post("/hello", this::say_hello, gson::toJson );

        spark.Spark.awaitInitialization();
    }

    void stop(){
        spark.Spark.stop();
    }

    private Hello say_hello(Request req, Response res){
        String name;
        try {
            name = gson.fromJson(req.body(), String.class);
        } catch (Exception e){
            res.status(500);
            return null;
        }

        return new Hello(name);
    }

}
