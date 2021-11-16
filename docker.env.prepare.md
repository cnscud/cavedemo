#准备本地Docker环境 -- 如果使用maven plugin 的话

## 安装Docker 引擎
    mac下是docker desktop.

    设置国内docker仓库

    "registry-mirrors": [
    "https://hub-mirror.c.163.com",
    "https://mirror.baidubce.com"
    ]

## 打通容器和宿主机网络 (Mac系统, 如果docker容器需要访问内网资源)

    参见 https://github.com/wenjunxiao/mac-docker-connector


## 安装私服 (可选)
为了方便, 本机安装一个私服, 也可以使用Nexus安装, 或者使用阿里云等.

### opt下创建文件夹
[root@yourhome ~]$ cd /opt && mkdir registry && mkdir /opt/registry/auth

### 创建账号密码
[root@k8s-master ~]$ docker run --entrypoint htpasswd registry:2.4.1 -Bbn cnscud 123456  >> /opt/data/registry-auth/htpasswd

### 运行
[root@k8s-master ~]$
docker run -d -p 5000:5000 --restart=always \
--name registry \
-v /opt/data/registry-auth/:/auth/ \
-e "REGISTRY_AUTH=htpasswd" \
-e "REGISTRY_AUTH_HTPASSWD_REALM=Registry Realm" \
-e REGISTRY_AUTH_HTPASSWD_PATH=/auth/htpasswd \
-v /opt/registry/:/var/lib/registry/ \
registry:2.4.1


### 在 docker destop 里增加配置:

    { "insecure-registries": ["127.0.0.1:5000"]}

    重启 Docker Desktop

## 安装私服的管理界面(有很多种)

    docker run -p 8280:80 --name registry-ui \
    --link registry2:registry2 \
    -e REGISTRY_URL="http://registry2:5000" \
    -e DELETE_IMAGES="true" \
    -e REGISTRY_TITLE="Registry2" \
    -d joxit/docker-registry-ui:static


### 测试私服:
    docker pull busybox
    docker pull busybox
    docker push 127.0.0.1:5000/busybox:v1.0

### 访问: http://127.0.0.1:8280


私服安装完毕.

## 开启Mac下的2375端口

docker run --rm -d -v /var/run/docker.sock:/var/run/docker.sock -p 127.0.0.1:2375:2375 bobrik/socat TCP-LISTEN:2375,fork UNIX-CONNECT:/var/run/docker.sock
