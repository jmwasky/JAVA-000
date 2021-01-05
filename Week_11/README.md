学习笔记 
1. Redis分布式锁： RedisTool.java
2. 在Java中实现一个分布式计数器，模拟减库存。MallController对外提供服务，TestRequest.main方法测试。

- Redis 主从复制  
> 1. docker 创建两个redis服务，redis01:6379, redis02:6380, 通过 docker inspect <container id> 查找redis01的ip。  
  ![list keys](https://github.com/jmwasky/JAVA-000/blob/main/Week_11/redis/imges/Redis01-01.png)
> 创建docker redis 命令 
> ···
> docker run -p 6380:6380 --name redis02 -v d:/docker/redis/redis02/conf.d/redis.conf:/etc/redis/redis.conf -v d:/docker/redis/redis02/data:/data -d redis redis-server /etc/redis/redis.conf --appendonly yes
> ···
> 2. 在redis02命令界面输入：slaveof <masterIp> <masterPort> 设置主从, slaveof 172.17.0.2 6379。  
> 3. 在redis02命令界面输入：slaveof no one，取消主从
- Sentinel 哨兵模式
> 1. 两个redis,分别启动
> ··· 
> redis-sentinel sentinel_63xx.conf
> redis-sentinel sentinel_6379.conf
> ···
