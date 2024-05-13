package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProjectManager implements Composite{
     String name;
     String role;
     public String project;
     int employeeCount;
     List<Composite> controls;

    public ProjectManager(String name, String project) {
        this.name=name;
        this.role="Project Manager";
        this.project=project;
        employeeCount=0;
        this.controls = new ArrayList<Composite>();
    }


    public void showDetails()
    {

        System.out.println();
        System.out.println("Project_manager_component.details():");
        System.out.println();
        System.out.println("Name: "+this.name);
        System.out.println("Role: "+this.role);
        System.out.println("Current Project: "+this.project);
        System.out.println("Number of Supervises: "+controls.size());
        System.out.println();
    }

    @Override
    public void showPersonalDetails() {
        System.out.println("Project Manager: "+this.name);
        System.out.println("Running Project name: "+this.project);
        if(controls.isEmpty()==true)
        {
            System.out.println("Currently there are no developers under the project manager");
        }
        else
        {
            System.out.println("Currently there are "+controls.size()+" developers.");
            System.out.println("Total employees: "+this.getEmployeeCount());
        }
    }

    @Override
    public void printStructures(int spaceCnt) {
        for(int i=0;i<spaceCnt;i++)
            System.out.print("  ");
        System.out.println("-   "+this.name+" ("+this.project+")");
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
        return total+1;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void showdetails() {
        if(controls.isEmpty()==false) {
            System.out.println("Currently the developers under " + this.name + " in the system are:");
            for (Composite c : controls) {
                System.out.println("    -   " + c.getName());
            }
            System.out.println();
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
            System.out.println("The developer named "+c.getName()+" is removed.");
            //controls.remove(c);
            to_be_removed.add(c);
        }
        for(Composite now:to_be_removed)
        {
            controls.remove(now);
        }
    }
}

