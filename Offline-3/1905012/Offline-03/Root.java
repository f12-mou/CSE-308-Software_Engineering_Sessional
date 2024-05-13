package com.company;

import java.util.ArrayList;
import java.util.List;

public class Root implements  Composite{
    String name;
    List<Composite> controls;
    int employeeCount;

    public Root(String name) {
        this.controls = new ArrayList<Composite>();
        employeeCount=0;
        this.name=name;
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
        return null;
    }

    @Override
    public void showdetails() {
        System.out.println("Currently the Software Companies in the system are:");
        for(Composite c : controls)
        {
            System.out.println("    -   "+c.getName());
        }
        System.out.println();
    }

    @Override
    public void showPersonalDetails() {
        System.out.println("Welcome to the software companies");
        if(controls.isEmpty()==true)
        {
            System.out.println("Currently there are no software companies.");
        }
        else
        {
            System.out.println("Currently there are "+controls.size()+" companies");
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
        System.out.println("The company named "+c.getName()+" is removed");
        controls.remove(c);
    }

    @Override
    public boolean searchChildren(String name) {
        boolean found = false;
        for(Composite c:controls)
        {
            if(c.getName().equalsIgnoreCase(name))
            {
                found=true;
                break;
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
            System.out.println(c.getName()+" is removed.");
            //controls.remove(c);
            to_be_removed.add(c);
        }
        for(Composite now:to_be_removed)
        {
            controls.remove(now);
        }
    }
}
