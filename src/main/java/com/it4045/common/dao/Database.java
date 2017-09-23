package com.it4045.common.dao;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseCredentials;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Database{


    public Database()throws IOException{

    }

    private static FirebaseApp app =  null;

    public static FirebaseDatabase getDatabase() throws IOException{

        if(app == null){
            initializeFirebaseApp();
        }

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        return database;
    }

    private static void initializeFirebaseApp() throws IOException{
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();

        InputStream serviceAccount = classloader.getResourceAsStream("it4045-library-firebase-adminsdk-ttkks-de0c8ac61c.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
                .setDatabaseUrl("https://it4045-library.firebaseio.com/")
                .build();
        app = FirebaseApp.initializeApp(options);
    }
}
