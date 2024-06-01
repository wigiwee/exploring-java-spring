package com.kaustubh.stereotypeAnnotation;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("obj")
public class Student {
    @Value("Kaustubh Kolhe")
    private String studentName;

    @Value("Delhi")
    private String city;

    @Value("#{subjects}") //subjects ArrayList defined in stereoConfig.xml file as standalone collection
    private List<String> subjectList;

    public List<String> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<String> subjecList) {
        this.subjectList = subjecList;
    }

    public Student() {
    }

    public Student(String studentName, String city) {
        this.studentName = studentName;
        this.city = city;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Student studentName(String studentName) {
        setStudentName(studentName);
        return this;
    }

    public Student city(String city) {
        setCity(city);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " studentName='" + getStudentName() + "'" +
            ", city='" + getCity() + "'" +
            ", subjecList='" + getSubjectList() + "'" +
            "}";
    }

    
}
