package com.it4045.common.dao;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseCredentials;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileInputStream;
import java.io.IOException;

public class Database {
    public Database(){

    }

    public static FirebaseDatabase getDatabase() throws IOException{
        FileInputStream serviceAccount = new FileInputStream("it4045-library-firebase-adminsdk-ttkks-de0c8ac61c.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
                .setDatabaseUrl("https://it4045-library.firebaseio.com/")
                .build();

        FirebaseApp app = FirebaseApp.initializeApp(options);
        FirebaseDatabase database = FirebaseDatabase.getInstance(app);

        return database;
    }
}
