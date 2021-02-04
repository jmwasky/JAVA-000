@[TOC]

# 毕业项目

## JVM
![JVM](https://github.com/jmwasky/JAVA-000/blob/main/continuing/images/JVM.jpg)  
[字节码技术](https://tech.meituan.com/2019/09/05/java-bytecode-enhancement.html)

jvm 部分学习 jvm内存模型，分为栈，堆，非堆和jvm自身，堆里面分年轻代和老年代，所有都是经过精心设计的。
jvm 的学习很多都是底层设计方面的东西，需要反复研究和使用才能记住，并不是只是看就可以了。
GC 算法的使用和调优是日常工作中很少用到的，需要找到自己负责的系统，慢慢调试。

## NIO
![NIO](https://github.com/jmwasky/JAVA-000/blob/main/continuing/images/NIO.jpg)  
NOI 学习了同步异步通信模型和阻塞、非阻塞线程模型，各种模型都是通过一个简单的单线程处理，不断演化而来，
通过加一些处理模块，优化执行顺序等，慢慢改进。netty 是集成这些模型的很好用的框架， 我再工作中很少用到netty，
IO 模型也了解得不多，这方面需要加强。IO 模型的思想跟其他框架的实现都十分类似，想jvm gc 的实现方式，都是从单线程
慢进化到多线程，并行，分开处理等。

## 并发编程
![并发编程](https://github.com/jmwasky/JAVA-000/blob/main/continuing/images/并发编程.jpg)  
并发是线程池引出的问题，需要使用锁或者CAS解决。锁需要遵循最小粒度和影响最小原则，使用线程需要使用线程安全集合，
如CopyOnWriteArrayList和ConcurrentMap。 可以通过Semaphore,countDownLatch等调用线程。并发编程在java里面是比较容易出问题的，
很多未知错误无法预估。使用方面，都是应对一些特殊场合，实际应用的地方不多。

## Spring 和 ORM 等框架
![Spring](https://github.com/jmwasky/JAVA-000/blob/main/continuing/images/Spring.jpg)  
spring 框架用得最多，现在都是基于springboot的开箱即用框架。spring aop 使用代理模式对类进行加强， 其底层技术是 cglib,
spring bean 的核心原理是统一的IOC环境管理。ORM 框架 myBatis 对 DBA 更友好，适合审计sql的性能，而 JPA 是一套基于
ORM 规范的一系列接口和抽象类。

## MySQL 数据库和 SQL
![MySql](https://github.com/jmwasky/JAVA-000/blob/main/continuing/images/MySql.jpg)  
使用mysql数据库在5.7+有多种高可用实现，集群可以用多主和MGR高可用方案。
sql优化方面，使用尽量小的数据类型；where查询key不要使用函数，否则不会使用索引；建立字段尽量默认NOT NULL；
日期获取用current_time, 不要用now()；尽量比较相同类型的字段；索引不要随意建，需要有识别度数据才有必要建；
隐式转换不走索引

## 分库分表
![分库分表](https://github.com/jmwasky/JAVA-000/blob/main/continuing/images/分库分表.jpg)  
分库分表在工作中没使用过，通过学习了解到，分库分表区分为水平拆和垂直拆分。水平拆分是分成多个相同结构的表，
减少单个表的压力,或者把表放到不同的库。垂直拆表按业务拆分多个子业务表，垂直拆库把业务表分库。分库分表后可以使用
中间件 如 shardingSphere-jdbc 或 sharding-proxy 进行访问，可以屏蔽具体选表选库逻辑，同时sql要跟着改变，不能
使用复杂sql，改造成本巨大。

## RPC 和微服务
![RPC](https://github.com/jmwasky/JAVA-000/blob/main/continuing/images/RPC.jpg)  
RPC 框架是包装多种通信方式的远程过程调用，核心是代理和通信，客户端序列化反序列化使用网络通信的方式调用远程服务，
远程服务经过序列化反序列化调用业务，再原路返回数据。常用 rpc框架： dubbo,sofa，gRpc。
分布式服务演化从单体-> 垂直架构 -> SOA -> 微服务。
微服务架构演化： 微服务 -> 服务网格 -> 数据库网格 -> 云原生 -> 单元化架构
微服务只要在复杂度高的项目才能提高效率，粒度要适当拆分，同时必须有相应的监控，测试，自动化管理方案。

## 分布式缓存
![缓存](https://github.com/jmwasky/JAVA-000/blob/main/continuing/images/缓存.jpg)  
缓存需要保存热数据和读远大于写的数据，缓存可以保存在应用里，进入分布式架构则需要有分布式缓存。分布式缓存主流的有
中间件形式： redis, 网格形式： Hazelcast。 缓存需要注意缓存击穿，缓存穿透和缓存雪崩，最佳方案是另外起一个异步定时加载数据
的服务。缓存框架很多，lettuce redission等。分布式锁使用redis实现是比较简单的方案，可以利用redis IO 单线程的特定。

## 分布式消息队列
![分布式消息队列](https://github.com/jmwasky/JAVA-000/blob/main/continuing/images/分布式消息队列.jpg)  
分布式消息队列是通过一个中间件传递消息，拥有异步，削峰，解耦等优点。MQ 是 RPC 的进化版，消费服务方面比 RPC 更可靠。
消息队列分为3代，第一代 ActiveMQ,属于内存型，速度快，但是容量受内存影响，容易崩。第二代是 kafka， 数据保存在
磁盘里面，容量大而且便宜。第三代 pulsar, 计算和存储分开，性能更好，扩容减容对用户非常顺滑。
生产者需要有ack机制，at least once, at most once, exactly once, 一般建议 at least once 保证性能和准确率。
一般需要手动 commit，可以保证处理出错，下次再消费。 

# 毕业总结
训练营学习了15周左右，感觉个人的收获最大的是扩展的技术视野和认识志同道合的学习者。自己在工作中的技术积累不深，
通过体系化的串讲，更深刻的了解到技术之间的关系。很多底层的原理都是相通的，了解了一种技术原理，再去学习其他的
技术是很容易加深理解的。  
当然学习只是最开始，最重要的要继续加深了解，对自己感兴趣的方面加深研究。 同时，在学以致用方面，开源是一个很好
的实践机会，学了，用了，才能加深理解。  
坚持学习是人生的必要课，刚开课的时候1000多人，15周能坚持下去真的很少。当然15周才是起点，终身学习才能一直进步。