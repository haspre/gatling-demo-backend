create unicorn
```
    curl -X POST "localhost:8080/resources"
```

get unicorn
```
    curl "localhost:8080/resources/1990082281904238954"
```

filter unicorns
```
url -H "Accept: application/json" -H "Content-Type: application/json" "http://localhost:8080/unicorns?maxAge=100&gender=male&maxResults=2"
```

configure constant delay via JMX
```
    MBean 'com.unic:name=DelayConfiguration' with attribute 'delayInSeconds'
```