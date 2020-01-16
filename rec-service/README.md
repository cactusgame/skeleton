# rec-service

####  how to build and run a docker of service
As `rec-service` a example
- enter the folder `rec-service`
- build the docker
```
docker image build -t ccr.ccs.tencentyun.com/skeleton/rec-service-docker .
docker push ccr.ccs.tencentyun.com/skeleton/rec-service-docker:latest
curl http://localhost:8080/
```
