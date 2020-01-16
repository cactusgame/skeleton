# skeleton

#### how to generate a blank project
- in Intillij, add sub module through SpringBoot
- https://start.spring.io/  

####  how to build and run a docker of service
As `routing-service` a example
- enter the folder `routing-service`
- build the docker
```
docker image build -t ccr.ccs.tencentyun.com/skeleton/routing-service-docker .
```
- run the service
```
docker run ccr.ccs.tencentyun.com/skeleton/routing-service-docker
```
- access the service
```
curl http://localhost:8080/routing/get
```

#### how to create secret for docker pull
```
# kubectl create secret docker-registry skeleton-docker-registry --docker-server='ccr.ccs.tencentyun.com' --docker-username='your qq number' --docker-password='your password' --docker-email='skeleton@qq.com' --namespace=skeleton
```

#### how to pull or push docker form tencent cloud
```
docker image build -t ccr.ccs.tencentyun.com/skeleton/routing-service-docker .
docker push ccr.ccs.tencentyun.com/skeleton/routing-service-docker:latest
```