
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

# 三、分布式系统

- [分布式系统的特点以及设计理念](http://www.infoq.com/cn/articles/features-and-design-concept-of-distributed-system) 通过网络松耦合、对机器硬件要求低、强调横向扩展、不允许单点失效、尽可能减少节点网络开销、服务无状态等特点的介绍。
- [book-Designing Data-Intensive Applications](http://dataintensive.net/) 评价很高
- [更多内容 …… ](readme-arch.md)

# 四、大型互联网技术架构分享

- [挖财技术体系架构以及 Scala 在挖财的实践](http://www.infoq.com/cn/articles/scala-architecture-wacai) 后端技术用的主要是比较大众的东西，Web 容器用 Tomcat，框架主要是 Spring MVC，也有少量的 Play，中间服务层是 Dubbo，微容器用Spring Boot，服务注册这一块是用 ZooKeeper，核心业务开发方式还是围绕着 Spring 和 Mybatis 等；数据的存储这块是 MySQL 和 Hbase，分布存储这块是用阿里巴巴之前开源的一个中间件 Cobar。消息和实时计算这块主要是 Kafka, Storm，日志以及监控系统则是用典型的ELK和Zabbix。（对于中小型的公司来讲有借鉴意义）
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
