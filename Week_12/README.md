学习笔记


### Redis 主从复制  
#### docker 创建两个redis服务，redis01:6379, redis02:6380, 通过 docker inspect <container id> 查找redis01的ip。  
- 创建docker redis 命令，[redus01配置](https://github.com/jmwasky/JAVA-000/blob/main/Week_12/redis/config/redis01_6379.conf)，[redus02配置](https://github.com/jmwasky/JAVA-000/blob/main/Week_12/redis/config/redis01_6380.conf)  
  ```shell script
  docker run -p 6380:6380 --name redis02 -v d:/docker/redis/redis02/conf.d/redis.conf:/etc/redis/redis.conf -v d:/docker/redis/redis02/data:/data -d redis redis-server /etc/redis/redis.conf --appendonly yes
  ```
- 列出redis01和redis02的keys：  
![list keys](https://github.com/jmwasky/JAVA-000/blob/main/Week_12/redis/images/Redis01-01.png)   
![list keys](https://github.com/jmwasky/JAVA-000/blob/main/Week_12/redis/images/Redis02-01.png)
- 在redis02命令界面输入：slaveof <masterIp> <masterPort> 设置主从, slaveof 172.17.0.2 6379    
![list slave](https://github.com/jmwasky/JAVA-000/blob/main/Week_12/redis/images/Redis01-02-slaveof-info.png)    
![list slave](https://github.com/jmwasky/JAVA-000/blob/main/Week_12/redis/images/Redis02-02-slaveof-info.png)  
- 在redis02命令界面输入：slaveof no one，取消主从  
![list keys](https://github.com/jmwasky/JAVA-000/blob/main/Week_12/redis/images/Redis02-03-slaveof-no-one.png)
### Sentinel 哨兵模式
- 两个redis,分别启动，[redis01_sentinel配置](https://github.com/jmwasky/JAVA-000/blob/main/Week_12/redis/config/sentinel_6379.conf),[redis02_sentinel配置](https://github.com/jmwasky/JAVA-000/blob/main/Week_12/redis/config/sentinel_6380.conf)  
  ```shell script
  redis-sentinel sentinel_6380.conf
  redis-sentinel sentinel_6379.conf
  ``` 
- 查看哨兵  
![sentinel1](https://github.com/jmwasky/JAVA-000/blob/main/Week_12/redis/images/Redis01-sentinel-info.png)  
![sentinel2](https://github.com/jmwasky/JAVA-000/blob/main/Week_12/redis/images/Redis02-sentinel-info.png)
### Cluster集群  
集群最多1000个节点
- 配置文件，计划使用docker创建6个redis节点    
> 修改[redis.conf](https://github.com/jmwasky/JAVA-000/blob/main/Week_12/redis/config/redis.conf)  
> 打开注释“cluster-enabled yes”
- 启动命令
1. 创建多个redis  
    ```shell script
    docker run -p <local port>:6379 --name <redis name> -v d:/docker/redis/<redis name>/conf.d/redis.conf:/etc/redis/redis.conf -v d:/docker/redis/<redis name>/data:/data -d redis redis-server /etc/redis/redis.conf --appendonly yes
    ```
   启动6个redis, 没启动集群前redis用  
   ![cluster list](https://github.com/jmwasky/JAVA-000/blob/main/Week_12/redis/images/Cluster_start.png)  
2. 创建集群  
   进入容器目录：/usr/local/bin/，启动使用无密码方式  
    ```shell script
    redis-cli --cluster create 172.17.0.2:6379 172.17.0.3:6379 172.17.0.4:6379 172.17.0.5:6379 172.17.0.6:6379 172.17.0.7:6379 --cluster-replicas 1
    ```
   ![cluster create 1](https://github.com/jmwasky/JAVA-000/blob/main/Week_12/redis/images/Cluster_create_1.png)   
   ![cluster create 2](https://github.com/jmwasky/JAVA-000/blob/main/Week_12/redis/images/Cluster_create_2.png)  
- 验证集群效果  
1. 查看集群状态  
   ![cluster create info](https://github.com/jmwasky/JAVA-000/blob/main/Week_12/redis/images/Cluster_info.png)
2. 查看单个节点状态
   ```shell script
    redis-cli --cluster check 172.17.0.6:6379
   ```
   结果：  
   ![cluster check](https://github.com/jmwasky/JAVA-000/blob/main/Week_12/redis/images/Cluster_check.png)
3. 使用redis-cli -c进入交互模式