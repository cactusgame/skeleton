# skeleton

### how to generate a blank project
- in Intillij, add sub module through SpringBoot
- https://start.spring.io/  


###  how to build and run a docker of service
As `routing-service` a example
- enter the folder `routing-service`
- build the docker
```
docker image build -t routing-service-docker .
```
- run the service
```
docker run routing-service-docker
```
- access the service
```
curl http://localhost:8080/routing/get
```