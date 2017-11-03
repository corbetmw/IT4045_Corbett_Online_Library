package com.it4045.common.service;

import com.it4045.common.dto.Book;
import com.it4045.common.networking.NetworkHttp;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NetworkService {

    private static String url = "http://openlibrary.org/search.json?q=";

    /**
     * Gets exchange rates from http://openlibrary.org
     * @return
     */
    public List<Book> getBooksFromCatalog(String searchString) {
        //Instantiate our book list
        List<Book> catalogBooks = new ArrayList<Book>();
        Book currentBook = new Book();
        String title;
        String author;
        String subject;
        String publisher;
        //Parse search string to add pluses
        url = url + searchString.replace(" ", "+");
        // Create our NetworkHttp
        NetworkHttp request = new NetworkHttp();
        // Send our GET request to get our data
        String response = request.sendGetRequest(url);

        JSONObject jsonObject = new JSONObject(response);
        JSONArray jsonBooks = jsonObject.getJSONArray("docs");

        for(int i=0; i< jsonBooks.length(); i++){
             //get Book properties from json
             title = jsonBooks.getJSONObject(i).getString("title");
             author = jsonBooks.getJSONObject(i).getJSONArray("author_name").get(0).toString();
             subject = jsonBooks.getJSONObject(i).getJSONArray("subject").get(0).toString();
             publisher = jsonBooks.getJSONObject(i).getJSONArray("publisher").get(0).toString();

            //populate new Book object
            currentBook.setTitle(title);
            currentBook.setAuthor(author);
            currentBook.setSubject(subject);
            currentBook.setPublisher(publisher);

        }

        return catalogBooks;
        //Not using GSON for the time seems like overkill
//        // Parse Json
//        Gson gson = new Gson();
//        JsonObject jsonObject = gson.fromJson(response, JsonObject.class);
//        JsonObject books = jsonObject.getAsJsonObject("books");
//
//        // Iterate over all rates and add them to a list used to populate the UI
//        List rateList = new ArrayList();
//        for (Map.Entry<String, JsonElement> rate : rates.entrySet()) {
//            rateList.add(rate);
//        }
//        return rateList;

    }
}
