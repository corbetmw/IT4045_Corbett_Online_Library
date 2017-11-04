package com.it4045.common.beans;

import com.it4045.common.dto.Book;
import com.it4045.common.service.NetworkService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "catalog", eager = true)
@ViewScoped
public class CatalogBean implements Serializable {
    NetworkService networkService = new NetworkService();

    private List<Book> catalogBooks;
    private String searchString = "The Lord of The Rings";

    @PostConstruct
    public void init(){
        catalogBooks = networkService.getBooksFromCatalog(searchString);
    }

    public void search(){
        catalogBooks = networkService.getBooksFromCatalog(searchString);
    }

    public List<Book> getCatalogBooks() {
        return catalogBooks;
    }

    public void setCatalogBooks(List<Book> catalogBooks) {
        this.catalogBooks = catalogBooks;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }
}
