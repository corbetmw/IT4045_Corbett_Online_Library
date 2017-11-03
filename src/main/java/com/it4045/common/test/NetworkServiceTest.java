package com.it4045.common.test;

import com.it4045.common.service.NetworkService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
        networkService.getBooksFromCatalog("The lord of the rings");
    }
}
