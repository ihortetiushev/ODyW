start graphql service
start client service
goto http://localhost:8081/swagger-ui/index.html

post 
<pre>
query bookDetails {
    bookById(id: "book-1") {
        id
        name
        pageCount
        author {
            id
            firstName
            lastName
        }
    }
}
</pre>

P.S book-1, book-2, book-3 is the existing data on 'server'