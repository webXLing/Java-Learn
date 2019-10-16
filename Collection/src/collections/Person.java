package collections;

import java.util.Objects;

public class Person implements Comparable {
    private String name;
    public int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 重写排序的规则
    @Override
    public int compareTo(Object o) {
//        return 0; // 认为元素都是相同的 、
//        自定义比较的规则  比较认的年龄
        Person person = (Person)o;

        return this.getAge() - person.getAge();// 年龄升序排序
    }
}
