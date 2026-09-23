package com.napier.sem;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class App
{
    public static void main(String[] args)
    {
        // Connect to MongoDB using standard connection string
        try (MongoClient mongoClient = MongoClients.create("mongodb://mongo-db-target:27017")) {

            // Get database and collection
            MongoDatabase database = mongoClient.getDatabase("mydb");
            MongoCollection<Document> collection = database.getCollection("test");

            // Create document
            Document doc = new Document("name", "Kevin Sim")
                    .append("class", "DevOps")
                    .append("year", "2024")
                    .append("result", new Document("CW", 95).append("EX", 85));

            // Insert document
            collection.insertOne(doc);

            // Retrieve and print document
            Document myDoc = collection.find().first();
            if (myDoc != null) {
                System.out.println(myDoc.toJson());
            }
        }
    }
}