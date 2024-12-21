http://localhost:8080/graphiql?path=/graphql to try it out
query

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