# spring-boot-pokemon-demo
Spring boot pokemon demo

This project fetch any number of pokemeons user wants and stores it into a In-Memory Database H2

In the following url 100 is the number of pokemons are going to be fetched and stored into the database
Post Request : localhost:8080/pokemon/store/100 

In the following url we get all the stored pokemons from the databse and show them to the user	
Get Request : localhost:8080/pokemon/all

Also a swagger hase been provided that these two endpoits can be executed in one documnet page
http://localhost:8080/swagger-ui.html
