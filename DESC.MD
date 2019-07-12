# fast-cloud-examples
> springcloud相关入门操作,包含springcloud整个的技术栈
## 1、前期准备
在学习本课程之前，首先你要有一定的基础，包含Java，Git以及Springboot等相关知识。


## 2、简介

### 2.1、什么是微服务？
微服务是一种架构风格，一个大型复杂软件应用由一个或多个微服务组成。系统中的各个微服务可被独立部署，
各个微服务之间是松耦合的。每个微服务仅关注于完成一件任务并很好地完成该任务。在所有情况下，每个
任务代表着一个小的业务能力。


### 2.2、SpringCloud是什么？
Spring Cloud为开发人员提供了快速构建分布式系统中一些常见模式的工具
(例如配置管理，服务发现，断路器，智能路由，微代理，控制总线，一次性令牌，全局锁定，领导选举，分布式 会话，集群状态)。
分布式系统的协调导致锅炉板模式，使用Spring Cloud开发人员可以快速站起来实现这些模式的服务和应用程序。
它们适用于任何分布式环境，包括开发人员自己的笔记本电脑，裸机数据中心和Cloud Foundry等托管平台。
#### 2.2.1、特性
SpringCloud专注于为微服务用例提供良好的开箱即用体验，并为用户提供可扩展性机制。
* Eureka:服务注册与发现
* Spring Cloud Config: 分布式/版本化配置中心,可以基于git或外部配置文件
* Zuul: 路由,服务统一入口，提供限流，过滤智能路由等功能
* Feign/RestTemplate：服务之间的通信组件
* Ribbon: 负载均衡
* Spring Cloud Bus：消息总线，可以动态刷新配置
* Hystrix: 熔断器，为服务中断提供容错能力

## 3、为什么选择SpringCloud？

![](http://ww4.sinaimg.cn/large/006tNc79ly1g4w7357595j30u00q2gnm.jpg)



## 系列课程
内容逐步完善中...  

[前言](http://www.spring4all.com/article/15147)

[一、SpringCloud概览](http://www.spring4all.com/article/15148)

[二、Springcloud注册与发现之Eureka](http://www.spring4all.com/article/15149)

[三、Zuul网关]()：网关

[四、鉴权中心-SpringSecurity + OAuth2]()：SpringCloud统一鉴权中心，本内容分为，上、中、下三篇

[五、Feign和RestTemplate]：服务之间的调用

[六、熔断器Hystrix] : 

[七、链路追踪-Sleuth] :

[八、分布式锁]：

[九、消息系统] ：

[十、配置中心-Config] :

[十一、监控]：

[十二、优雅宕机] :


## 高级进阶
[一、SpringCloud脚手架]
  
## 项目实战

[二、项目实战-Saas系统]

[三、项目实战-量化交易网关]


## 关于我
[email : liangliang1259@163.com](liangliang1259@163.com)

[Github](https://github.com/liangliang1259)

更多请关注公众号`程序员阿亮`:

![](http://ww2.sinaimg.cn/large/006tNc79ly1g4w6hiwyomj30d00cymxh.jpg)

## 引用
> 部分图片来源于网络，若有版权问题，请联系我。
  
[什么是微服务](https://www.ibm.com/developerworks/community/blogs/3302cc3b-074e-44da-90b1-5055f1dc0d9c/entry/%E8%A7%A3%E6%9E%90%E5%BE%AE%E6%9C%8D%E5%8A%A1%E6%9E%B6%E6%9E%84_%E4%B8%80_%E4%BB%80%E4%B9%88%E6%98%AF%E5%BE%AE%E6%9C%8D%E5%8A%A1?lang=en)

