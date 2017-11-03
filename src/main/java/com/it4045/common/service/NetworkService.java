package com.it4045.common.service;

import com.it4045.common.dto.Book;
import com.it4045.common.networking.NetworkHttp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NetworkService {

    private static String url = "http://openlibrary.org/search.json?q=";

    /**
     * Gets book data from http://openlibrary.org
     *
     * @return a list of Book
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

        for (int i = 0; i < jsonBooks.length(); i++) {
            //get Book properties from json
            //Catch JSONException because not all results have subject or publishers
            try {
                title = jsonBooks.getJSONObject(i).getString("title");
            } catch (JSONException e) {
                title = "";
            }
            try {
                author = jsonBooks.getJSONObject(i).getJSONArray("author_name").get(0).toString();
            } catch (JSONException e) {
                author = "";
            }
            try {
                subject = jsonBooks.getJSONObject(i).getJSONArray("subject").get(0).toString();
            } catch (JSONException e) {
                subject = "";
            }
            try {
                publisher = jsonBooks.getJSONObject(i).getJSONArray("publisher").get(0).toString();
            } catch (JSONException e) {
                publisher = "";
            }

            //populate new Book object
            currentBook.setTitle(title);
            currentBook.setAuthor(author);
            currentBook.setSubject(subject);
            currentBook.setPublisher(publisher);

            //Add it to the ArrayList
            catalogBooks.add(currentBook);
        }

        return catalogBooks;
    }
}
