import java.util.Scanner;

class Mian {

    Scanner sc = new Scanner(System.in);
    Student[] students;


    public void preRequest() {
        System.out.print("Enter Number Of Students: ");
        int numberOfStudent = sc.nextInt();

        students = new Student[numberOfStudent];

        for (int i = 0; i < students.length; i++) {
            System.out.print("Enter Id of student " + (i + 1) + ", integer id: ");
            int id = sc.nextInt();
            sc.nextLine(); // ignore the newline left by nextInt()

            System.out.print("\nEnter Name of student " + (i + 1) + ": ");
            String name = sc.nextLine();

            System.out.print("\nEnter Number of subjects: ");
            int numberOfSubjects = sc.nextInt();
            sc.nextLine(); // ignore the newline left by nextInt()

            Subject[] subjects = new Subject[numberOfSubjects];

            for (int j = 0; j < subjects.length; j++) {
                System.out.print("\nEnter subject name " + (j + 1) + ": ");
                String subjectName = sc.nextLine();

                System.out.print("\nEnter grad of subjects " + (j + 1) + " :");
                double grade = sc.nextDouble();
                sc.nextLine(); // ignore the newline left by nextInt()

                subjects[j] = new Subject(subjectName, grade);
            }
            students[i] = new Student(id, name, subjects);
        }

        System.out.println("---------------------------------\n");
    }

    public int menu() {

        int choice;

        System.out.println(" 1. Display Students");
        System.out.println(" 2. Calculate Average Grade");
        System.out.println(" 3. Find Highest Grade");
        System.out.println(" 4. Search Student by ID");
        System.out.println(" 5. Count passed students and failed students.");
        System.out.println(" 0. Exit");

        System.out.println("Enter Your choice: ");
        choice = sc.nextInt();

        return (choice >= 0 && choice <= 5) ? choice : -1;
    }

    public void displayStudent() {
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
        System.out.println("--------------------------");

    }

    public void calcAverageGrade() {
        double allAverage = 0.0;

        for (int i = 0; i < students.length; i++) {
            System.out.println("Student: " + students[i].getName() + ", With id: " + students[i].getId());
            System.out.println("    His average Grade: " + students[i].getFinalGrade()
                    + ", Status: " + students[i].getFinalStatus()
                    + " , In " + students[i].getSubjects().length + " Subjects");

            allAverage += students[i].getFinalGrade();
        }
        allAverage /= students.length;
        Grade grade = new Grade(allAverage);
        System.out.println("----------");
        System.out.println("Final Average for all student is " + grade.getGrade() +
                " ,With status: " + grade.getGradeStatus());
        System.out.println("-------------------------------");
    }

    public void highestGrade() {
        Student student = students[0];

        for (int i = 1; i < students.length; i++) {
            if (students[i].getFinalGrade() > student.getFinalGrade()) {
                student = students[i];
            }
        }
        System.out.println("Highest Grade is for: " + student);
        System.out.println("--------------------------");

    }

    public void searchById() {
        System.out.println("Enter the student id: ");
        int id = sc.nextInt();

        for (int i = 0; i < students.length; i++) {
            if (students[i].getId() == id) {
                System.out.println("Student found: " + students[i]);
                System.out.println("--------------------------");

                return;
            }
        }

        System.out.println("Student not found ");
        System.out.println("--------------------------");
    }


    public void passedAndFailed() {
        int countPassed = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i].getFinalGrade() >= 60) countPassed++;
        }

        System.out.println("Passed Student Passed on the final average grade of all them grades is: " + countPassed);
        System.out.println("Failed Student: " + (students.length - countPassed));
        System.out.println("-------------------------------");
    }

    public void main(String[] args) {
        preRequest();

        loop:
        while (true) {
            int choice = menu();

            switch (choice) {
                case 1 -> displayStudent();
                case 2 -> calcAverageGrade();
                case 3 -> highestGrade();
                case 4 -> searchById();
                case 5 -> passedAndFailed();
                case 0 -> {
                    break loop;
                }
                default -> System.out.println("Enter valid number between 0 - 5");
            }
        }
        System.out.println("Thank you :) ");

    }

}
