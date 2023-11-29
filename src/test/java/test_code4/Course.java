package test_code4;

public class Course {

    private String subject;
    private int creadit;
    private String grade;

    public Course(String subject, int creadit, String grade) {
        this.subject = subject;
        this.creadit = creadit;
        this.grade = grade;
    }

    public double getGradeToNumber() {
        double grade = 0;
        switch (this.grade) {
            case "A+":
                grade = 4.5;
                break;
            case "A":
                grade = 4.0;
                break;
            case "B+":
                grade = 3.5;
                break;
            case "B":
                grade = 3.0;
                break;
            case "C+":
                grade = 2.5;
                break;
            case "C":
                grade = 2.0;
                break;
        }
        return grade;
    }

    public int getCredit() {
        return creadit;
    }

    public double multiplyCreditAndCourseGrade() {
        return creadit * getGradeToNumber();
    }
}
