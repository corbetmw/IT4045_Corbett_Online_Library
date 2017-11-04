package com.it4045.common.test;

import com.it4045.common.dto.Book;
import com.it4045.common.service.NetworkService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class NetworkServiceTest {

    NetworkService networkService;
    @Before
    public void setUp() throws Exception {
        networkService= new NetworkService();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSearchCatalog() throws Exception {
        List<Book> testBookList = networkService.getBooksFromCatalog("the lord of the");

        for(int i=0; i < testBookList.size(); i++){
            System.out.print(testBookList.get(i).getTitle() + '\n');
        }
    }
}
