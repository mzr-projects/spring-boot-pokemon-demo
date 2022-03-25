# spring-boot-pokemon-demo
Spring boot pokemon demo

This project fetches any number of pokemeons user wants and stores it into the In-Memory Database H2

In the following url 100 is the number of pokemons are going to be fetched and stored into the database
Post Request : localhost:8080/pokemon/store/100 

In the following url we get all the stored pokemons from the database and show them to the user	
Get Request : localhost:8080/pokemon/all

Also a swagger hase been provided that these two endpoints can be executed in the documnet page
http://localhost:8080/swagger-ui.html

Here I added a new approach to the project to make it full Reactive to use it u must have a MongoDb
installed in your machine and with the following settings :

host -> 127.0.0.1
port -> 27017
atabase -> pokoemon_docs and a created document named "pokemons" 

And thats basically it !
