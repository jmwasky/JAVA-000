学习笔记

## （必做）改造自定义RPC的程序，提交到github： 
1. 尝试将服务端写死查找接口实现类变成泛型和反射  
> 增加Rpcfxrequest.Class<?> clazz,在RpcfxInvoker获取
2. 尝试将客户端动态代理改成AOP，添加异常处理
> 添加了异常处理，AOP使用ByteBuddy实现，出现两种情况:  
1）rebase方式无法创建，提示" Cannot only define public, static, final field 'delegate$f0pnm81' for interface type"，   
2）使用subClass实现，无法调用服务端。
3. 尝试使用Netty+HTTP作为client端传输方式
> 