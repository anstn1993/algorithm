package algorithm.정렬.국영수;

import java.util.Arrays;
import java.util.Scanner;

class Student implements Comparable<Student> {
    String name;
    int korea;
    int english;
    int math;

    public Student(String name, int korea, int english, int math) {
        this.name = name;
        this.korea = korea;
        this.english = english;
        this.math = math;
    }

    public String getName() {
        return name;
    }

    public int getKorea() {
        return korea;
    }

    public int getEnglish() {
        return english;
    }

    public int getMath() {
        return math;
    }

    @Override
    public int compareTo(Student o2) {
        if (this.korea < o2.korea) {
            return 1;
        } else if (this.korea > o2.korea) {
            return -1;
        } else {
            if (this.english < o2.english) {
                return -1;
            } else if (this.english > o2.english) {
                return 1;
            } else {
                if (this.math < o2.math) {
                    return 1;
                } else if (this.math > o2.math) {
                    return -1;
                } else {
                    char[] name1 = this.name.toCharArray();
                    char[] name2 = o2.name.toCharArray();
                    for (int i = 0; i < (name1.length < name2.length ? name1.length : name2.length); i++) {
                        if(name1[i] < name2[i]) {
                            return -1;
                        }
                        else if(name1[i] > name2[i]) {
                            return 1;
                        }
                    }
                }
            }
        }
        return 0;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] students = new Student[n];
        for(int i = 0; i < n; i ++) {
            String name = sc.next();
            int korea = sc.nextInt();
            int english = sc.nextInt();
            int math = sc.nextInt();
            students[i] = new Student(name, korea, english, math);
        }

        Arrays.sort(students);
        for(int i = 0; i < n; i ++) {
            System.out.println(students[i].getName());
        }
    }
}
