# 说明

随着公司规模的发展，合理稳定的技术架构是业务快速发展的保证，目前很多互联网公司的规模已经很大，在他们成长的过程中，系统结构的变更是怎样的，对我们又有什么样的借鉴？业务规模、数据量越来越大，传统的单机系统已经不能支持，分布式系统的坑有哪些，有哪些优秀的设计？

## 一、分布式系统

- [分布式系统的特点以及设计理念](http://www.infoq.com/cn/articles/features-and-design-concept-of-distributed-system) 通过网络松耦合、对机器硬件要求低、强调横向扩展、不允许单点失效、尽可能减少节点网络开销、服务无状态等特点的介绍。
- [book-Designing Data-Intensive Applications](http://dataintensive.net/) 评价很高
- [关于 CAP 理论的深度剖析](http://mp.weixin.qq.com/s?__biz=MzA4Nzg5Nzc5OA==&mid=2651660931&idx=1&sn=93cccfdcc5a474e92ffd673e7cd115ce#rd)
    - **一致性（C）**：在分布式系统中的所有数据备份，在同一时刻是否同样的值。（等同于所有节点访问同一份最新的数据副本）
    - **可用性（A）**：在集群中一部分节点故障后，集群整体是否还能响应客户端的读写请求。（对数据更新具备高可用性）
    - **分区容忍性（P）**：以实际效果而言，分区相当于对通信的时限要求。系统如果不能在时限内达成数据一致性，就意味着发生了分区的情况，必须就当前操作在C和A之间做出选择。
- [互联网分布式事务-coolshell](http://coolshell.cn/articles/10910.html)
- 分布式系统下全局 ID 生成方法
    - [MongoDB文档（Document）全局唯一ID的设计思路](http://blog.nosqlfan.com/html/3511.html) 类似于 twitter 的开源算法 `snowflake` 
    - [58沈剑细聊分布式ID生成方法](http://www.ita1024.com/eventlist/view/id/67) 数据库的 auto_increment 、单点批量ID生成服务、uuid、取当前毫秒数、类snowflake算法 各类的优缺点。
- [Dapper，大规模分布式系统的跟踪系统 -google](http://bigbully.github.io/Dapper-translation/) 类似于阿里的鹰眼(Egaleye)，google 原版论文[Dapper, a Large-Scale Distributed Systems Tracing Infrastructure](http://research.google.com/pubs/pub36356.html)，类似于 Twitter 的[Distributed Systems Tracing with Zipkin](https://blog.twitter.com/2012/distributed-systems-tracing-with-zipkin)

## 二、技术架构分享
- [Stack Overflow: The Architecture - 2016 Edition](http://nickcraver.com/blog/2016/02/17/stack-overflow-the-architecture-2016-edition/) stack Overflow最新版的架构设计
- [追求极致-从技术细节看美团架构](http://mp.weixin.qq.com/s?__biz=MjM5MDE0Mjc4MA==&mid=402465951&idx=1&sn=c76193b13b506d2c631bac8840a0f5b6&scene=1&srcid=012731CIWuUoX1w8bGv2THHJ#rd) 讲述美团作为电商网站的技术架构发展历程，没有最好的架构，只有不断优化。
- [挖财技术体系架构以及 Scala 在挖财的实践](http://www.infoq.com/cn/articles/scala-architecture-wacai) 后端技术用的主要是比较大众的东西，Web 容器用 Tomcat，框架主要是 Spring MVC，也有少量的 Play，中间服务层是 Dubbo，微容器用Spring Boot，服务注册这一块是用 ZooKeeper，核心业务开发方式还是围绕着 Spring 和 Mybatis 等；数据的存储这块是 MySQL 和 Hbase，分布存储这块是用阿里巴巴之前开源的一个中间件 Cobar。消息和实时计算这块主要是 Kafka, Storm，日志以及监控系统则是用典型的ELK和Zabbix。（对于中小型的公司来讲有借鉴意义）
- [单表 60 亿记录等大数据场景的 MySQL 优化和运维之道](http://mp.weixin.qq.com/s?__biz=MzAwMDU1MTE1OQ==&mid=209403337&idx=1&sn=f99429e24e8c591111a355e072f93e05)
- [乐视电商云的整体架构与技术实现](http://mp.weixin.qq.com/s?__biz=MzA4Nzg5Nzc5OA==&mid=403162298&idx=1&sn=e1ccd26c4bd5619d30ad11d90a0cbc20&scene=1&srcid=0408CPAdONg0R3njhuaBvK7k&from=groupmessage&isappinstalled=0#wechat_redirect)
- [MongoDB在58同城的应用实践](http://mp.weixin.qq.com/s?__biz=MzA3NDc2Mjg3Nw==&mid=2651130062&idx=1&sn=160863b535d01d70a7429b0829516bc6&scene=1&srcid=04201IL48lDHoeaadoUT5mIG#rd)
- [今日头条架构演进之路——高压下的架构演进专题](http://mp.weixin.qq.com/s?__biz=MzAwMDU1MTE1OQ==&mid=2653547520&idx=1&sn=f303a6250eb68775e9b6dbbdea6b9f06) 解耦、微服务(轻量级)、自动化。