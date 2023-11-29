package test_code4;

import java.util.List;

public class GradeCalculator {

    // 1급 컬렉션: 리스트 형태로 된 정보만 인스턴스 변수로 가지는 클래스
    private final Courses courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = new Courses(courses);
    }

    public double calculate() {
        return courses.multiplyCreditAndCourseGrade() / courses.calculateTotalCompletedCredit();
    }
}
