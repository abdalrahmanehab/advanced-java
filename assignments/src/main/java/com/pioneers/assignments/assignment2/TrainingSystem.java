package com.pioneers.assignments.assignment2;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TrainingSystem {
    final static Map<Integer,Student> studentMap = new HashMap<>();

    public static void addStudent(Integer key , Student student){
        studentMap.put(key,student);
    }

    public static void dropStudent(Integer key){
        studentMap.remove(key);
    }


    public static void printEnrolledCourses (Student st ) {
        final Set<Course> studentCourses = st.getEnrolledCourses();
        System.out.println(st.getName()+ "'s Registered courses : ");
        studentCourses.forEach(System.out::println);
    }

    public static Student studentHighest (){
        Student topStudent = null;
        int maxNum = -1;

        for(Student st : studentMap.values()){
            if (st.getCoursesNumber() > maxNum) {
                maxNum = st.getCoursesNumber();
                topStudent = st;
            }
        }
        return topStudent;
    }

    public static void main(String []args) {
        Course java = new Course(1, "java");
        Course DSA = new Course(2, "Data structures");
        Course Math3 = new Course(3, "Math 3");

        Student student1 = new Student("Abdalrahman", 101);
        Student student2 = new Student("Basma", 102);

        addStudent(student1.getId(), student1);
        addStudent(student2.getId(), student2);


        student1.enrollCourse(java);
        student1.enrollCourse(DSA);
        student1.enrollCourse(Math3);
        student2.enrollCourse(java);

        printEnrolledCourses(student1);
        printEnrolledCourses(student2);

        System.out.println("Top student : " + studentHighest());


    }

}
