
mvn clean package -Dmaven.test.skip=true

# docker copy and push
docker image build -t ai-docker-registry.cn-shenzhen.cr.aliyuncs.com/skeleton/routing-service:v1 . -f routing-service/Dockerfile
docker push ai-docker-registry.cn-shenzhen.cr.aliyuncs.com/skeleton/routing-service:v1

docker image build -t ai-docker-registry.cn-shenzhen.cr.aliyuncs.com/skeleton/rec-service:v1 . -f rec-service/Dockerfile
docker push ai-docker-registry.cn-shenzhen.cr.aliyuncs.com/skeleton/rec-service:v1
