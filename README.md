# Java-Learn
#### 10月16号
Map 集合 是 双列集合 一个元素包含 两个值 K V
 Collection 集合 单列集合

 Class HashMap<K,V>  implements Map<k,v> 接口

 HashMap 是一个 无序的集合
 LinkedHashMap extends HashMap  底层是 哈希表+链表 有序的 多了一层链表

 Map 集合的方法
    V	put(K key, V value)
        将指定的值与该映射中的指定键相关联（可选操作）。
    返回的是之前的value

    V	remove(Object key)
    如果存在（从可选的操作），从该地图中删除一个键的映射。

    V get(Object key)
    返回到指定键所映射的值，或null如果此映射包含该键的映射。


    boolean	containsKey(Object key)
    如果此映射包含指定键的映射，则返回 true


    map 集合的第一种遍历方式  健找值
    1.通过KeySet 将 map 中的 key 存放在 set集合中
    2.然后通过遍历  set集合  通过map.get()方法  来间接的遍历map 集合


    map 集合的第二种遍历方式  使用Entry对象遍历
    1.通过EntrySet 将 map 中的 Entry对象（key value） 存放在 set集合中
    2.然后通过遍历  set集合  通过Entry对象 的getKey()方法  和 getValue() 来间接的遍历map 集合


    Map集合保证唯一 自定义类型
        作为key的元素必须重写hashcode 和equals方法来  保证key唯一


    java.util.HashMap<K,V>  //无序 不允许重复
    java.util.LinkedHashMap<K,V> //有序 不允许重复
        哈希表和链表实现的Map接口，具有可预测的迭代次序


    Class Hashtable<K,V>    不能存储null值 null建
      最早期的 双列集合 同步的 单线程 速度慢 但是安全

      HashMap 异步的 多线程 速度慢 可以存储null值 null建
     implements Map<K,V>

     Hashtable 和Vector集合一样 在jdk1.2 之后被更先进的集合取代了（HashMap，ArrayList） 取代了
     Hashtable 的子类 Properties仍活跃

#### 10月17日  
Exception 编译期异常 要么throw 要么try catch
    java.lang.throwable 类 是java中错误和异常的超类
        异常：编译期异常
            runtimeException 运行期出现的异常 交给 JVM处理
    通过try catch 抓取错误

    多个异常处理
        1.多个异常分别处理
        2.多个异常一次捕获，多次处理
            一个try 多个catch
            如果catch 的异常变量 如果有子父类 关系 必须子类写上面父类写下面
        3.多个异常一次捕获一次处理

    throws 处理异常对象 会抛给方法的调用者 最终交割iJVM 处理 =》终止程序
    使用格式
        返回值类型 方法名 （参数）throw AAAException,BBb Exception{
            throw new AAAException();
            throw new BBAException();
        }

        Throwable 中三个 方法

            finally 无论是否出现异常  都会执行 一般用于资源释放

            如果finally 有return  返回的是finally 中的 不是 try 中的

#### 10月19日  
##### 线程实现方式

并发 指的是  多件事情 同时让一个cpu处理  cup 只能在多件事情间非常快速的来回切换
并行 指的是  多件事情 由多个cpu 处理 这样多件事情可以同时的 进行

一个程序至少有一个进程  一个进程可以拥有多个线程

java.lang.Thread
    实现多线程
        1.创建Thread子类
        2.Thread子类 重写run方法 设置 线程任务
        3.创建Thread子类 对象  调用start 方法 开启线程

        void	start()
导致此线程开始执行; Java虚拟机调用此线程的run方法。

结果是两个线程同时运行：当前线程（从调用返回到start方法）和另一个线程（执行其run方法）。
不止一次启动线程是不合法的。 特别地，一旦线程完成执行就可能不会重新启动。

Java程序属于抢占式调度 优先级高的先执行 优先度相同 随机


#### 10月20日  
##### File

java.io.file 类
file 类方法

创建一个文件/文件夹
删除一个文件/文件夹
获取一个文件/文件夹
判断一个文件/文件夹 是否存在
对文件夹进行遍历
文区文件大小

