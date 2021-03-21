package com.log.exec.distinct;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author pengmin
 * @date 2021/3/15 14:36
 */

public class Student implements Serializable {
    private String name;
    private Integer num;
    private String status;

    public Student(String name, Integer num) {
        this.name = name;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", num=" + num +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(num, student.num) &&
                Objects.equals(status, student.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, num, status);
    }

    public Student(String name, Integer num, String status) {
        this.name = name;
        this.num = num;
        this.status = status;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
