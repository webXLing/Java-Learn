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


##### servletContext
- servletContext.getRealPath
- 在web 资源下 直接 /
- 在src 下自配置文件会最终 在WEB-INF 下的 classes 中 所以 /WEB-INF/classes

  
##### Cookie
1. maxTime  
    - 正数  持久化硬盘 时间
    - 0 删除
    - 负数 默认 和session 一样浏览器关闭则 失效了

2.tomcat 8 前 cookie 设置中文需要 url转码    

3.cookie 的共享问题
- 同一台tomcat服务器下的不同项目 可以通过 setPath('/') 共享cookie
- 多个服务器下 可以通过 设置一级域名相同 setDomain('.baidu.com') 共享cookie tieba.baidu.com 和 news.baidu.com 

4.特点
- 单个 不超过4kb 
- 同一个域名下 数量不超过20个


##### Jsp java server page

1.原理 ：index.jsp -> _index.java -> _index.class 本质上就是一个servlet 因为servlet才可以被客户端访问 

2.脚本
- <% 代码 %>  定义的java代码是在 service 方法里面的
- <!% 代码 %>  jsp转化的java 类 的成员变量  成员方法 静态代码块  尽量别去写
- <=% 代码 %>  也是在service 方法里面 变量输出 

3.jsp内置对象 ：可以直接使用的对象  9个
1.request
2.response
3.out 字符输出流 reponse.getriter 类似 
   - out 与 reponse.getriter 区别： reponse.getriter 先于out输出  
   - tomcat 服务器 做响应 先找 reponse.getriter 的缓冲区 再找 out的缓冲区
   
   
##### session 
1.细节
 - 当客户端关闭 服务器不关闭 服务端两次获取的session 是同一个吗
     1.不是
     2.如果要相同 则同过 设置cookie JSESSIONID 设置时间      
 - 当客户端没有关闭  服务器关闭  两次ssion 是同一个吗
    1.不是  但是要确保数据b不丢失
    2.session 的钝化
        * 在服务器关闭前 将session 对象化到硬盘中 work 文件在 的session.ser
    3.ssession 的活化
        * 服务器 启动后 将session.ser 读取到内存中去  并删除  tomcat已经实现了
  
  - session 的销毁问题
    1.服务器关闭
    2.session  对象调用 invalidate()
    3.默认30 分钟 可以在tomcat 的web.xml中配置
    
    
## JSP:
	1. 指令
		* 作用：用于配置JSP页面，导入资源文件
		* 格式：
			<%@ 指令名称 属性名1=属性值1 属性名2=属性值2 ... %>
		* 分类：
			1. page		： 配置JSP页面的
				* contentType：等同于response.setContentType()
					1. 设置响应体的mime类型以及字符集
					2. 设置当前jsp页面的编码（只能是高级的IDE才能生效，如果使用低级工具，则需要设置pageEncoding属性设置当前页面的字符集）
				* import：导包
				* errorPage：当前页面发生异常后，会自动跳转到指定的错误页面
				* isErrorPage：标识当前也是是否是错误页面。
					* true：是，可以使用内置对象exception
					* false：否。默认值。不可以使用内置对象exception


			2. include	： 页面包含的。导入页面的资源文件
				* <%@include file="top.jsp"%>
			3. taglib	： 导入资源
				* <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
					* prefix：前缀，自定义的
	2. 注释:
		1. html注释：
			<!-- -->:只能注释html代码片段
		2. jsp注释：推荐使用
			<%-- --%>：可以注释所有


	3. 内置对象
		* 在jsp页面中不需要创建，直接使用的对象
		* 一共有9个：
				变量名					真实类型						作用
			* pageContext				PageContext					当前页面共享数据，还可以获取其他八个内置对象
			* request					HttpServletRequest			一次请求访问的多个资源(转发)
			* session					HttpSession					一次会话的多个请求间
			* application				ServletContext				所有用户间共享数据
			* response					HttpServletResponse			响应对象
			* page						Object						当前页面(Servlet)的对象  this
			* out						JspWriter					输出对象，数据输出到页面上
			* config					ServletConfig				Servlet的配置对象
			* exception					Throwable					异常对象

