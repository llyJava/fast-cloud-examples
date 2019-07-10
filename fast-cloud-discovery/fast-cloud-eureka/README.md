# fast-cloud-eureka
Eureka是Netflix开发的服务发现框架，本身是一个基于REST的服务，Springcloud将其集成在子项目`spring-cloud-netflix`中，实现Springcloud的注册发现功能。
包含两个核心组件EurekaServer和EurekaClient  

即提供一个Springboot的服务作为`EurekaServer`,即本服务，其他的服务都作为`EurekaClient`注册到EurekaServer上面。
Eureka需要至少3个参与者，如下图： 
![](http://ww4.sinaimg.cn/large/006tNc79ly1g4tl36j29nj30fz07pt8k.jpg) 
如上图分为三步  
* 1、EurekaServer作为注册中心先启动之后，`服务提供者`注册到配置中心
* 2、`服务消费者`注册到配置中心
* 3、`服务消费者`调用`服务提供者`
## 一、EurekaServer配置
## 1、引入pom版本
```
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
    </dependency>
```

## 2、注解
在入口类中添加`@EnableEurekaServer`注解
```java
@Slf4j
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
        log.info(">>>>EurekaApplication started success ^-^ <<<<<");
    }
}

```
## 3、配置文件
添加如下配置
```
# 服务名
spring.application.name= eureka
#端口
server.port=7777
# 是否注册到eureka（eureka本身是不需要再注册到自己的）
eureka.client.register-with-eureka=false
# 是否从eureka获取注册信息
eureka.client.fetch-registry=false
# eureka服务器的地址（注意：地址最后面的 /eureka/ 这个是固定值）
eureka.client.serviceUrl.defaultZone=http://localhost:${server.port}/eureka/
#服务失效时间，Eureka多长时间没收到服务的renew操作，就剔除该服务，默认90秒
eureka.instance.leaseExpirationDurationInSeconds=15
#eureka server清理无效节点的时间间隔，默认60000毫秒，即60秒
eureka.server.evictionIntervalTimerInMs=20000
# 自我保护模式（缺省为打开）
eureka.server.enable-self-preservation: true
# 续期时间，即扫描失效服务的间隔时间（缺省为60*1000ms）
eureka.server.eviction-interval-timer-in-ms: 5000 
```
### 4、访问 localhost:7777
出现下图说明EurekaServer启动成功
![](http://ww3.sinaimg.cn/large/006tNc79ly1g4tl7b8kh4j31lc0u0wg3.jpg)

## 二、服务消费者配置

### 引入pom
```

<!-- 引入客户端 -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
<!--springboot2版本要求引入此包-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>

```
### 入口类配置
```java
@EnableDiscoveryClient
@SpringBootApplication
public class CloudAdminApplication {
	public static void main(String[] args) {
		SpringApplication.run(CloudAdminApplication.class, args);
	}

}
```
