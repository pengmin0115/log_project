package com.log.exec.distinct;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author pengmin
 * @date 2021/3/15 14:37
 */

public class DistinctList {

    private static ArrayList<Student> sources = new ArrayList<>();

    static {
        sources.add(new Student("zs", 123));
        sources.add(new Student("zs", 123));
        sources.add(new Student("ls", 123));
        sources.add(new Student("ww", 123));
        sources.add(new Student("zl", 188));
        sources.add(new Student("xx", 123));
        sources.add(new Student("yy", 188));
        sources.add(new Student("apple", 211));
    }

    public static void main(String[] args) {
        /**
         * stream处理;
         */
        Map<Integer, List<Student>> map = sources.stream().distinct().collect(Collectors.groupingBy(Student::getNum));
        Iterator<Map.Entry<Integer, List<Student>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, List<Student>> entry = iterator.next();
            List<Student> list = entry.getValue();
            if (list.size() > 1) {
                list.stream().forEach(student -> student.setStatus("3"));
            }
        }
        System.out.println("end...");

        /*ArrayList<Student> duplicateList = new ArrayList<>();
        for (int i = 0; i < sources.size(); i++) {
            for (int j = sources.size() - 1; j > i; j--) {
                if (sources.get(i).getNum().equals(sources.get(j).getNum())) {
                    duplicateList.add(sources.get(j));
                }
                duplicateList.add(sources.get(i));
            }
        }

        for (Student student : duplicateList) {
            System.out.println(student);
        }
        System.out.println("================");
        ArrayList<Student> result = duplicateList.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
        result.stream().forEach(student -> student.setStatus("3"));
        for (Student student : result) {
            System.out.println(student);
        }*/

        /*TreeMap<Integer, ArrayList<Student>> map = new TreeMap<>();
        for (int i = 0; i < sources.size(); i++) {
            Student student = sources.get(i);
            if (map.containsKey(student.getNum())) {
                ArrayList<Student> list = map.get(student.getNum());
                list.add(student);
            } else {
                ArrayList<Student>list = new ArrayList<>();
                list.add(student);
                map.put(student.getNum(), list);
            }
        }
        Iterator<Map.Entry<Integer, ArrayList<Student>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, ArrayList<Student>> entry = iterator.next();
            ArrayList<Student> list = entry.getValue();
            if (list.size()>1){
                list.stream().distinct().forEach(student -> student.setStatus("3"));
            }
        }
        // 遍历;
        Iterator<Map.Entry<Integer, ArrayList<Student>>> entryIterator = map.entrySet().iterator();
        while (entryIterator.hasNext()){
            entryIterator.next().getValue().stream().forEach(student -> System.out.println(student));
        }*/
    }
}
