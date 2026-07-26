import java.util.Arrays;

public class Student {

    private int id;
    private String name;
    private Subject[] subjects;
    private Grade finalGrade;

    private double calcFinalGrade(){
        double res = 0.0;
        for(int i = 0 ; i < subjects.length ; i++){
            res+=subjects[i].getGrade().getGrade();
        }

        return res/subjects.length;
    }

    public Student(){}
    public Student(int id, String name, Subject[] subjects) {
        this.id = id;
        this.name = name;
        this.subjects = subjects;
        this.finalGrade = new Grade(calcFinalGrade());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFinalGrade() {
        return finalGrade.getGrade();
    }
    public String getFinalStatus(){
        return finalGrade.getGradeStatus();
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Student:" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subjects=" + Arrays.toString(subjects) +
                ",\n finalGrade: \n" + finalGrade +
                '\n';
    }
}