## MVC：开发模式	
	1. jsp演变历史
		1. 早期只有servlet，只能使用response输出标签数据，非常麻烦
		2. 后来又jsp，简化了Servlet的开发，如果过度使用jsp，在jsp中即写大量的java代码，有写html表，造成难于维护，难于分工协作
		3. 再后来，java的web开发，借鉴mvc开发模式，使得程序的设计更加合理性

	2. MVC：
		1. M：Model，模型。JavaBean
			* 完成具体的业务操作，如：查询数据库，封装对象
		2. V：View，视图。JSP
			* 展示数据
		3. C：Controller，控制器。Servlet
			* 获取用户的输入
			* 调用模型
			* 将数据交给视图进行展示


		* 优缺点：
			1. 优点：
				1. 耦合性低，方便维护，可以利于分工协作
				2. 重用性高

			2. 缺点：
				1. 使得项目架构变得复杂，对开发人员要求高
   
   
## EL表达式
	1. 概念：Expression Language 表达式语言
	2. 作用：替换和简化jsp页面中java代码的编写
	3. 语法：${表达式}
	4. 注意：
		* jsp默认支持el表达式的。如果要忽略el表达式
			1. 设置jsp中page指令中：isELIgnored="true" 忽略当前jsp页面中所有的el表达式
			2. \${表达式} ：忽略当前这个el表达式


	5. 使用：
		1. 运算：
			* 运算符：
				1. 算数运算符： + - * /(div) %(mod)
				2. 比较运算符： > < >= <= == !=
				3. 逻辑运算符： &&(and) ||(or) !(not)
				4. 空运算符： empty
					* 功能：用于判断字符串、集合、数组对象是否为null或者长度是否为0
					* ${empty list}:判断字符串、集合、数组对象是否为null或者长度为0
					* ${not empty str}:表示判断字符串、集合、数组对象是否不为null 并且 长度>0
		2. 获取值
			1. el表达式只能从域对象中获取值
			2. 语法：
				1. ${域名称.键名}：从指定域中获取指定键的值
					* 域名称：
						1. pageScope		--> pageContext
						2. requestScope 	--> request
						3. sessionScope 	--> session
						4. applicationScope --> application（ServletContext）
					* 举例：在request域中存储了name=张三
					* 获取：${requestScope.name}

				2. ${键名}：表示依次从最小的域中查找是否有该键对应的值，直到找到为止。

				
				
				3. 获取对象、List集合、Map集合的值
					1. 对象：${域名称.键名.属性名}
						* 本质上会去调用对象的getter方法

					2. List集合：${域名称.键名[索引]}

					3. Map集合：
						* ${域名称.键名.key名称}
						* ${域名称.键名["key名称"]}


		3. 隐式对象：
			* el表达式中有11个隐式对象
			* pageContext：
				* 获取jsp其他八个内置对象
					* ${pageContext.request.contextPath}：动态获取虚拟目录
					
	
## JSTL
	1. 概念：JavaServer Pages Tag Library  JSP标准标签库
		* 是由Apache组织提供的开源的免费的jsp标签		<标签>

	2. 作用：用于简化和替换jsp页面上的java代码		

	3. 使用步骤：
		1. 导入jstl相关jar包
		2. 引入标签库：taglib指令：  <%@ taglib %>
		3. 使用标签
	
	4. 常用的JSTL标签
		1. if:相当于java代码的if语句
			1. 属性：
	            * test 必须属性，接受boolean表达式
	                * 如果表达式为true，则显示if标签体内容，如果为false，则不显示标签体内容
	                * 一般情况下，test属性值会结合el表达式一起使用
       		 2. 注意：
	       		 * c:if标签没有else情况，想要else情况，则可以在定义一个c:if标签
		2. choose:相当于java代码的switch语句
			1. 使用choose标签声明         			相当于switch声明
            2. 使用when标签做判断         			相当于case
            3. 使用otherwise标签做其他情况的声明    	相当于default

		3. foreach:相当于java代码的for语句

	5. 练习：
		* 需求：在request域中有一个存有User对象的List集合。需要使用jstl+el将list集合数据展示到jsp页面的表格table中





