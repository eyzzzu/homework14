package com.homework;

public class Main {
    /*
Домашнее задание 14

Написать класс "Группа", для отображения учебной группы в Hillel, который содержит поля:
- название курса
- дата старта занятий
- суммарное количество занятий
- количество занятий в неделю
- список учащихся типа Person

Написать методы:
- метод который выдает название группы на основе даты старта и названия курса //java22may2019.slack.com     (+)
- метод который выдает дату старта последней недели курса                                                   (+)
- печатает список студентов с порядковыми номерами                                                          (+)
- добавить студента                                                                                         (+)
- узнать есть ли студент с такой фамилией в группе                                                          (+)
- удалить студента по фамилии или по номеру                                                                 (+)

1.2* У студента есть список групп в которых он учится.
При добавлении студента в группу у него прописывается эта группа в списке.                                  (-)
     */

    public static void main(String[] args) {

        Group java = new Group("Java", "22.05.2019",
                16, 2);
        System.out.println(java);
        DateClass.lastWeekDate(java);

        System.out.println();

        Group css = new Group("CSS", "13.07.2019",
                8, 2);
        System.out.println(css);
        DateClass.lastWeekDate(css);

        //java.addPersonList("Арчубальд", "Арчубальдовски");
        java.printStudentsList();
        java.removeFromStudentsListByIndex(0);
        java.printStudentsList();
        css.removeFromStudentsListByLastName("Гончар");
        css.printStudentsList();

        System.out.println("\n\r" + java.checkStudentsByLastName("Гончар", java));
        System.out.println("\n\r" + css.checkStudentsByLastName("Гончар", css));


    }
}
