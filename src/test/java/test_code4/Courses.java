package test_code4;

import java.util.List;

public class Courses {
    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public double multiplyCreditAndCourseGrade() {
        return courses.stream()
                .mapToDouble(Course::multiplyCreditAndCourseGrade)
                .sum();
    }

    public double calculateTotalCompletedCredit() {
        // 이수한 과목들의 총 학점수
        return courses.stream()
                .mapToInt(Course::getCredit)
                .sum();
    }
}
