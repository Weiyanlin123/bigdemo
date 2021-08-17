
package com.city.stream;

import com.citycloud.dcm.street.param.Person;
import lombok.Data;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

@Data
public class Student {

    //唯一
    private String id;

    private String name;

    private Integer score;

    private String classmame;

    private String province;

    private String city;

    private String star;

    public Student(String id, String name, Integer score, String classmame, String province, String city) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.classmame = classmame;
        this.province = province;
        this.city = city;
    }

    public Student() {
    }

    public static void main(String[] args) {

         String ff="123,234,456";
         String ff2="2345,456,";

        String format = String.format("%06d", 11);

        System.out.println(format);

        System.out.println("+++++++++++++++++++++="+ff.contains(ff2));

        List listone = new ArrayList();
        listone.add("AHRG");
        listone.add("BHRC");
        listone.add("WHRA");
        listone.add("TEMA");
        listone.add("TEMD");

        List  listt= new ArrayList();
        listt.add("aaaa");
        boolean disjoint = Collections.disjoint(listone, listt);
        System.out.println("==============="+disjoint);//false

        Student s1 = new Student("20190001", "小A", 80, "初三", "河南", "商丘");
        Student s2 = new Student("20190002", "B", 70, "初三", "河南", "商丘");
        Student s3 = new Student("20190003", "C", 60, "初三", "河北", "濮阳");
        Student s4 = new Student("20190004", "D", 10, "初三", "河南", "濮阳");
        Student s5 = new Student("20190005", "E", 40, "初三", "河南", "安阳");
        Student s6 = new Student("20190006", "F", 30, "初三", "河南", "安阳");
        Student s7 = new Student("20190007", "F", 30, "初三", "河北", "安阳");
        ArrayList<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        list.add(s6);
        list.add(s7);
        Double collect = list.stream().filter(st -> st.getProvince() == "河南").collect(Collectors.averagingInt(Student::getScore));

        List<Student> collect8 = list.stream().filter(st -> (!(st.getProvince() != "河南") &&( st.getCity()!="濮阳"))).collect(Collectors.toList());
        System.out.println("过滤条件++++++++++"+collect8);


        List<Student> collect10 = list.stream().sorted(Comparator.comparing(Student::getScore).thenComparing(Student::getId)).collect(Collectors.toList());
        System.out.println("排序操作连续排名+++++++++============++++======"+collect10);


        //分组
        Map<String, IntSummaryStatistics> collect1 = list.stream().filter(st -> st.getProvince() == "河南").collect(Collectors.groupingBy(Student::getCity, Collectors.summarizingInt(Student::getScore)));


        Map<String, List<Student>> collect4 = list.stream().collect(Collectors.groupingBy(Student::getCity));


        List<Student> collect6 = list.stream().sorted(Comparator.comparing(Student::getScore)).collect(Collectors.toList());

        //userList.sort(Comparator.comparing(User::getId).thenComparing(User::getAge));
        System.out.println("排序降序++++++"+collect6);
        List<Student> collect7 = list.stream().sorted(Comparator.comparing(Student::getScore).reversed()).collect(Collectors.toList());

        System.out.println("排序升序++++++"+collect7);

        System.out.println("最大值"+collect1.get("安阳").getMax());
        System.out.println(collect4.get("安阳"));
        System.out.println("&&&&&&&&"+collect4);


        Optional<Student> reduce = list.stream().reduce((t1, t2) -> t1.getScore() > t2.getScore() ? t1 : t2);

        System.out.println("reduce find max score"+ reduce.get());

        int sum = list.stream().mapToInt(s -> s.getScore()).sum();


        System.out.println("mapToint 求和"+sum);


        List<Student> collect2 = list.stream().filter(st -> st.getProvince() == "河南").collect(Collectors.toList());
        list.stream().filter(st -> st.getProvince().equals("河南")).distinct().map(st -> st.getScore() + 1).collect(Collectors.toList()).forEach(e -> System.out.println(e));

        List<Integer> aaa = list.stream().filter(st -> st.getProvince().equals("河南")).distinct().map(st -> st.getScore() + 1).collect(Collectors.toList());

        System.out.println(aaa);
        //  List<Student> collect3 = list.stream().filter(st -> st.getProvince() == "河南").sorted(Comparator.comparing(Student::getScore).reversed()).collect(Collectors.toList());


        // System.out.println(collect3);
//        System.out.println(collect2);
//        List<Map<String, Object>> maps = new ArrayList<>();
//        HashMap<String, Object> map1 = new HashMap<>();
//        map1.put("aaa",1);
//        map1.put("bbb",2);
//        HashMap<String, Object> map2 = new HashMap<>();
//        map2.put("aaa",111);
//        map2.put("bbb",222);
//        maps.add(map2);
//        maps.add(map1);
//        List<Map<String, Object>> aaa = maps.stream().filter(st -> st.get("aaa").equals(111)).collect(Collectors.toList());


        List<Student> classOneStudents = new ArrayList<>();
        List<Student> classTwoStudents = new ArrayList<>();
        List<Student> classThreeStudents = new ArrayList<>();
        List<List<Student>> students = new ArrayList<>();

        classOneStudents.add(new Student("20190001", "AA", 80, "classOne", "河南", "商丘"));
        classOneStudents.add(new Student("20190002", "小A", 70, "classOne", "河南", "商丘"));
        classOneStudents.add(new Student("20190003", "小B", 60, "classOne", "河南", "商丘"));
        classOneStudents.add(new Student("20190004", "小C", 50, "classOne", "河南", "商丘"));

        classTwoStudents.add(new Student("20190001", "小D", 90, "classTwoStudents", "河南", "商丘"));
        classTwoStudents.add(new Student("20190005", "小E", 90, "classTwoStudents", "河南", "商丘"));
        classTwoStudents.add(new Student("20190006", "小F", 80, "classTwoStudents", "河南", "商丘"));

        classThreeStudents.add(new Student("20190001", "小G", 70, "初三", "河南", "商丘"));
        classThreeStudents.add(new Student("20190001", "小H", 80, "初三", "河南", "商丘"));
        students.add(classOneStudents);
        students.add(classTwoStudents);
        students.add(classThreeStudents);



        Stream<List<Student>> listStream = Stream.of(classOneStudents, classTwoStudents);

        boolean b = classThreeStudents.stream().allMatch(e -> e.getScore() > 60);

        Collector<Student, ?, Double> studentDoubleCollector = Collectors.averagingInt(Student::getScore);
        List<Double> collect5 = DoubleStream.of(1.0, 2.0, 3.0).collect(ArrayList<Double>::new, ArrayList::add, ArrayList::addAll);
        System.out.println(collect5);

        System.out.println("校验所有元素是否匹配大于80"+b);

        /**
         *
         */
        listStream.flatMap(e->classThreeStudents.stream()).collect(Collectors.toList()).forEach(m-> System.out.println(m));


        /**
         * flatmap 出入的参数必须是 stream
         * map 是收集一个个元素的
         */
        List<Student> collect3 = classOneStudents.stream().flatMap(one -> classTwoStudents.stream().filter(two -> two.getId().equals(one.getId())).map(s -> {
            Student student = new Student();
            student.setId(s.getId());
            student.setName(one.getName());
            student.setClassmame(s.getClassmame());
            return student;
        })).collect(Collectors.toList());

        System.out.println(collect3);

        //5 flatMap 把Stream中的层级结构扁平化并返回Stream
        List<Student> studentList = students
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        //展开多个List合并到一个新list

        System.out.println("======================================================");
         studentList.stream().forEach(System.out::println);
        // System.out.println(students);


        Student student = new Student();

        ArrayList<Student> st = new ArrayList<>();

        List<Student> collect9 = st.stream().filter(e -> e.getScore() == 90).collect(Collectors.toList());

        System.out.println("++++++++++++++"+collect9);
        st=null;
        //st.add(student);
        st.forEach(e->{
            System.out.println("111111111111111111111111111111111");
        });

    }




}