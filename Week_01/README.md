# 学习笔记
## 作业
1. 自己写一个简单的Hello.java，里面需要涉及基本类型，四则运算，if和for，然后自己分析一下对应的字节码，有问题群里讨论。
2. 自定义一个Classloader，加载一个Hello.xlass文件，执行hello方法，此文件内容是一个Hello.class文件所有字节(x=255-x)处理后的文件。文件群里提供。
3. 画一张图，展示Xmx、Xms、Xmn、Meta、DirectMemory、Xss这些内存参数的关系。
4. 检查一下自己维护的业务系统的JVM参数配置，用jstat和jstack、jmap查看一下详情，并且自己独立分析一下大概情况，思考有没有不合理的地方，如何改进。
 
> Xmx: 运行最大堆内存; Xms: 运行最小堆内存; Xmn:Young Generation大小; Meta:元数据区； DirectMemory: 直接内存; Xss: 堆栈内存，指定线程内存大小。

## 收获
> 通过自定义classloader加深理解类加载过程：加载(loading)->校验(verification)->准备(preparation)->解析(resolution)->初始化(initialization)->使用(using)->卸载(unloading)

前5部分就是类加载过程，校验准备解析是类连接的过程。
- 加载也叫装载，负责找到二进制字节码，通过jvm和类加载器共同完成
- 校验：检查classfile的语义，判断常量池中的符号，检查类型等，保证符合虚拟机的规范。加载超类和接口。
- 准备：初始化静态字段，分配静态变量的内存空间。
- 解析：解析常量池：类和接口解析，字段解析，类方法和接口方法解析
- 初始化：类构造器方法，static静态变量初始语句，static静态方法

[jvm指令](https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-4.html)