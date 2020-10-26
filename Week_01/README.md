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

## GC 三个基石算法
- 标记清除
> 标记清除， 第一步标记根节点，一步一步标记相关联的内存，第二步清除没有关联的内存；
> 适合老年代，标记清除算法效率不高，老年代也不需要频繁GC;
- 标记复制
> 标记复制，第一步标记GC Root，第二步复制到其他内存上；需要使用更多的内存
> 适合年轻代，把Eden区和from区的数据复制的to区，然后直接清理Eden和from。
- 标记整理
> 标记清除整理，第一步同上，第二部清除没有标记的内存，第三步整理内存，清除碎片，
> 得到一整块的内存；
> 年老代
## GC
- 串行GC(Serial GC)/ 进阶GC ParNewGC
> 用于几百M内存的机器，而且只会使用单核计算
- 并行GC(Parallel GC)
> 充分利用多核计算，提高效率，增加吞吐量
- CMS GC/ G1 GC
> CMS:使用1/4的核心处理，年轻代使用标记复制，年老代使用标记清除，增加效率。年老代使用free-list管理内存
---
> G1: 默认分隔2048个区域，由各个区域组成年轻代，年老代，eden等。GC不会每次都回收所有区域，
> 会选择需要执行的区域进行单独回收，原则是只回收垃圾最多的区域。G1有各种参数可以调，
> 如：区域大小，最大年轻代占比，GC线程数等等。
### GC 组合
1. Serial + Serial Old 单线程的低延迟
2. ParNew + CMS 多线程低延迟
3. Parallel Scavenge + Parallel Scavenge Old 多线程高吞吐
### ZGC
> 高内存（>16G）状态下的低延时GC  

[jvm指令](https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-4.html)