file 类是一个和操作系统无关的类 任何的操作系统都可以 使用这个类中的方法

重点：
file：文件
directory 文件/目录
path 路径

   static String	pathSeparator
    与系统相关的路径分隔符字符，为方便起见，表示为字符串。
    static char	pathSeparatorChar
    与系统相关的路径分隔符。
    static String	separator
    与系统相关的默认名称 - 分隔符字符，以方便的方式表示为字符串。
    static char	separatorChar
    与系统相关的默认名称分隔符。

    pathSeparator 路径分割符 Windows：分号; linux:冒号 :
    separator 文件名称分割符 Windows：\; linux:/ :

    操作路径不能写死
    C:\delelop\a.txt

    "C:"+File.separator+"delelop"+File.separator+"a.txt"

public String getAbsolutePath()
返回此抽象路径名的绝对路径名字符串。

public String getPath()
这个抽象路径名的字符串形式


public String getName()
返回由此抽象路径名表示的文件或目录的名称。
 这只是路径名称序列中的最后一个名字。 如果路径名的名称序列为空，则返回空字符串。

 public long length()
返回由此抽象路径名表示的文件的长度。 如果此路径名表示目录，则返回值未指定。
文件夹没有大小的概念

public boolean exists()
测试此抽象路径名表示的文件或目录是否存在。

public boolean isDirectory()
测试此抽象路径名表示的文件是否为目录。
true当且仅当该抽象路径名表示的文件存在且为目录时; false否则

public boolean isFile()
true当且仅当该抽象路径名表示的文件存在且为普通文件时; false否则


public boolean createNewFile()
                      throws IOException
true如果命名文件不存在并被成功创建; false如果命名文件已经存在

public boolean mkdir()
创建由此抽象路径名命名的目录

public boolean mkdirs()
创建由此抽象路径名命名的目录，包括任何必需但不存在的父目录。
请注意，如果此操作失败，它可能已成功创建一些必需的父目录。

public boolean delete()
删除由此抽象路径名表示的文件或目录。 如果此路径名表示目录，则目录必须为空才能删除。
直接在硬盘中删除  不回去回收站

public String[] list(FilenameFilter filter)
返回一个字符串数组，命名由此抽象路径名表示的目录中满足指定过滤器的文件和目录。
该方法的行为与list()方法的行为相同，只是返回的数组中的字符串必须满足过滤器。
如果给定的filter是null那么所有的名字都被接受。
否则，一个名称满足过滤器，当且仅当值true当结果FilenameFilter.accept(File, String)滤波器的方法是在此抽象路径名和在于其表示目录中的文件或目录的名称调用。

public File[] listFiles()
 遍历的必须是一个目录 或者 目录必须存在  不然报错
 可以遍历到隐藏文件夹
 
 ###### 递归 方法在栈内存  所以递归更可能会造成 栈内存溢出
 
 #### 10月24日 
  tansient 修饰的成员变量  能够不被序列化  
  static 也有这样的功能

 #### 10月24日 
 ### JDBC 

-  DriverManager 驱动管理对象
-  Connection 数据库连接对象
-  Statement 执行sql对象
-  ResultSet 结果集对象
-  &emsp;next() 游标下移一行
-                getXxx(参数) Xxx数据类型
-            使用方法
-                next() 游标下移一行 并返回布尔值 true 为有效行 有数据
-                获取数据 getXxx(参数) Xxx数据类型
-        PreparedStatement 执行sql对象
-            sql注入问题  在拼接sql 时  会有sql关键字  造成安全问题
-            预编译sql


#### JDBC 下的事务
  1.使用connection 对象去开启事务
    `connection.setAutoCommit(false);`
  2.提交事务
    `connection.commit(); // 提交事务`  
  3.回滚
    `connection.rollback();`

---

##### 数据库连接池
1. 概念：其实就是一个容器 当系统初始化号以后 容器就会被创建 用户来访问就从池子里面那 用完之后放回池子  
2. 节约资源  用户访问快
3. 实现：
  - DataSource 接口
  - C3P0
  - Druid 
