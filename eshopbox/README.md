# Spring Boot   Project
REST APIs implemented using Spring Boot  Maven Project

## How to Run

* Build the project by running `mvn clean package`
* Once successfully built, hit the below end points 

## REST APIs Endpoints
## Get Top 3 Heros  
```
GET /api/maxwinheroes/{accountId}
"account_id" as path param  
Content-Type: application/json
Accept: application/json

Ex:/api/maxwinheroes/211511642

```


## Retrieve Max Heros Info 
* for this end point first we have to give the request on "/api/maxwinheroes/{accountId}" end point then will get the Hero's Info 

```
GET /api/maxwinheroesinfo
Accept: application/json
Content-Type: application/json

Ex:/api/maxwinheroesinfo
```
