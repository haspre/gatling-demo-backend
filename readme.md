start service
```
    mvn clean spring-boot:run
```

create unicorn
```
    curl -H "Accept: application/json" -H "Content-Type: application/json" -X POST "localhost:8080/unicorns" -d '{"firstName":"rainer","lastName":"steinegger","age":35,"gender":"male"}'
```

get unicorn
```
    curl -H "Accept: application/json" -H "Content-Type: application/json" "http://localhost:8080/unicorns/6"
```

filter unicorns
```
    url -H "Accept: application/json" -H "Content-Type: application/json" "http://localhost:8080/unicorns?maxAge=100&gender=male&maxResults=2"
```