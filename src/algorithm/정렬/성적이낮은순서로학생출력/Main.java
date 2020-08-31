package algorithm.정렬.성적이낮은순서로학생출력;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static class Student implements Comparable<Student>{
        private String name;
        private int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        @Override
        public int compareTo(Student other) {
            return Integer.compare(this.score, other.score);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] students = new Student[n];
        for(int i = 0; i < n; i ++) {
            String name = sc.next();
            int score = sc.nextInt();
            students[i] = new Student(name, score);
        }
        Arrays.sort(students);
        for(int i = 0; i < n; i ++) {
            System.out.print(students[i].getName() + " ");
        }

    }
}
