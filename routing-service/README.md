# routing-service

####  how to build and run a docker of service
As `routing-service` a example
- enter the folder `routing-service`
- build the docker
```
docker image build -t ccr.ccs.tencentyun.com/skeleton/routing-service-docker .
docker push ccr.ccs.tencentyun.com/skeleton/routing-service-docker:latest
curl http://localhost:8080/
```
