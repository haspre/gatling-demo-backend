create resource
```
    curl -X POST "localhost:8080/resources"
```

delete resource
```
    curl "localhost:8080/resources/1990082281904238954"
```

configure constant delay via JMX
```
    MBean 'com.unic:name=DelayConfiguration' with attribute 'delayInSeconds'
```