4.C3P0 数据库连接技术
5.Druid 数据库连接技术
  - 通过properties 配置
  - 分装 Druid工具类
  ```
  package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource ds; // 连接池

    static {
        //加载配置文件
        Properties properties = new Properties();
        try {
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("dconfig"));

            try {
//                获取 dataSource
                DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
                ds = dataSource;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    获取连接
    public static Connection getConnection(){
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//    释放资源
    public static void close(ResultSet rs, Statement st , Connection con){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(st!=null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Statement st , Connection con) {
        close(null, st, con);
    }


    // 获取连接池
    public static DataSource getDataSource(){
        return ds;
    }

}
 
  ```

##### Spring JDBC ： JDBC template


##### XMl

### 定义
- version
- encoding ISO-8859-1 告知浏览器文档的字符集   默认编码格式  
- standalong 表示该xml是不是独立的，如果是yes，则表示这个XML文档时独立的，不能引用外部的DTD规范文件；如果是no，则该XML文档不是独立的，表示可以用外部的DTD规范文档。
- CDATA 区域该区域内的文本会被原样展示

### 约束
- DTD  简单的约束技术
- Schema 复杂的约束技术   .xsd

## 解析
  #### 解析 读取方式
   
    1.DOM:将标记语言文档 一次性加载到内存当中去 形成一个dom树
      - 优点 方便的对 dom树 进行crud 操作
      - 缺点 占内存
    2.SAX:逐行读取 基于事件驱动
      - 优点 不占内存
      - 缺点 只能读取  不能够crud

  #### xml常见的解析器
    
  - JAXP sun公司官方的 支持 dom sax 两种方式
  - dom4j 解析dom
  - jsoup 解析html
  - PULL 安卓内置的解析器  sax




#### Tomcat
JavaEE Java在企业规范
Tomcat Apache基金公司的 仅支持少量的JavaEE 规范 
卸载 直接删除目录就可以 
#### Tomcat目录结构
- bin  可执行文件
- conf 配置文件
- lib  存放tomcat运行需要加载的jar包
- logs 存放tomcat在运行过程中产生的日志文件
- temp temp目录用户存放tomcat在运行过程中产生的临时文件。（清空不会对tomcat运行带来影响）
- webapps 存放web 项目
- work 

#### Tomcat操作 
1.启动 关闭
 - bin ./startup.sh  启动  http://localhost:8080/
 - bin ./shutdown.sh 关闭
 - 修改ip con/serve.xml 

#### Servlet 
 1.实现 Servlet 接口
 2.在web.xml中的添加
 ```
<!--    servlet 配置-->
    <servlet>
<!--        给类的名称起了一个名字-->
        <servlet-name>task</servlet-name>
        <servlet-class>web.ServletDemo</servlet-class>
    </servlet>

<!--    做一个映射-->
    <servlet-mapping>
        <servlet-name>task</servlet-name>
        <url-pattern>/taslapo</url-pattern>
    </servlet-mapping>
```
 
##### 执行原理
1.当服务器接收到客户端浏览器的请求后，会解析请求的URL路径，获取访问的Servlet的资源路径
2.查找web.xml文件 是否会对应的<url-pattern>
3.如果有，就可以找对对应的 <servlet-class> 全类名
4.tomcat会将字节码文件 加载到内存 (class.forName) 并创建其对象
5.对调用其方法


##### servlet生命周期
1.init servlet 被创建时执行 一次
    - 第一次被访问的时候创建 load-on-startup 负数 默认为-1
     -当web服务器 启动时创建 0 或正整数
     -<load-on-startup>5</load-on-startup>
     
     
### servlet 3.0
  - 好处 支持注解配置 可以不需要web.xml
  - @WebServlet("/api/demo")
  
  
  
##### 重定向与转发的区别
### 重定向
- 浏览器地址栏会发生改变
- 可以访问其他服务器的资源
- 对于浏览器来说 是发送了2次请求 不能用request 对象来共享数据

### 转发
- 浏览器地址栏不会发生改变
- 可以访问当前服务器的资源
- 对于浏览器来说 是发送了1次请求  可以用request 对象来共享数据


  
  
