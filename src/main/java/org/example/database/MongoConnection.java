package org.example.database;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MongoConnection {

    private String url = "172.19.16.1:27017";
    private MongoClient mongoClient = null;
    private MongoDatabase mongoDatabase = null;
    private MongoCollection<Document> mongoCollection;

    public void createConnection() {
        try {
            mongoClient = new MongoClient(url);
            mongoDatabase = mongoClient.getDatabase("admin");
            mongoCollection = mongoDatabase.getCollection("colecciones_arep");
        } catch (MongoException ex) {
            System.out.println(ex);
        }
    }

    public List<String> getDocumentsColecction() {
        ArrayList<String> data = new ArrayList<>();
        for (Document d: mongoCollection.find()) {
            System.out.println(d.toJson());
            data.add(d.toJson());
        }
        return data.subList(Math.max(data.size() - 10, 0), data.size());
    }

    public void addItem(String text) {
        Document myDocument = new Document();
        myDocument.put("text", text);
        myDocument.put("date", new Date().toString());
        mongoCollection.insertOne(myDocument);
    }

    public void closeConnection() {
        this.mongoClient.close();
    }
}
