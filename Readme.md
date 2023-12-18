# Library management





## Services:

### API-Gateway

Uses Consul discovery and routes http calls to its port, to the correct services.


### Book Service

i was not able to fully implement migrations for the book service, so values has to be added manually.
to http://localhost:8080/api/books

```
    {
        "isbn": "9798579327079",
        "title": "Read People Like a Book",
        "author": "Patrick King",
        "genre": "Self-help book",
        "releaseYear": 2020,
        "description": "Speed read people, decipher body language, detect lies, and understand human nature."
    }
```
```
 {
    "isbn": "9781942788294",
    "title" : "The Phoenix Project",
    "author": "Gene Kim",
    "genre" : "Novel",
    "releaseYear" : 2013,
    "description": "a business novel that chronicles Bill, an IT manager's journey to revamp his struggling company's processes, using principles of DevOps"
}
```
```
 {
    "isbn": "9780399590863",
    "title" : "The 272",
    "author": "Rachel L. Swans",
    "genre" : "Biography",
    "releaseYear" : 2023,
    "description": "The story begins with Ann Joice, a free Black woman and the matriarch of the Mahoney family."
}
```

```
 {
    "isbn": "9781324001805",
    "title" : "The Iliad",
    "author": "Homer",
    "genre" : "Epos",
    "releaseYear" : 2023,
    "description": "The greatest literary landmark of classical antiquity masterfully rendered by the most celebrated translator of our time"
}
```





The book service features 2 endpoints

- **/api/books**: this endpoints has a get and post method. You can add new books to the database.
    this was meant for admin use. but i did not get to implement any user functionality. the Get method 
    returns list of all books.


- **/api/books/{value}**: this endpoint takes a string value as a path variable, and returns a list of books
where the string value is featured in either author, genre or title fields in the database.
it will also return if just a portion of field value is the same as the string, as it uses the "contains" query for search.


### Library Catalog

this service is somewhat of a inventory service. it features one endpoint which returns a CatalogResponse that contains
the isbn of the book which was to be reserved, and a boolean value, of whether the book is available or not for loan.

Original plan was to use RabbitMQ's RabbitListener to
listen for added books in the book-service, but i met some difficulties
implementing it, and was running out of time. therefore i had to hardcode some values.


### Reservation Service

This service features one endpoint:
- **/api/reservation** : this endpoint has only a post method that takes in a list as the request body
example of request body is

Isbn values that exist in the database are
```
{
   "reservationLineItemsDtoList":[{
        "isbn": "9781942788294",
        "quantity": 1
    }]
}
```
for reserving one book and:
```
{
   "reservationLineItemsDtoList":[{
        "isbn": "9781942788294",
        "quantity": 1
    },
    {
        "isbn": "9798579327079",
        "quantity": 1
        
    }]
}
```
for two books and so on.
for all books
```
 {
   "reservationLineItemsDtoList":[{
        "isbn": "9781942788294",
        "quantity": 1
    },
    {
        "isbn": "9798579327079",
        "quantity": 1
        
    }{
        "isbn": "9781324001805",
        "quantity": 1
    },
    {
        "isbn": "9780399590863",
        "quantity": 1
        
    },]
}
```

When this endpoint gets called it uses a Webclient to do a synchronous
call to the library catalog to check if books are 
available for loan, if so the order is successful and gets stored in the database.