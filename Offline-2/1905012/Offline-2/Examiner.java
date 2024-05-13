package com.company;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Examiner {
    int id;
    Mediator mediator;

    public Examiner(Mediator mediator, int id)
    {
        this.id = id;
        this.mediator = mediator;
        addToControllerList();
    }
    void addToControllerList()
    {
        mediator.register(this);
    }
    void checkScripts(int count)
    {
        System.out.println("From Examiner "+ id);
        System.out.println();
        System.out.println(".............");
        System.out.println();

        Script scripts[]=new Script[count];
        for(int i=0;i<count;i++)
        {
            int mark = (int)(Math.random()*(100-0+1));
            scripts[i] = new Script(404, i+1, mark);
        }

        Random rand = new Random();


        List<Double>markSheet=new ArrayList<Double>();
        for (int i=0;i<count;i++)
        {
            int luck = rand.nextInt(1000);
            if(luck % 2 == 1)
            {
                markSheet.add(scripts[i].markObtained - 5);
            }
            else
            {
                markSheet.add(scripts[i].markObtained);
            }
        }
        System.out.println("The scripts are checked.");
        System.out.println("The scripts are sent to controller office for publishing result.");
        System.out.println();
        sendToControllerOffice(scripts, markSheet);
    }
    public Script getRequestForReExamine(Script script)
    {
        System.out.println();
        System.out.println("Examiner ID: "+id+" received request for re-Examine script.");
        System.out.println("Script Details...............");
        System.out.println("Student ID: "+script.studentId);
        System.out.println("Course No: "+script.courseNo);
        System.out.println("Previous mark: "+script.markObtained);
        System.out.println();

        Random rand = new Random();
        Script script1 = new Script(script.courseNo, script.studentId, script.markObtained);
        int luck = 1;
        // int luck = rand.nextInt(1000);
        if(luck % 2 == 1)
        {
            script1.markObtained = script.markObtained + 5;
            if(script1.markObtained > 100.0)
                script1.markObtained = 100.0;
        }
        else
        {
            script1.markObtained = script.markObtained;
        }
        System.out.println("The script is sent back to Exam Controller Office after reExamination");
        return script1;
    }
    private void sendToControllerOffice(Script scrips[], List<Double> marksheet)
    {
        mediator.getScriptsFromExaminer(scrips, marksheet);
    }
}
