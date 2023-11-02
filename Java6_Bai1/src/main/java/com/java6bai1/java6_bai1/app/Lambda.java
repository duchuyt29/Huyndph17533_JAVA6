package com.java6bai1.java6_bai1.app;

import com.java6bai1.java6_bai1.Bean.Student;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lambda {
    public static void main(String[] args) {
//        demo1();
//        demo2();
//        demo3();
        demo4();
    }

    private static void demo4() {
        // cách viết truyền thống
//        Demo4inter o = new Demo4inter() {
//            @Override
//            public void m1(int x) {
//                System.out.println(x);
//            }
//        };
//        o.m1(2021);

        // Viết bằng Lambda
        Demo4inter o = x -> System.out.println(x);
        o.m1(2021);
    }

    static List<Student> list = Arrays.asList(
            new Student("Nguyễn Đức Huy", true, 7.5),
            new Student("Khổng Minh Thu", true, 7.5),
            new Student("Lê Cẩm Lệ", true, 7.5),
            new Student("Bùi Đức Lam", true, 9.5),
            new Student("Địch Lệ Nhật Ba", true, 8.5)
    );

    private static void demo3() {
        // dấu trừ là giảm : -sv1
        // không dấu trừ là tăng : sv1
        Collections.sort(list, (sv1, sv2) -> -sv1.getMarks().compareTo(sv2.getMarks()));
        list.forEach(sv ->{
            System.out.println(">> Name: " + sv.getName());
            System.out.println(">> Marks: " + sv.getMarks());
            System.out.println();
        });
    }

    private static void demo2() {
        list.forEach(sv ->{
            System.out.println(">> Name: " + sv.getName());
            System.out.println(">> Marks: " + sv.getMarks());
            System.out.println();
        });

    }


    private static void demo1() {
        List<Integer> list = Arrays.asList(1, 8, 5, 6, 9, 3);
        list.forEach(n -> System.out.println(n));
    }
}

@FunctionalInterface
interface Demo4inter{
    void m1(int x);
    default void m2() {}
    public static void m3() {}
}
