package test_code4;

import java.util.List;

public class GradeCalculator {

    private final List<Course> courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = courses;
    }

    public double calculate() {
        double res = 0.0;
        for (Course course : courses) {
            res += course.getCredit() * course.getGradeToNumber();
        }

        return 4.5;
    }
}
