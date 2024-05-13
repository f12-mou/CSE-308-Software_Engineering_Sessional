package com.company;

public class Developer implements Composite{
     String name;
     String role;
     String project;

    public Developer(String name, String project)
    {
        this.name = name;
        this.project = project;
        this.role = "Developer";
    }
    public void showDetails()
    {
    }

    @Override
    public void printStructures(int spaceCnt)
    {
        for(int i=0;i<spaceCnt;i++)
            System.out.print("  ");
        System.out.println("-   "+this.name);
    }
    @Override
    public void showPersonalDetails() {
        System.out.println();
        System.out.println("Developer_component.details():");
        System.out.println();
        System.out.println("Name: "+this.name);
        System.out.println("Role: "+this.role);
        System.out.println("Current Project: "+this.project);
        System.out.println();
    }

    @Override
    public int getEmployeeCount() {
        return 1;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void showdetails() {

    }

    @Override
    public void addEmployee(Composite c) {

    }

    @Override
    public void removeEmployee(Composite c) {

    }

    @Override
    public boolean searchChildren(String name) {
        return false;
    }

    @Override
    public Composite getComposite(int num) {
        return null;
    }

    @Override
    public void clear() {

    }
}
