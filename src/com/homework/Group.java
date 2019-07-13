package com.homework;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private String courseName;
    private String courseStartDate; // 05.05.2019 - Date format
    private String groupName;
    private int numberOfClasses;
    private int numberOfLessonsPerWeek;
    private List<Person> studentsList = new ArrayList<>();

    {
        studentsList.add(new Person("Владислав", "Заугольный"));
        studentsList.add(new Person("Андрей", "Киряхно"));
        studentsList.add(new Person("Дмитрий", "Лошкарев"));
        studentsList.add(new Person("Артур", "Кваде"));
        studentsList.add(new Person("Антон", "Щипицын"));
        studentsList.add(new Person("Сергей", "Гончар"));
        studentsList.add(new Person("Сергей", "Гаращенко"));
        studentsList.add(new Person("Максим", "Алексеев"));
        studentsList.add(new Person("Арсен", "Беденок"));
        studentsList.add(new Person("Андрей", "Фефелов"));
    }

    Group(String courseName, String courseStartDate, int numberOfClasses, int numberOfLessonsPerWeek) {
        this.courseName = courseName;
        this.courseStartDate = courseStartDate;
        this.numberOfClasses = numberOfClasses;
        this.numberOfLessonsPerWeek = numberOfLessonsPerWeek;
    }

    public int getWeeks() {
        int tmp = numberOfClasses - numberOfLessonsPerWeek;
        if (tmp == 0) {
            return 0;
        } else {
            return numberOfClasses / numberOfLessonsPerWeek;
        }
    }

    public String getCourseStartDate() {
        return courseStartDate;
    }

    public String getGroupName(String courseName) {
        groupName = courseName + DateClass.starCourseDate(Group.this);
        return groupName;
    }

    public void addPersonList(String firstName, String lastName) {
        studentsList.add(new Person(firstName, lastName));
    }

    public void printStudentsList() {
        System.out.println();
        for (int i = 0; i < studentsList.size(); i++) {
            System.out.println((i + 1) + " " + studentsList.get(i));
        }
    }

    public void removeFromStudentsListByIndex(int index) {
        studentsList.remove(index);
    }

    public void removeFromStudentsListByLastName(String lastName) {
        for (int i = 0; i < studentsList.size(); i++) {
            if (lastName.equals(studentsList.get(i).getLastName())) {
                studentsList.remove(i);
            }
        }

    }

    public String checkStudentsByLastName(String lastName, Group group) {
        boolean check = false;
        for (int i = 0; i < studentsList.size(); i++) {
            if (lastName.equals(studentsList.get(i).getLastName())) {
                check = true;
            }
        }
        if (check == true) {
            return group + "\n\r" + "В этой группе есть студент с такой фамилией.";
        } else {
            return group + "\n\r" + "В этой группе нет студента с такой фамилией!";
        }
    }

    @Override
    public String toString() {
        return "Group{" +
                "название курса = '" + courseName + '\'' +
                ", дата старта занятий = '" + courseStartDate + '\'' +
                ", название группы = '" + getGroupName(courseName) + '\'' +
                '}';
    }
}