## 三层架构：软件设计架构
	1. 界面层(表示层)：用户看的得界面。用户可以通过界面上的组件和服务器进行交互
	2. 业务逻辑层：处理业务逻辑的。
	3. 数据访问层：操作数据存储文件。








## 案例：用户信息列表展示
	1. 需求：用户信息的增删改查操作
	2. 设计：
		1. 技术选型：Servlet+JSP+MySQL+JDBCTempleat+Duird+BeanUtilS+tomcat
		2. 数据库设计：
			create database day17; -- 创建数据库
			use day17; 			   -- 使用数据库
			create table user(   -- 创建表
				id int primary key auto_increment,
				name varchar(20) not null,
				gender varchar(5),
				age int,
				address varchar(32),
				qq	varchar(20),
				email varchar(50)
			);

	3. 开发：
		1. 环境搭建
			1. 创建数据库环境
			2. 创建项目，导入需要的jar包

		2. 编码
	

	4. 测试
	5. 部署运维



#### JSON数据和Java对象的相互转换

		* JSON解析器：
			* 常见的解析器：Jsonlib，Gson，fastjson，jackson
		
		1. JSON转为Java对象
			1. 导入jackson的相关jar包
			2. 创建Jackson核心对象 ObjectMapper
			3. 调用ObjectMapper的相关方法进行转换
				1. readValue(json字符串数据,Class)
		2. Java对象转换JSON
			1. 使用步骤：
				1. 导入jackson的相关jar包
				2. 创建Jackson核心对象 ObjectMapper
				3. 调用ObjectMapper的相关方法进行转换
					1. 转换方法：
						* writeValue(参数1，obj):
		                    参数1：
		                        File：将obj对象转换为JSON字符串，并保存到指定的文件中
		                        Writer：将obj对象转换为JSON字符串，并将json数据填充到字符输出流中
		                        OutputStream：将obj对象转换为JSON字符串，并将json数据填充到字节输出流中
		                * writeValueAsString(obj):将对象转为json字符串

					2. 注解：
						1. @JsonIgnore：排除属性。
						2. @JsonFormat：属性值得格式化
							* @JsonFormat(pattern = "yyyy-MM-dd")

					3. 复杂java对象转换
						1. List：数组
						2. Map：对象格式一致




