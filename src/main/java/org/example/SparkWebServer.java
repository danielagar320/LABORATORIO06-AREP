package org.example;

import org.example.database.MongoConnection;

import java.util.List;

import static spark.Spark.*;

public class SparkWebServer {

    public static void main(String... args){

        MongoConnection mongoConnection = new MongoConnection();
        mongoConnection.createConnection();
        mongoConnection.closeConnection();
        port(getPort());

        get("/service", (req,res) -> {
            mongoConnection.createConnection();
            List<String> colecctions = mongoConnection.getDocumentsColecction();
            mongoConnection.closeConnection();
            return colecctions;
        } );

        post("/service", (req,res) -> {
            mongoConnection.createConnection();
            if(req.body()!=null){
                mongoConnection.addItem(req.body());
            }
            List<String> colecctions = mongoConnection.getDocumentsColecction();
            mongoConnection.closeConnection();
            return colecctions;
        });

    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}
