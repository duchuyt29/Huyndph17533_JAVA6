package com.java6bai1.java6_bai1.app;


import com.java6bai1.java6_bai1.Bean.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
	static List<Student> list = Arrays.asList(
			new Student("Nguyễn Đức Huy", true, 8.0),
			new Student("Khổng Minh Thu", true, 8.5),
			new Student("Lê Cẩm Lệ", true, 7.5),
			new Student("Bùi Đức Lam", true, 9.5),
			new Student("Địch Lệ Nhật Ba", true, 6.5),
			new Student("ABC DEF", true, 4.5)
	);

	public static void main(String[] args) {
//	demo1();
//	demo2();
//	demo3();
	demo4();
}

private static void demo4() {
// Điểm trung bình
	double average = list.stream()
			.mapToDouble(sv -> sv.getMarks())
			.average().getAsDouble();
	System.out.println("mark average: " + average);

// Tổng điểm
	double sum = list.stream()
			.mapToDouble(sv -> sv.getMarks())
			.sum();
	System.out.println("mark total: " + sum);
	
// Điểm thấp nhất
	double min_mark = list.stream()
			.mapToDouble(sv -> sv.getMarks())
			.min().getAsDouble();
	System.out.println("mark min: "+ min_mark);
	
// Điểm của tất cả các sinh viên > 5 ????
	boolean all_passed = list.stream().allMatch(sv -> sv.getMarks() > 5);
	System.out.println("all_passed: "+ all_passed);
	
// Tìm sinh viên có điểm số thấp nhất
	Student min_sv = list.stream()
			.reduce(list.get(0), (min, sv) -> sv.getMarks() < min.getMarks()? sv: min);	
	System.out.println("min_sv: "+ min_sv);
}

private static void demo3() {
	List<Student> result = list.stream()
			.filter(sv -> sv.getMarks() >= 8)
			.peek(sv -> System.out.println(sv.getName().toUpperCase())) // không nhận gtri của toLowerCase() toUpperCase()
			.collect(Collectors.toList());
	
	result.forEach(sv -> {
		System.out.println(">>Name: " + sv.getName());
		System.out.println(">>Marks: " + sv.getMarks());
		System.out.println();
	});
	
}

private static void demo2() {
	List<Integer> list = Arrays.asList(1, 9, 4, 7, 2, 144);
	List<Double> result = list.stream()  //Stream <Integer>
				.filter(n -> n%2 == 0) // Stream <Integer>
				.map(n -> Math.sqrt(n)) // stream<Double>
				.peek(p -> System.out.println(p)) // stream<Double>
				.collect(Collectors.toList()); // List<Double>
}

private static void demo1() {
	Stream<Integer> stream1 = Stream.of(1, 9, 4, 7, 2);
	stream1.forEach(n -> {
		System.out.println(n);
	});
	System.out.println("stream \n");
	List<Integer> list = Arrays.asList(1, 9, 4, 7, 2);
//	Stream<Integer> stream2 = list.stream();
	list.stream().forEach(n -> {
		System.out.println(n);
	});
}
		
}
