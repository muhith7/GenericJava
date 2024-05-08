/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package product;
import com.mongodb.client.*;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;


/**
 *
 * @author abdul
 */
public class CRUD {
     // Method to connect to MongoDB
    public static MongoClient connectToMongoDB(String connectionString) {
        return MongoClients.create(connectionString);
    }

    // Method to insert a document into a collection
    public static void insertDocument(MongoCollection<Document> collection, Document document) {
        collection.insertOne(document);
        System.out.println("Document inserted successfully.");
    }

    // Method to retrieve all documents from a collection
    public static List<Document> getAllDocuments(MongoCollection<Document> collection) {
    List<Document> documents = new ArrayList<>();
    MongoCursor<Document> cursor = collection.find().iterator();
    try {
        while (cursor.hasNext()) {
            documents.add(cursor.next());
        }
    } finally {
        cursor.close();
    }
    return documents;
}


    // Method to update a document in a collection
    public static void updateDocument(MongoCollection<Document> collection, Document filter, Document update) {
        collection.updateOne(filter, update);
        System.out.println("Document updated successfully.");
    }

    // Method to delete a document from a collection
    public static void deleteDocument(MongoCollection<Document> collection, Document filter) {
        collection.deleteOne(filter);
        System.out.println("Document deleted successfully.");
    }

    public static void main(String[] args) {
        // Connection string to MongoDB (replace with your connection string)
        String connectionString = "mongodb://localhost:27017";

        // Connect to MongoDB
        MongoClient mongoClient = connectToMongoDB(connectionString);

        // Access a database and a collection
        MongoDatabase database = mongoClient.getDatabase("product");
        MongoCollection<Document> collection = database.getCollection("produk");

        // Insert document
        Document document = new Document("name", "Muhith")
                                    .append("age", 40)
                                    .append("city", "Adiwerna");
        insertDocument(collection, document);

        // Retrieve all documents
        getAllDocuments(collection);

        // Update document
        Document filter = new Document("name", "John");
        Document update = new Document("$set", new Document("city", "Los Angeles"));
        updateDocument(collection, filter, update);

        // Retrieve all documents after update
        getAllDocuments(collection);

        // Delete document
        deleteDocument(collection, filter);

        // Retrieve all documents after delete
        getAllDocuments(collection);

        // Close MongoDB connection
        mongoClient.close();
    }
    
}
