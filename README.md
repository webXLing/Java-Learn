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
