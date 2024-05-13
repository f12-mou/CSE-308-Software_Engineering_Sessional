package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SoftwareCompany implements Composite{

    private String name;
    private int total_projects;
    int employeeCount;
    List<Composite> controls;

    public SoftwareCompany(String name) {
        this.name=name;
        employeeCount=0;
        this.controls = new ArrayList<Composite>();
    }


    @Override
    public void printStructures(int spaceCnt) {
        for(int i=0;i<spaceCnt;i++)
            System.out.print("  ");
        System.out.println("-   "+this.name);
        for(Composite c:controls)
        {
            c.printStructures(spaceCnt+1);
        }
    }


    @Override
    public int getEmployeeCount() {
        int total=0;
        for(Composite c:controls)
        {
            total+=c.getEmployeeCount();
        }
        return total;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void showdetails() {
        if(controls.size()>0) {
            System.out.println("Currently the Project Managers in " + this.name + " are: ");
            for (Composite c : controls) {
                System.out.println("    -   " + c.getName());
            }
            System.out.println();
        }

    }
    @Override
    public void showPersonalDetails() {
        System.out.println("Welcome to "+this.name+" company");
        if(controls.isEmpty()==true)
        {
            System.out.println("Currently there are no projects.");
        }
        else
        {
            System.out.println("Currently there are "+controls.size()+" projects running.");
            System.out.println("Total employees: "+this.getEmployeeCount());
        }
    }

    @Override
    public void addEmployee(Composite c) {
        controls.add(c);
    }

    @Override
    public void removeEmployee(Composite c) {
        c.clear();
        System.out.println(c.getName()+" is removed");
        controls.remove(c);
    }

    @Override
    public boolean searchChildren(String name) {
        Boolean found = false;
        for(Composite c:controls)
        {
            if(name.equalsIgnoreCase(c.getName()))
            {
                found=true; break;
            }
        }
        return found;
    }

    @Override
    public Composite getComposite(int num) {
        if(controls.isEmpty()==true)
        {
            return null;
        }
        if(controls.size()<num)
            return null;
        return controls.get(num-1);
    }

    @Override
    public void clear() {
        List<Composite>to_be_removed=new ArrayList<Composite>();
        for(Composite c:controls)
        {
            c.clear();
            System.out.println("The manager named "+c.getName()+" is removed.");
            //controls.remove(c);
            to_be_removed.add(c);
        }
        for(Composite now:to_be_removed)
        {
            controls.remove(now);
        }
    }

}
