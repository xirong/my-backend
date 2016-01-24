
说明
======

整个repo都是个人在学习Java过程中收集的资料，进行的练习，分享给大家。

# java 语言

## 规范
- [Java 语言、虚拟机规范 - Java Language and Virtual Machine Specifications](http://docs.oracle.com/javase/specs/) Java SE6/7/8 每个版本中的语言规范、虚拟机规范进行说明。
- [Google 代码规范 - Google Code Style Guide](http://google-styleguide.googlecode.com/svn/trunk/javaguide.html) 中文翻译版本[Google Java 编程风格指南](http://www.hawstein.com/posts/google-java-style.html)
- [Reasons, Tips and Tricks for Better Java Documentation - 写更好的 Java 文档注释](http://zeroturnaround.com/rebellabs/reasons-tips-and-tricks-for-better-java-documentation/) 写一个类、方法前思考清楚她的职责，多多使用 @Author/@Version/@Since/@Value 等注解来进行说明。中文翻译版本参考[ImportNew - 改善 Java 文档的理由、建议和技巧](http://www.importnew.com/16459.html)


## 常见问题
- [深入理解 HashMap](https://github.com/guohongjun/HashMap-System-Learning) HashMap 的结构是怎样的，又是怎样处理 Hash 冲突的。

## 并发编程
- [java.util.concurrent - Java Concurrency Utilities](http://tutorials.jenkov.com/java-util-concurrent/index.html)

## Java8 学习
- [Java Platform, Standard Edition (Java SE) 8 Documentation](http://docs.oracle.com/javase/8/)

## Java9 前沿
- [5 个 java 9 新特性](http://www.importnew.com/16280.html)


# JVM 虚拟机

- [Understanding Java Garbage Collection](http://www.cubrid.org/blog/dev-platform/understanding-java-garbage-collection/) 阅读完《[深入理解Java虚拟机第二版](https://github.com/xirong/my-java/blob/master/jvm/%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3java%E8%99%9A%E6%8B%9F%E6%9C%BA%E7%AC%94%E8%AE%B0.xmind)》后，感觉没有形成一个大局观，这篇文章介绍的很详细，每个收集器的区别等。
- [HotspotOverview.pdf](https://www.cs.princeton.edu/picasso/mats/HotspotOverview.pdf) 基于SE6，Compilation、Synchronization、Garbage Collection、A Performance Future几个部分来介绍。最权威的介绍 Hotspot 还是看 Oracle 官方[Java SE HotSpot at a Glance]
- [How to Monitor Java Garbage Collection](http://www.cubrid.org/blog/dev-platform/how-to-monitor-java-garbage-collection/) 如何利用系统自带的监控工具进行监控 GC 的状态
- [How to Tune Java Garbage Collection](http://www.cubrid.org/blog/dev-platform/how-to-tune-java-garbage-collection/)
- [Jvm 性能监控及故障排查命令行、图形化工具介绍及相应使用方法](http://www.ixirong.com/2015/08/01/jvm-monitor-tools/)
- Jvm Tuning Resources (Jvm 调优实践)
	- [Start with Jvm :heap,stack,-Xss,-Xmn,-Xmx,-Xms Overview](http://www.avricot.com/blog/?post/2010/05/03/Get-started-with-java-JVM-memory-(heap%2C-stack%2C-xss-xms-xmx-xmn...)) 介绍几个详细参数的确切含义
	- [Java 进程 Jvm 参数调优指导 -- 各个参数介绍及实践经验](jvm/Java进程JVM参数调优指导.pdf) 介绍 Heap、Stack、Perm各个区及相应的优化参数，满满的都是实战经验。
	- [Tuning Garbage Collection Outline](http://www.petefreitag.com/articles/gctuning/)
	- [Java SE 6 HotSpot[tm] Virtual Machine Garbage Collection Tuning](http://www.oracle.com/technetwork/java/javase/gc-tuning-6-140523.html)
	- [Gabage First(G1) Collector in Jdk 7 - from Stackoverflow.com](http://stackoverflow.com/questions/8111310/java-7-jdk-7-garbage-collection-and-documentation) G1 收集器的一些介绍
	- [All Java HotSpot VM Options](http://www.oracle.com/technetwork/articles/java/vmoptions-jsp-140102.html) 所有的配置参数介绍
	- [Java HotSpot Garbage Collection Whiterpapers](http://www.oracle.com/technetwork/articles/java/index-jsp-140228.html) 包括内存管理、收集器技术、收集Tuning、常见错误解决方法、G1 介绍等。

jvm 的测试代码及一些参考资料见[目录jvm](jvm/)
