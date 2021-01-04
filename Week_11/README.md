学习笔记 
1. Redis分布式锁： RedisTool.java
2. 在Java中实现一个分布式计数器，模拟减库存。MallController对外提供服务，TestRequest.main方法测试。

- Redis 主从复制  
> docker 创建两个redis服务，redis01:6379, redis02:6380, 通过 docker inspect <container id> 查找redis01的ip
> 在redis02命令界面输入：slaveof <masterIp> <masterPort>, slaveof 172.17.0.2 6379
> 在redis02命令界面输入：slaveof no one，取消主从
