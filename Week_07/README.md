学习笔记

1. （必做）按自己设计的表结构，插入100万订单模拟数据，测试不同方式的插入效率。  
test目录：com.isaac.easy.mysqldbsample.hikari.HikariDBTest.java  
- 一条条数据单独插入：  
线程池配置1个，插入花费时间：15分钟插入25w行  100w大概60分钟  
线程池配置10个，插入花费时间： 100w 大约 52分钟  
- executeBatch批量处理：   
线程池配置10个线程 批量处理 100w大约33分钟，性能比单条数据插入提升一倍
- 使用insert into values(),(),() 
注意values后面不能太长，不然传输溢出.  
100w数据，拼接一万条数据提交一次。用时：18秒，效率提升2个数量级

2. （必做）读写分离-动态切换数据源版本1.0
- 主要使用 AbstractRoutingDataSource + AOP
3. （必做）读写分离-数据库框架版本2.0
- 通过配置rule: pr_ds自动实现读写分离