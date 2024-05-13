package com.company;

import java.util.ArrayList;
import java.util.List;

public class Controller implements Mediator{
    static List<Script>finalScripts = new ArrayList<Script>();
    List<Examiner> examinerList = new ArrayList<Examiner>();
    List<Student> studentList = new ArrayList<Student>();

    public void register(Examiner examiner)
    {
        examinerList.add(examiner);
    }
    public void register(Student student)
    {
        studentList.add(student);
    }

    @Override
    public void showParticipants() {
        System.out.println("The registered Examiners in the system are:");
        for(int i=0;i<examinerList.size();i++)
        {
            System.out.println("Examiner ID - "+ examinerList.get(i).id);
        }
        System.out.println();;
        System.out.println("..................................");
        System.out.println();
        System.out.println("The registered Students in the system are:");
        for(int i=0;i<studentList.size();i++)
        {
            System.out.println("Student ID - 19050"+ studentList.get(i).id);
        }
        System.out.println();
    }
    private Script getScript(int course, int id)
    {
        Script scriptDesired = null;
        Script script;
        for(int i=0;i<finalScripts.size();i++)
        {
            script=finalScripts.get(i);
            if(script.courseNo == course && script.studentId==id)
            {
                scriptDesired = script;break;
            }
        }
        return scriptDesired;
    }

    @Override
    public void getRequestToReExamine(int courseNo, int studentId, int examinerID)
    {
        System.out.println();
        System.out.println("Request received in  Exam Controller Office to re-examine script.");
        System.out.println("Student ID: "+studentId);
        System.out.println("Course No: "+courseNo);
        Script scriptToReExamine = getScript(courseNo, studentId);
        System.out.println();
        System.out.println("The script is sent to corresponding examiner from Exam Controller Office");
        Examiner examiner=examinerList.get(examinerID-1);
        Script scriptFinal = examiner.getRequestForReExamine(scriptToReExamine);
        //System.out.println(scriptFinal.markObtained + " "+scriptToReExamine.markObtained);
        if(scriptFinal.markObtained != scriptToReExamine.markObtained)
        {
            System.out.println("There has been a change in result.");
            finalScripts.remove(scriptToReExamine);
            finalScripts.add(scriptFinal);
            System.out.println("The updated result: ");
            publishResult2(finalScripts);
        }
        System.out.println();
        System.out.println("Response from Exam Controller Office to the student requesting for reExamination is sent.");
        System.out.println();
        for(int j=0;j<studentList.size();j++)
        {
            if(studentList.get(j).id == studentId)
            {
                studentList.get(j).notify(courseNo, scriptFinal.markObtained);
            }
        }


    }

    @Override
    public void getScriptsFromExaminer(Script[] scripts, List<Double> list) {
        System.out.println();
        System.out.println("The scripts and mark sheet are in Exam controller Office");
        List<Double>correctedList = scrutiny(scripts, list);
        for(int i=0;i<scripts.length;i++)
        {
            finalScripts.add(scripts[i]);
        }
        publishResult(correctedList);
        notifyStudents();


    }
    private void notifyStudents()
    {
        for(int i=0;i<finalScripts.size();i++)
        {
            int courseNo = finalScripts.get(i).courseNo;
            double mark = finalScripts.get(i).markObtained;
            int studentId = finalScripts.get(i).studentId;
            for(int j=0;j<studentList.size();j++)
            {
                if(studentList.get(j).id == studentId)
                {
                    studentList.get(j).notify(courseNo, mark);
                }
            }
        }
    }

    private void publishResult(List<Double> correctedList)
    {
        System.out.println();
        System.out.println("The result is published after proper scrutiny from Exam Controller Office:");
        System.out.println();
        for (int i=0;i<correctedList.toArray().length;i++)
        {
            System.out.println("Student ID: "+(i+1)+" Mark Obtained: "+correctedList.get(i));
        }
    }
    private void publishResult2(List<Script> correctedList)
    {
        System.out.println();
        System.out.println("The result is published after an update from Exam Controller Office:");
        System.out.println();
        for (int i=0;i<correctedList.toArray().length;i++)
        {
            System.out.println("Student ID: "+correctedList.get(i).studentId+" Mark Obtained: "+correctedList.get(i).markObtained);
        }
    }

    public List<Double> scrutiny(Script[] script, List<Double> list)
    {
        int totalFault= 0;
        for(int i=0;i<script.length;i++)
        {
            if(script[i].markObtained!=list.get(i))
            {
                totalFault = totalFault + 1;
                System.out.println();
                System.out.println("Mark mismatch found on Student id "+script[i].studentId);
                System.out.println("Obtained Mark is "+script[i].markObtained);
                System.out.println("The given mark was "+list.get(i));
                list.set(i, script[i].markObtained);
            }
        }
        System.out.println("Total mismatch found in scrutiny in Controller Office: "+totalFault);
        return list;
    }

}
