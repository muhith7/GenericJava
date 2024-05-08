/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package product;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author abdul
 */
public class Koneksi {
    public static MongoDatabase sambungDB(){
        try {
            MongoClient client = MongoClients.create();
            MongoDatabase database =  client.getDatabase("dd");
            System.out.println("Koneksi gacorr bosss!!!!");
            return database;
        } catch (Exception e) {
            System.out.println("Turuuuu dekkk: " + e.getMessage());
        }
        return null;
    }
}
