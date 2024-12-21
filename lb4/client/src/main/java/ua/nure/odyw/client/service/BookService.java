package ua.nure.odyw.client.service;

import org.springframework.graphql.client.HttpSyncGraphQlClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import ua.nure.odyw.client.model.Book;
@Service
public class BookService {
    private RestClient restClient = RestClient.create("http://localhost:8080/graphql");
    private HttpSyncGraphQlClient graphQlClient = HttpSyncGraphQlClient.create(restClient);
    public Book getBook(String query) {
        return graphQlClient.document(query)
                .retrieveSync("bookById").toEntity(Book.class);
    }
}
