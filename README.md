# skeleton

#### address
- routing service: 106.55.68.112
- rec service: 106.55.66.37
#### how to generate a blank project
- in Intillij, add sub module through SpringBoot
- https://start.spring.io/  

####  how to build and run a docker of service
- enter the root folder of skeleton
- build and push docker images
```
# routing service
docker image build -t ai-docker-registry.cn-shenzhen.cr.aliyuncs.com/skeleton/routing-service:v1 . -f routing-service/Dockerfile
docker push ai-docker-registry.cn-shenzhen.cr.aliyuncs.com/skeleton/routing-service:v1 

# rec service v1
docker image build -t ai-docker-registry.cn-shenzhen.cr.aliyuncs.com/skeleton/rec-service:v1 . -f rec-service/Dockerfile
docker push ai-docker-registry.cn-shenzhen.cr.aliyuncs.com/skeleton/rec-service:v1 

# rec service v2
docker image build -t ai-docker-registry.cn-shenzhen.cr.aliyuncs.com/skeleton/rec-service:v2 . -f rec-service/Dockerfile
docker push ai-docker-registry.cn-shenzhen.cr.aliyuncs.com/skeleton/rec-service:v2
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
``
# kubectl create secret docker-registry skeleton-docker-registry --docker-server='ccr.ccs.tencentyun.com' --docker-username='your qq number' --docker-password='your password' --docker-email='skeleton@qq.com' --namespace=skeleton
```

