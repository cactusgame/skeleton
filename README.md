# skeleton

#### address
- routing service: 106.55.68.112
- rec service: 106.55.66.37
#### how to generate a blank project
- in Intillij, add sub module through SpringBoot
- https://start.spring.io/  

####  how to build and run a docker of service
- enter the root folder of skeleton
- build the `routing-service` docker, docker build context = current folder, specific the DOCKERFILE
```
docker image build -t ai-docker-registry.cn-shenzhen.cr.aliyuncs.com/skeleton/routing-service . -f routing-service/Dockerfilek
```
- run the service
```
docker run ai-docker-registry.cn-shenzhen.cr.aliyuncs.com/skeleton/routing-service
```
- access the service
```
curl http://localhost:8080/routing/get
```

#### how to create secret for docker pull
```
# kubectl create secret docker-registry skeleton-docker-registry --docker-server='ccr.ccs.tencentyun.com' --docker-username='your qq number' --docker-password='your password' --docker-email='skeleton@qq.com' --namespace=skeleton
```

#### how to pull or push docker form Ali cloud
```
docker image build -t ai-docker-registry.cn-shenzhen.cr.aliyuncs.com/skeleton/routing-service . -f routing-service/Dockerfilek
docker push ai-docker-registry.cn-shenzhen.cr.aliyuncs.com/skeleton/routing-service:latest 
```