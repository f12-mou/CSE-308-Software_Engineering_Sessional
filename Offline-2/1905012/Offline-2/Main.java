package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Mediator Pattern demonstrating with Exam Controlling System\n\n");

        Mediator controller= new Controller();

        Examiner examiner = new Examiner(controller, 1);
        Student students[] = new Student[5];

        for(int i=0;i<5;i++)
        {
            students[i] = new Student(controller, i+1);
        }

        controller.showParticipants();

        examiner.checkScripts(5);

        Scanner scanner = new Scanner(System.in);
        int StudentId, course, examinerId;

        while (true) {
            int option;
            System.out.println("Do you want to re-examine your script?");
            System.out.println("Option-1: YES");
            System.out.println("Option-2: NO");
            option = scanner.nextInt();
            if (option < 1 || option > 2) {
                System.out.println("Please enter correct option");
            } else if (option == 2) {
                break;
            } else {
                System.out.println("Please enter your Student ID: ");
                StudentId = scanner.nextInt();
                System.out.println("Please enter Course No: ");
                course = scanner.nextInt();
                System.out.println("Please enter Examiner ID: ");
                examinerId = scanner.nextInt();
                students[StudentId - 1].sendRequestToReExamine(course, examinerId);
            }
        }





    }
}
