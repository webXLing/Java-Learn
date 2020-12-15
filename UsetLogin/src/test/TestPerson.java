package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import org.junit.Test;

import java.util.*;

public class TestPerson {
    /**
     * 将java对象 转化为 json
     */
    @Test
    public void test() throws Exception {
        Person person = new Person();
        person.setAge(11);
        person.setName("xl");
        person.setBirthday(new Date());
        person.setIg("qweqw");

//        jackson 核心对象
        ObjectMapper objectMapper = new ObjectMapper();

        String s = objectMapper.writeValueAsString(person);
        System.out.println(s);  //{"age":11,"name":"xl"}

        // list => 数组
        List<Person> people = new ArrayList<Person>();
        people.add(person);
        people.add(person);
        String s1 = objectMapper.writeValueAsString(people);
        //[{"age":11,"name":"xl","birthday":"2019:11:24"},{"age":11,"name":"xl","birthday":"2019:11:24"}]
        System.out.println(s1);  //{"age":11,"name":"xl"}

//        map=>object
        Map<String, Object> map = new Hashtable<String, Object>();
        map.put("name", "xl");
        map.put("age", 1);
        String s2 = objectMapper.writeValueAsString(map);
        System.out.println(s2);

        // 将java 对象转化为字符串 后  再将数据保存在目标 中
//        objectMapper.writeValue();

    }

    /**
     * jason 对象 转化为java对象
     *
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        String i = "{\"age\":11,\"name\":\"xl\",\"birthday\":\"2019:11:24\"}";
        ObjectMapper objectMapper = new ObjectMapper();

        Person person = objectMapper.readValue(i, Person.class);

        System.out.println(person);

    }

}
