# 分层构建, 加速增量构建

FROM adoptopenjdk/openjdk8:centos-slim as builder

WORKDIR application
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
RUN java -Djarmode=layertools -jar app.jar extract && rm app.jar

FROM adoptopenjdk/openjdk8:centos-slim

LABEL maintainer="cnscud@gmail.com"

ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ENV JAVA_OPTS="-Xms128m -Xmx256m"

WORKDIR application

COPY --from=builder /application/dependencies/ ./
COPY --from=builder /application/snapshot-dependencies/ ./
COPY --from=builder /application/spring-boot-loader/ ./
COPY --from=builder /application/application/ ./

EXPOSE 9001

# move to docker-compose or k8s configuration
## default zookeeper, or you can configure in docker-compose
# ENV ZK_HOSTS cavedemo-zookeeper:2181


ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS org.springframework.boot.loader.JarLauncher"]
