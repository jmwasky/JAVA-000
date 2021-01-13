学习笔记
## kafka windows
- 下载安装  
[kafka下载地址](https://kafka.apache.org/downloads)
- 安装在一个windows机器  
1. 解压并去到bin目录,预装好java环境
2. zk自行下载启动，多个机器broker.id不能相同，集群模式，复制多分源文件 
   修改brokerid和日志地址：  
   - server.properties，在对应目录分别修改
   ```text
   broker.id=1
   log.dirs=D:/kafka/data/logs1
   listeners=PLAINTEXT://:19091
   
   broker.id=2
   log.dirs=D:/kafka/data/logs2
   listeners=PLAINTEXT://:19092
   
   broker.id=3
   log.dirs=D:/kafka/data/logs3
   listeners=PLAINTEXT://:19093
   ```
3. 启动单机节点
    ```shell script
    ./kafka-server-start.bat ../../config/server.properties
    ```
   分别启动后的截图：  
   ![broker1](https://github.com/jmwasky/JAVA-000/blob/main/Week_13/images/kafka-broker1.png)   
   ![broker2](https://github.com/jmwasky/JAVA-000/blob/main/Week_13/images/kafka-broker2.png)   
   ![broker3](https://github.com/jmwasky/JAVA-000/blob/main/Week_13/images/kafka-broker3.png)  
   zk信息：  
   ![zkinfo](https://github.com/jmwasky/JAVA-000/blob/main/Week_13/images/zk-tree.png)
4. 功能和性能
   创建topic
   ```shell script
   ./kafka-topics.bat --zookeeper localhost:2181 --create --topic testisaac --partitions 3 --replication-factor 2 
   ```
   列出所有topic
   ```shell script
   ./kafka-topics.bat --zookeeper localhost:2181 --list
   ```
   生产数据
   ```shell script
   ./kafka-console-producer.bat --bootstrap-server localhost:19091 --topic testisaac
    ```
   消费topic
   ```shell script
   ./kafka-console-consumer.bat --bootstrap-server localhost:19092,localhost:19093 --from-beginning --topic testisaac
   ```
   ![list topic](https://github.com/jmwasky/JAVA-000/blob/main/Week_13/images/kafka-list.png)  
   性能测试
   ```shell script
   ./kafka-producer-perf-test.bat --topic testisaac --num-records 100000 --record-size 1000 --throughput 5000 --producer-props bootstrap.servers=localhost:19091   
   ```
   删除topic,只会标记成删除，不会删除物理数据
   ```shell script
   ./kafka-topics --delete --zookeeper localhost:2181 --topic testisaac
   ```
   ![delete topic](https://github.com/jmwasky/JAVA-000/blob/main/Week_13/images/kafka-delete.png)  
5. spring kafka
   