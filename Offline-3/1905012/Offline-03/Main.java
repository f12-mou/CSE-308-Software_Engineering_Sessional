package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
	// write your code here
        Composite root=new Root("System");

        Composite soft1=new SoftwareCompany("Manhattan Company");
        Composite manager1 = new ProjectManager("Alan Turing","CSE308");
        Composite dev1=new Developer("Robert Oppenheimer","CSE308");
        Composite dev2=new Developer("John von Neumann","CSE308");


        Composite manager2 = new ProjectManager("David Patterson","CSE307");
        Composite dev3=new Developer("Alfred Aho","CSE307");

        manager2.addEmployee(dev3);


        manager1.addEmployee(dev1);
        manager1.addEmployee(dev2);
        soft1.addEmployee(manager1);
        soft1.addEmployee(manager2);


        root.addEmployee(soft1);
        root.printStructures(1);

        while(true)
        {
            Scanner scanner = new Scanner(System.in);
            int option1, option2,option3;
            String name=null;
            String project=null;
            System.out.println("Enter an Option:");
            System.out.println("    Option-1: Add");
            System.out.println("    Option-2: Remove");
            System.out.println("    Option-3: Show Hierarchy");
            System.out.println("    Option-4: Show Details");
            option1=scanner.nextInt();
            if(option1==1)
            {
                System.out.println("What do you want to add?");
                System.out.println("    Option-1: Software Company");
                System.out.println("    Option-2: Project Manager");
                System.out.println("    Option-3: Developer");
                option2 = scanner.nextInt();
                if(option2==1)
                {
                    root.showdetails();
                    System.out.println("Enter the name of software company.");
                    name=scanner.next();
                    if(root.searchChildren(name)==true){
                        System.out.println("Sorry, two companies can't have same name.");
                    }
                    else
                    {
                        System.out.println("Software Company named "+name+" added successfully.");
                        Composite c=new SoftwareCompany(name);
                        root.addEmployee(c);
                    }
                }
                else if(option2==2)
                {
                    root.showdetails();
                    System.out.println("In which company do you want to add a Project Manager?");
                    int companyNo=scanner.nextInt();
                    Composite softwareCompanyNow = root.getComposite(companyNo);

                    softwareCompanyNow.showdetails();

                    System.out.println("Enter the name of Project Manager.");
                    name=scanner.next();

                    if(softwareCompanyNow.searchChildren(name)==true){
                        System.out.println("Sorry, two project managers under same company can't have same name.");
                    }
                    else
                    {
                        System.out.println("Enter the name of Project.");
                        project=scanner.next();
                        System.out.println("Project Manager named "+name+" added successfully.");
                        Composite c=new ProjectManager(name,project);
                        softwareCompanyNow.addEmployee(c);
                    }
                }
                else if(option2==3)
                {
                    root.showdetails();
                    System.out.println("In which company do you want to add a Developer?");
                    int companyNo=scanner.nextInt();
                    Composite softwareCompanyNow = root.getComposite(companyNo);



                    Composite managerNow=softwareCompanyNow.getComposite(1);
                    if(managerNow==null)
                    {
                        System.out.println("Add a manager first.");
                    }
                    else
                    {
                        softwareCompanyNow.showdetails();
                        System.out.println("Under which Project Manager do you want to add a Developer?");
                        int managerNo=scanner.nextInt();
                         managerNow = softwareCompanyNow.getComposite(managerNo);

                        System.out.println("Enter the name of the Developer.");
                        name = scanner.next();

                        if (managerNow.searchChildren(name) == true) {
                            System.out.println("Sorry, two developers under the same manager can't have same name.");
                        } else {
                            System.out.println("Enter the name of Project.");
                            project = scanner.next();
                            System.out.println("Developer named " + name + " added successfully.");
                            Composite c = new Developer(name, project);
                            managerNow.addEmployee(c);
                        }
                    }
                }
                else
                {
                    System.out.println("Please enter correct option.");
                }
            }
            else if(option1==2)
            {
                System.out.println("What do you want to remove?");
                System.out.println("    Option-1: Software Company");
                System.out.println("    Option-2: Project Manager");
                System.out.println("    Option-3: Developer");
                option2 = scanner.nextInt();
                if(option2==1)
                {
                    root.showdetails();
                    System.out.println("Enter the name of software company you want to remove");
                    option3=scanner.nextInt();
                    Composite c = root.getComposite(option3);
                    root.removeEmployee(c);
                }
                else if(option2==2)
                {
                    root.showdetails();
                    System.out.println("From which company do you want to remove a Project Manager?");
                    int companyNo=scanner.nextInt();
                    Composite softwareCompanyNow = root.getComposite(companyNo);

                    softwareCompanyNow.showdetails();

                    System.out.println("Enter the name of Project Manager you want to remove");
                    option3=scanner.nextInt();
                    Composite c = softwareCompanyNow.getComposite(option3);
                    softwareCompanyNow.removeEmployee(c);

                }
                else if(option2==3)
                {
                    root.showdetails();

                    System.out.println("From which company do you want to remove a Developer?");
                    int companyNo=scanner.nextInt();
                    Composite softwareCompanyNow = root.getComposite(companyNo);

                    softwareCompanyNow.showdetails();

                    System.out.println("Enter the name of Project Manager under whom you want to remove a developer.");
                    option3=scanner.nextInt();
                    Composite managernow = softwareCompanyNow.getComposite(option3);

                    managernow.showdetails();

                    System.out.println("Enter the name of the developer you want to remove");
                    option3=scanner.nextInt();
                    Composite to_be_bye = managernow.getComposite(option3);
                    managernow.removeEmployee(to_be_bye);
                }
                else
                {
                    System.out.println("Please enter correct option.");
                }

            }
            else if(option1==3)
            {
                //root.printStructures(1);
                System.out.println("Which structure you want to see?");
                System.out.println("    Option-1: Root");
                System.out.println("    Option-2: Software Company");
                System.out.println("    Option-3: Project Manager");

                option2 = scanner.nextInt();
                if(option2==1)
                {
                    root.printStructures(1);
                }
                else if(option2==2)
                {
                    root.showdetails();
                    System.out.println("Which company do you want to see?");
                    int companyNo=scanner.nextInt();
                    Composite softwareCompanyNow = root.getComposite(companyNo);
                    softwareCompanyNow.printStructures(1);
                }
                else if(option2==3)
                {

                    root.showdetails();
                    System.out.println("Under which company do you want to see a manager?");
                    int companyNo=scanner.nextInt();
                    Composite softwareCompanyNow = root.getComposite(companyNo);

                    softwareCompanyNow.showdetails();
                    System.out.println("Which manager do you want to see?");
                    int managerNo=scanner.nextInt();
                    Composite managerNow = softwareCompanyNow.getComposite(managerNo);

                    managerNow.printStructures(1);
                }
                else
                {
                    System.out.println("Please enter correct option.");
                }
            }
            else if(option1==4)
            {
                System.out.println("Which one you want to see?");
                System.out.println("    Option-1: Root");
                System.out.println("    Option-2: Software Company");
                System.out.println("    Option-3: Project Manager");
                System.out.println("    Option-4: Developer");

                option2 = scanner.nextInt();
                if(option2==1)
                {
                    if(root.getEmployeeCount()>0) {
                        root.showPersonalDetails();
                    }
                    else
                    {
                        System.out.println("There are no companies now.");
                    }
                }
                else if(option2==2)
                {
                    if(root.getEmployeeCount()>0) {
                        root.showdetails();
                        System.out.println("Which company do you want to see?");
                        int companyNo=scanner.nextInt();
                        Composite softwareCompanyNow = root.getComposite(companyNo);
                        softwareCompanyNow.showPersonalDetails();
                    }
                    else
                    {
                        System.out.println("There are no companies now.");
                    }

                }
                else if(option2==3)
                {
                    if(root.getEmployeeCount()>0) {
                        root.showdetails();
                        System.out.println("Under which company do you want to see a manager?");
                        int companyNo = scanner.nextInt();
                        Composite softwareCompanyNow = root.getComposite(companyNo);

                        softwareCompanyNow.showdetails();
                        if(softwareCompanyNow.getEmployeeCount()>0) {
                            System.out.println("Which manager do you want to see?");
                            int managerNo = scanner.nextInt();
                            Composite managerNow = softwareCompanyNow.getComposite(managerNo);

                            managerNow.showPersonalDetails();
                        }
                        else
                        {
                            System.out.println("There are no managers now.");
                        }
                    }else{
                        System.out.println("There are no companies now.");
                    }
                }
                else if(option2==4)
                {
                    if(root.getEmployeeCount()>0) {
                        root.showdetails();
                        System.out.println("Under which company do you want to see a developer?");
                        int companyNo = scanner.nextInt();
                        Composite softwareCompanyNow = root.getComposite(companyNo);

                        softwareCompanyNow.showdetails();

                        if(softwareCompanyNow.getEmployeeCount()>0) {

                            System.out.println("Under which manager do you want to see a developer?");
                            int managerNo = scanner.nextInt();
                            Composite managerNow = softwareCompanyNow.getComposite(managerNo);

                            managerNow.showdetails();
                            if (managerNow.getEmployeeCount() > 0) {

                                System.out.println("Which developer do you want to see?");
                                int devNo = scanner.nextInt();
                                Composite devNow = managerNow.getComposite(devNo);

                                devNow.showPersonalDetails();
                            } else {
                                System.out.println("There are no developers curently.");
                            }
                        }
                        else
                        {
                            System.out.println("There are no managers now.");
                        }
                    }
                    else
                    {
                        System.out.println("There are no companies now.");
                    }

                }
                else
                {
                    System.out.println("Please enter correct option.");
                }

            }
            else
            {
                System.out.println("Please enter correct option.");
            }

        }
    }
}
