# ActiveMQ  

## I Docker  

Kjøre enkel container for testing

```sh
docker pull webcenter/activemq
docker run --name='activemq' -it --rm -P webcenter/activemq:latest
```

Denne kommandoen for applikasjonene app-a og app-b  
```shell
docker run -p 61616:61616 -p 8161:8161 -d rmohr/activemq
```
[8161 er webkonsoll](http://localhost:8161/)
61616 er porten den kommuniserer over med applikasjonen.


## I docker-compose
```sh
wget https://raw.githubusercontent.com/disaster37/activemq/master/docker-compose.yml
docker-compose up
```  


