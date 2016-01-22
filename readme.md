# 说明

随着公司规模的发展，合理稳定的技术架构是业务快速发展的保证，目前很多互联网公司的规模已经很大，在他们成长的过程中，系统结构的变更是怎样的，对我们又有什么样的借鉴？
业务规模、数据量越来越大，传统的单机系统已经不能支持，分布式系统的坑有哪些，有哪些优秀的设计？

# 一、分布式系统

- [分布式系统的特点以及设计理念](http://www.infoq.com/cn/articles/features-and-design-concept-of-distributed-system) 通过网络松耦合、对机器硬件要求低、强调横向扩展、不允许单点失效、尽可能减少节点网络开销、服务无状态等特点的介绍。
- [book-Designing Data-Intensive Applications](http://dataintensive.net/) 评价很高

# 二、技术架构分享

-[挖财技术体系架构以及 Scala 在挖财的实践](http://www.infoq.com/cn/articles/scala-architecture-wacai) 后端技术用的主要是比较大众的东西，Web 容器用 Tomcat，框架主要是 Spring MVC，也有少量的 Play，中间服务层是 Dubbo，微容器用Spring Boot，服务注册这一块是用 ZooKeeper，核心业务开发方式还是围绕着 Spring 和 Mybatis 等；数据的存储这块是 MySQL 和 Hbase，分布存储这块是用阿里巴巴之前开源的一个中间件 Cobar。消息和实时计算这块主要是 Kafka, Storm，日志以及监控系统则是用典型的ELK和Zabbix。（对于中小型的公司来讲有借鉴意义）
