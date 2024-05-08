/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package product;

import com.mongodb.client.MongoDatabase;

/**
 *
 * @author abdul
 */
public class TestDB {
    public static void main(String[] args) {
        try {
            MongoDatabase database = Koneksi.sambungDB();
        } catch (Exception e) {
        }
    }
}
