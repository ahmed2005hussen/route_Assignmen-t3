public class Subject {

    private String name;
    private Grade grade;


    public Subject(String name , double grade){
        this.name = name;
        this.grade = new Grade(grade) ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                grade ;
    }
}
