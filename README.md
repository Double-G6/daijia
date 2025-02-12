一、背景概述
        乐尚代驾是一项旨在为客户提供安全、便捷的代驾服务的项目代驾是一种新型的出行服务模式，主营业务：酒后代驾、商务代驾、长途代驾，其主要特点是通过线上平台为用户提供代驾服务，伴随中国家庭汽车保有量的飞速增长代驾行业驶进了快车道，当前项目就是以此为背景设计出来的。

二、技术栈
SpringBoot：简化Spring应用开发。

SpringCloudAlibaba：Spring Cloud Gateway、Spring Cloud OpenFeign、Sentinel等。

MySQL：关系型数据库。

MyBatis-Plus：持久层框架。

Redis：内存做缓存，使用GEO 作为GPS分区定位计算。

Redisson：Redisson 是一个基于 Redis 的 Java 客户端，主要用于简化 Redis 的使用，并提供一个易于使用的 API。

RabbitMQ：消息中间件；大型分布式项目是标配；分布式事务最终一致性

Seata：分布式事务

Drools：规则引擎，计算预估费用、取消费用等等。

ThreadPoolExecutor+CompletableFuture：异步编排，线程池来实现异步操作，提高效率。

XXL-JOB: 分布式定时任务调用中心，完成任务调度。

阿里云OSS对象存储服务：阿里云提供的一种海量、低成本、高可靠的云存储服务。

阿里云视觉智能开放平台：是一个基于人工智能和大数据技术的综合性图像和视频处理服务平台。该平台提供了多种视觉识别和分析的API，旨在帮助企业和开发者构建智能应用。

Docker：容器化技术。

Git：代码管理工具；Git使用，拉代码、提交、推送、合并、冲突解决。


注意：
    项目启动所需有以下服务（版本尽量一致）：
                                       1.jdk-17
                                       2.腾讯云人脸识别，证件识别，OSS存储等
                                       3.开通腾讯地图调度服务
                                       4.微信小程序位置服务插件
                                       5.docker中安装redis，nacos-2.1.1, rabbitmq-3.12.0, minio(windows版本也可),mongdb-7.0.0, mysql-8.0.30
                                       6.https://www.ngrok.cc，注册ngrok，并开通隧道
                                       7.安装分布式服务seata-serve-1.7.1
                                       8.启动任务调度中心-xxl-job服务，详情请访问：https://www.xuxueli.com/xxl-job/#google_vignette
                                       9.微信开发者工具
