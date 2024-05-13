package com.company;

import java.util.List;

public interface Mediator {
    public  void register(Student student);
    public  void register(Examiner examiner);
    public void showParticipants();
    public void getScriptsFromExaminer(Script[] script, List<Double> list);
    public void getRequestToReExamine(int courseNo, int studentId, int examinerID);
}