# Filter：过滤器
	1. 概念：
		* 生活中的过滤器：净水器,空气净化器，土匪、
		* web中的过滤器：当访问服务器的资源时，过滤器可以将请求拦截下来，完成一些特殊的功能。
		* 过滤器的作用：
			* 一般用于完成通用的操作。如：登录验证、统一编码处理、敏感字符过滤...

	2. 快速入门：
		1. 步骤：
			1. 定义一个类，实现接口Filter
			2. 复写方法
			3. 配置拦截路径
				1. web.xml
				2. 注解
		2. 代码：
			@WebFilter("/*")//访问所有资源之前，都会执行该过滤器
			public class FilterDemo1 implements Filter {
			    @Override
			    public void init(FilterConfig filterConfig) throws ServletException {
			
			    }
			
			    @Override
			    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
			        System.out.println("filterDemo1被执行了....");
			
			
			        //放行
			        filterChain.doFilter(servletRequest,servletResponse);
			
			    }
			
			    @Override
			    public void destroy() {
			
			    }
			}


	3. 过滤器细节：
		1. web.xml配置	
			<filter>
		        <filter-name>demo1</filter-name>
		        <filter-class>cn.itcast.web.filter.FilterDemo1</filter-class>
		    </filter>
		    <filter-mapping>
		        <filter-name>demo1</filter-name>
				<!-- 拦截路径 -->
		        <url-pattern>/*</url-pattern>
		    </filter-mapping>
		2. 过滤器执行流程
			1. 执行过滤器
			2. 执行放行后的资源
			3. 回来执行过滤器放行代码下边的代码
		3. 过滤器生命周期方法
			1. init:在服务器启动后，会创建Filter对象，然后调用init方法。只执行一次。用于加载资源
			2. doFilter:每一次请求被拦截资源时，会执行。执行多次
			3. destroy:在服务器关闭后，Filter对象被销毁。如果服务器是正常关闭，则会执行destroy方法。只执行一次。用于释放资源
		4. 过滤器配置详解
			* 拦截路径配置：
				1. 具体资源路径： /index.jsp   只有访问index.jsp资源时，过滤器才会被执行
				2. 拦截目录： /user/*	访问/user下的所有资源时，过滤器都会被执行
				3. 后缀名拦截： *.jsp		访问所有后缀名为jsp资源时，过滤器都会被执行
				4. 拦截所有资源：/*		访问所有资源时，过滤器都会被执行
			* 拦截方式配置：资源被访问的方式
				* 注解配置：
					* 设置dispatcherTypes属性
						1. REQUEST：默认值。浏览器直接请求资源
						2. FORWARD：转发访问资源
						3. INCLUDE：包含访问资源
						4. ERROR：错误跳转资源
						5. ASYNC：异步访问资源
				* web.xml配置
					* 设置<dispatcher></dispatcher>标签即可
				
		5. 过滤器链(配置多个过滤器)
			* 执行顺序：如果有两个过滤器：过滤器1和过滤器2
				1. 过滤器1
				2. 过滤器2
				3. 资源执行
				4. 过滤器2
				5. 过滤器1 

			* 过滤器先后顺序问题：
				1. 注解配置：按照类名的字符串比较规则比较，值小的先执行
					* 如： AFilter 和 BFilter，AFilter就先执行了。
				2. web.xml配置： <filter-mapping>谁定义在上边，谁先执行
	4. 案例：
		1. 案例1_登录验证
			* 需求：
				1. 访问day17_case案例的资源。验证其是否登录
				2. 如果登录了，则直接放行。
				3. 如果没有登录，则跳转到登录页面，提示"您尚未登录，请先登录"。
 		
	

		2. 案例2_敏感词汇过滤
			* 需求：
				1. 对day17_case案例录入的数据进行敏感词汇过滤
				2. 敏感词汇参考《敏感词汇.txt》
				3. 如果是敏感词汇，替换为 *** 

			* 分析：
				1. 对request对象进行增强。增强获取参数相关方法
				2. 放行。传递代理对象


			* 增强对象的功能：
				* 设计模式：一些通用的解决固定问题的方式
				1. 装饰模式
				2. 代理模式
					* 概念：
						1. 真实对象：被代理的对象
						2. 代理对象：
						3. 代理模式：代理对象代理真实对象，达到增强真实对象功能的目的
				 	* 实现方式：
					 	1. 静态代理：有一个类文件描述代理模式
					 	2. 动态代理：在内存中形成代理类
							* 实现步骤：
								1. 代理对象和真实对象实现相同的接口
								2. 代理对象 = Proxy.newProxyInstance();
								3. 使用代理对象调用方法。
								4. 增强方法

							* 增强方式：
								1. 增强参数列表
								2. 增强返回值类型
								3. 增强方法体执行逻辑	


## Listener：监听器
	* 概念：web的三大组件之一。
		* 事件监听机制
			* 事件	：一件事情
			* 事件源 ：事件发生的地方
			* 监听器 ：一个对象
			* 注册监听：将事件、事件源、监听器绑定在一起。 当事件源上发生某个事件后，执行监听器代码


	* ServletContextListener:监听ServletContext对象的创建和销毁
		* 方法：
			* void contextDestroyed(ServletContextEvent sce) ：ServletContext对象被销毁之前会调用该方法
			* void contextInitialized(ServletContextEvent sce) ：ServletContext对象创建后会调用该方法
		* 步骤：
			1. 定义一个类，实现ServletContextListener接口
			2. 复写方法
			3. 配置
				1. web.xml
						<listener>
     					 <listener-class>cn.itcast.web.listener.ContextLoaderListener</listener-class>
   						</listener>

						* 指定初始化参数<context-param>
				2. 注解：
					* @WebListener
					* @WebListener

