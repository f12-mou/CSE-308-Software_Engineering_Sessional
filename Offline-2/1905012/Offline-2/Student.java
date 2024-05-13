package com.company;

public class Student {
    int id;
    Mediator mediator;

    public Student(Mediator mediator, int id)
    {
        this.id = id;
        this.mediator = mediator;
        addToControllerList();
    }
    private void addToControllerList()
    {
        mediator.register(this);
    }
    public void notify(int courseNo, double mark)
    {
        System.out.println();
        System.out.println("Student ID: "+id+" has got his/her result.");
        System.out.println("Course No: "+courseNo+" Obtained Mark: "+mark);
        System.out.println();
    }
    public void sendRequestToReExamine(int courseId, int examinerId)
    {
        System.out.println();
        System.out.println("In Student Class: Request sent to Exam Controller Office to re-examine script.");
        System.out.println("Student ID: "+id);
        System.out.println("Course No: "+courseId);
        mediator.getRequestToReExamine(courseId, id, examinerId);
    }
}
