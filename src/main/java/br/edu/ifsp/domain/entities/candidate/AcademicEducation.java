package br.edu.ifsp.domain.entities.candidate;

import java.util.Date;

public class AcademicEducation {
    private String course;
    private Date courseStart;
    private Date courseEnd;
    private boolean completed;
    private AcademicDegree academicDegree;
    private String academicInstitution;

    public AcademicEducation(String course, Date courseStart, Date courseEnd, boolean completed, AcademicDegree academicDegree, String academicInstitution) {
        this.course = course;
        this.courseStart = courseStart;
        this.courseEnd = courseEnd;
        this.completed = completed;
        this.academicDegree = academicDegree;
        this.academicInstitution = academicInstitution;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Date getCourseStart() {
        return courseStart;
    }

    public void setCourseStart(Date courseStart) {
        this.courseStart = courseStart;
    }

    public Date getCourseEnd() {
        return courseEnd;
    }

    public void setCourseEnd(Date courseEnd) {
        this.courseEnd = courseEnd;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public AcademicDegree getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(AcademicDegree academicDegree) {
        this.academicDegree = academicDegree;
    }

    public String getAcademicInstitution() {
        return academicInstitution;
    }

    public void setAcademicInstitution(String academicInstitution) {
        this.academicInstitution = academicInstitution;
    }

    @Override
    public String toString() {
        return "AcademicEducation{" +
                "course='" + course + '\'' +
                ", courseStart=" + courseStart +
                ", courseEnd=" + courseEnd +
                ", completed=" + completed +
                ", academicDegree=" + academicDegree +
                ", academicInstitution='" + academicInstitution + '\'' +
                '}';
    }
}
