
1. 随着公司规模的发展，合理稳定的技术架构是业务快速发展的保证，目前很多互联网公司的规模已经很大，在他们成长的过程中，系统结构的变更是怎样的，对我们又有什么样的借鉴？业务规模、数据量越来越大，传统的单机系统已经不能支持，分布式系统的坑有哪些，有哪些优秀的设计？
2. 作为一个主打后端的开发，以 Java 语言为例，需要掌握到什么程度，对涉及到的周边比如 数据结构、算法、jvm 优化、Linux、docker 等有哪些需要掌握的知识？

# 一、Java 语言
## 1.1 规范
- [Java 语言、虚拟机规范 - Java Language and Virtual Machine Specifications](http://docs.oracle.com/javase/specs/) Java SE6/7/8 每个版本中的语言规范、虚拟机规范进行说明。
- [Google 代码规范 - Google Code Style Guide](http://google-styleguide.googlecode.com/svn/trunk/javaguide.html) 中文翻译版本[Google Java 编程风格指南](http://www.hawstein.com/posts/google-java-style.html)
- [更多内容 …… ](readme-java.md)

## 1.2 JVM 虚拟机
- [Understanding Java Garbage Collection](http://www.cubrid.org/blog/dev-platform/understanding-java-garbage-collection/) 阅读完《[深入理解Java虚拟机第二版](https://github.com/xirong/my-java/blob/master/jvm/%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3java%E8%99%9A%E6%8B%9F%E6%9C%BA%E7%AC%94%E8%AE%B0.xmind)》后，感觉没有形成一个大局观，这篇文章介绍的很详细，每个收集器的区别等。
- [HotspotOverview.pdf](https://www.cs.princeton.edu/picasso/mats/HotspotOverview.pdf) 基于SE6，Compilation、Synchronization、Garbage Collection、A Performance Future几个部分来介绍。最权威的介绍 Hotspot 还是看 Oracle 官方[Java SE HotSpot at a Glance]
- [How to Monitor Java Garbage Collection](http://www.cubrid.org/blog/dev-platform/how-to-monitor-java-garbage-collection/) 如何利用系统自带的监控工具进行监控 GC 的状态
- [更多内容 …… ](readme-java.md)

## 1.3 其它
- [多线程并发编程、常见问题、java8 学习、java9资讯等](readme-java.md)

# 二、Linux
## 2.1 Linux 常用命令
- [每天一个 Linux 命令系列教程](http://www.cnblogs.com/peida/archive/2012/12/05/2803591.html)
- [Linux工具快速教程 - 分类介绍各种命令](http://linuxtools-rst.readthedocs.org/zh_CN/latest/index.html)
- [最常用的 Linux 命令大全](http://codecloud.net/linux-commond-461.html) 包括查看系统信息、文本处理、文件搜索、磁盘处理等
- [更多内容 …… ](readme-linux.md)

## 2.2 Shell 脚本
- [Shell Scripting: What are some time-saving tips that every Linux user should know?](https://www.quora.com/Shell-Scripting/What-are-some-time-saving-tips-that-every-Linux-user-should-know) quora 上面的回答，很精彩。
- [快乐的 Linux 命令行 - 学习 Shell 脚本](http://billie66.github.io/TLCL/book/zh/) 介绍什么是 Shell 、配置、常见任务、工具以及 Shell 流程控制、if~else 循环、字符串数组等。
- [更多内容 …… ](readme-linux.md)

## 2.3 效率工具
- [Zsh - Oh my zsh](http://ohmyz.sh/) xirong 写过一篇文章，专门介绍 Zsh 的配置等，可以阅读[提高命令效率之终极利器 Oh-my-zsh](http://www.ixirong.com/2015/04/27/strong-bash-use-oh-my-zsh/)
- [Linux Bash Shell Cheat Sheet](http://cli.learncodethehardway.org/bash_cheat_sheet.pdf)
- [更多内容 …… ](readme-linux.md)


## 2.4 Linux 图书
- [Linux系统架构与目录解析](http://book.douban.com/subject/3592797/)
- [鸟哥的Linux私房菜.基础学习篇（第三版）](http://book.douban.com/subject/4889838/)
- [更多内容 …… ](readme-linux.md)

## 2.5 Linux 监控
- [Linux 性能监测专题 - LinuxCn](https://linux.cn/topic-linux-system-performance-monitoring.html) 列举了包括 CPU、Memory、IO、Network 等许多基础组件的监控，以及进程、性能等。
- [更多内容 …… ](readme-linux.md)

# 三、分布式系统

- [分布式系统的特点以及设计理念](http://www.infoq.com/cn/articles/features-and-design-concept-of-distributed-system) 通过网络松耦合、对机器硬件要求低、强调横向扩展、不允许单点失效、尽可能减少节点网络开销、服务无状态等特点的介绍。
- [book-Designing Data-Intensive Applications](http://dataintensive.net/) 评价很高
- [关于 CAP 理论的深度剖析](http://mp.weixin.qq.com/s?__biz=MzA4Nzg5Nzc5OA==&mid=2651660931&idx=1&sn=93cccfdcc5a474e92ffd673e7cd115ce#rd)
    - **一致性（C）**：在分布式系统中的所有数据备份，在同一时刻是否同样的值。（等同于所有节点访问同一份最新的数据副本）
    - **可用性（A）**：在集群中一部分节点故障后，集群整体是否还能响应客户端的读写请求。（对数据更新具备高可用性）
    - **分区容忍性（P）**：以实际效果而言，分区相当于对通信的时限要求。系统如果不能在时限内达成数据一致性，就意味着发生了分区的情况，必须就当前操作在C和A之间做出选择。
- [更多内容 …… ](readme-arch.md)

# 四、大型互联网技术架构分享
- [Stack Overflow: The Architecture - 2016 Edition](http://nickcraver.com/blog/2016/02/17/stack-overflow-the-architecture-2016-edition/) stack Overflow最新版的架构设计
- [追求极致-从技术细节看美团架构](http://mp.weixin.qq.com/s?__biz=MjM5MDE0Mjc4MA==&mid=402465951&idx=1&sn=c76193b13b506d2c631bac8840a0f5b6&scene=1&srcid=012731CIWuUoX1w8bGv2THHJ#rd) 讲述美团作为电商网站的技术架构发展历程，没有最好的架构，只有不断优化。
- [挖财技术体系架构以及 Scala 在挖财的实践](http://www.infoq.com/cn/articles/scala-architecture-wacai) 后端技术用的主要是比较大众的东西，Web 容器用 Tomcat，框架主要是 Spring MVC，也有少量的 Play，中间服务层是 Dubbo，微容器用Spring Boot，服务注册这一块是用 ZooKeeper，核心业务开发方式还是围绕着 Spring 和 Mybatis 等；数据的存储这块是 MySQL 和 Hbase，分布存储这块是用阿里巴巴之前开源的一个中间件 Cobar。消息和实时计算这块主要是 Kafka, Storm，日志以及监控系统则是用典型的ELK和Zabbix。（对于中小型的公司来讲有借鉴意义）
- [单表 60 亿记录等大数据场景的 MySQL 优化和运维之道](http://mp.weixin.qq.com/s?__biz=MzAwMDU1MTE1OQ==&mid=209403337&idx=1&sn=f99429e24e8c591111a355e072f93e05)
- [乐视电商云的整体架构与技术实现](http://mp.weixin.qq.com/s?__biz=MzA4Nzg5Nzc5OA==&mid=403162298&idx=1&sn=e1ccd26c4bd5619d30ad11d90a0cbc20&scene=1&srcid=0408CPAdONg0R3njhuaBvK7k&from=groupmessage&isappinstalled=0#wechat_redirect)
- [MongoDB在58同城的应用实践](http://mp.weixin.qq.com/s?__biz=MzA3NDc2Mjg3Nw==&mid=2651130062&idx=1&sn=160863b535d01d70a7429b0829516bc6&scene=1&srcid=04201IL48lDHoeaadoUT5mIG#rd)
- [今日头条架构演进之路——高压下的架构演进专题](http://mp.weixin.qq.com/s?__biz=MzAwMDU1MTE1OQ==&mid=2653547520&idx=1&sn=f303a6250eb68775e9b6dbbdea6b9f06) 解耦、微服务(轻量级)、自动化。
- [更多内容 …… ](readme-arch.md)

# 五、周边

## 5.1 数据结构及算法
复习「数据结构常用算法」进行的练习，整节来源于书籍《[大话数据结构](http://book.douban.com/subject/6424904/)》
- [冒泡排序及其改进](http://www.ixirong.com/2015/07/16/sort-algorithm-bubblesort/) ,源码地址[BubbleSort](sort-algorithm/BubbleSort.java)
- [简单选择排序](http://www.ixirong.com/2015/07/19/sort-algorithm-selectionsort/) ，源码地址[SelectionSort](sort-algorithm/SelectionSort.java)
- [直接插入排序](http://www.ixirong.com/2015/07/19/sort-algorithem-insertsort/)，源码地址[SelectionSort](sort-algorithm/SelectionSort.java)
- [更多内容 …… ](readme-algorithm.md)

## 5.1 Python
- [廖雪峰的 Python 教程](http://www.liaoxuefeng.com/wiki/0014316089557264a6b348958f449949df42a6d3a2e542c000)
- [Python Cookbook 3rd Edition Documentation](http://python3-cookbook.readthedocs.org/zh_CN/latest/index.html) python3 学习手册，翻译的很全面，是本好资料。
- [更多内容 …… ](readme-python.md)

## 5.2 Docker
- [Docker学习路线图](https://yq.aliyun.com/articles/40494?spm=5176.100239.blogcont55847.15.igsKgo) 循序渐进学习，包含阿里云容器的一些资料。
- [Docker 收集资料](https://github.com/hangyan/docker-resources/blob/master/README_zh.md) 包括图书、网站、文档等很多资料。
- [Docker 生态体系](https://www.mindmeister.com/zh/389671722/docker-ecosystem) xmind很清楚。

## 5.3 负载均衡
- [Nginx 引入线程池 性能提升9倍](https://yq.aliyun.com/articles/26635?&utm_campaign=sys&utm_medium=market&utm_source=edm_email&msctype=email&mscmsgid=117816050400243403&)
- [更多内容 …… ](readme-nginx.md)

## 六、开源世界
- [如何对待开源-小米对开源的使用与参与之道](http://www.infoq.com/cn/presentations/the-xiaomi-participation-of-open-source-use)
- [如何对待开源-使用开源项目的正确姿势，都是血和泪的总结！](https://yq.aliyun.com/articles/6042?do=login)
