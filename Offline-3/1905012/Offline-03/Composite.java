package com.company;

public interface Composite {
    void printStructures(int spaceCnt);
    int getEmployeeCount();
    String getName();
    void showdetails();
    void showPersonalDetails();
    void addEmployee(Composite c);
    void removeEmployee(Composite c);
    boolean searchChildren(String name);
    Composite getComposite(int num);
    void clear();

}
