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
            res += course.multiplyCreditAndCourseGrade();
        }

        // 이수한 과목들의 총 학점수
        int totalCompletedCredit = courses.stream()
                .mapToInt(Course::getCredit)
                .sum();

        return res/totalCompletedCredit;
    }
}
