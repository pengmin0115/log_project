package com.log.jdk8;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author pengmin
 * @date 2021/2/24 17:18
 * <p>
 * <p>
 * Stream流式变成处理集合;
 */

public class StreamProgram implements Serializable {

    private static List<Employee> employeeList = new ArrayList<>();

    static {
        /**
         * 将set方法的返回值改为Employee,即可使用流式编程的方式进行赋值;
         */
        employeeList.add(new Employee().setId(1).setAge(20).setName("zhangsan").setEnterTime(new Date()).setAddress("shenzhen"));
        employeeList.add(new Employee().setId(2).setAge(20).setName("lisi").setEnterTime(new Date()).setAddress("shenzhen"));
        employeeList.add(new Employee().setId(3).setAge(20).setName("micky").setEnterTime(new Date()).setAddress("shenzhen"));
    }

    public static void main(String[] args) {

        /**
         * Stream流处理JAVA集合;
         */

        /**
         * 1. 根据ID查询员工信息;
         */
        Employee employee1 = employeeList.stream().filter(employee -> employee.getId().equals(1)).findFirst().get();
        System.out.println(employee1);

        /**
         * 查询集合中是否包含ID为3的员工;
         */
        System.out.println(employeeList.stream().anyMatch(employee -> employee.getId().equals(1)));

        /**
         * 查询ID大于2的员工;
         */
        System.out.println(employeeList.stream().filter(employee -> employee.getId() > 2).collect(Collectors.toList()));

        /**
         * 查询所有人的名字
         */
        System.out.println(employeeList.stream().map(employee -> employee.getName()).collect(Collectors.toList()));


        // 使用Collectors.joining()拼接字符串
        Stream<String> stream = Stream.of("I", "love", "you");
        // "Iloveyou"
        //String joined = stream.collect(Collectors.joining());
        // "I,love,you"
        //String joined = stream.collect(Collectors.joining(","));
        // "{I,love,you}"
        String joined = stream.collect(Collectors.joining(",", "{", "}"));
        System.out.println(joined);

    }

    private static class Employee implements Serializable {

        private Integer id;
        private String name;
        private int age;
        private String address;
        private Date enterTime;

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", address='" + address + '\'' +
                    ", enterTime=" + enterTime +
                    '}';
        }

        public Employee() {
        }

        public Employee(Integer id, String name, int age, String address, Date enterTime) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.address = address;
            this.enterTime = enterTime;
        }

        public Integer getId() {
            return id;
        }

        public Employee setId(Integer id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public Employee setName(String name) {
            this.name = name;
            return this;
        }

        public int getAge() {
            return age;
        }

        public Employee setAge(int age) {
            this.age = age;
            return this;
        }

        public String getAddress() {
            return address;
        }

        public Employee setAddress(String address) {
            this.address = address;
            return this;
        }

        public Date getEnterTime() {
            return enterTime;
        }

        public Employee setEnterTime(Date enterTime) {
            this.enterTime = enterTime;
            return this;
        }
    }
}
