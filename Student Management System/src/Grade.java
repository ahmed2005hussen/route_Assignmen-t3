public class Grade {

    private double grade;
    private String gradeStatus;

    private String setGradeStatus() {
        if (grade >= 90) return "Excellent";
        if (grade >= 75) return "Very Good";
        if (grade >= 60) return "Pass";

        return "Fail";
    }

    public Grade(double grade) {
        setGrade(grade);
        this.gradeStatus = setGradeStatus();
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        if (grade >= 0 && grade <= 100) this.grade = grade;
        this.gradeStatus = setGradeStatus();
    }

    public String getGradeStatus(){
        return gradeStatus;
    }

    @Override
    public String toString() {
        return
                " ,grade = " + grade +
                ", gradeStatus='" + gradeStatus + '\'' ;
    }
}
