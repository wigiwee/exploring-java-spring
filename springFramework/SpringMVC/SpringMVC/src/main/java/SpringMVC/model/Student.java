package SpringMVC.model;

import java.util.Date;
import java.util.List;

public class StudentEntity {
    private String name;
    private long id;
    private Date date;
    private List<String> courses;
    private String gender;
    private String type;

    public StudentEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", date=" + date +
                ", courses=" + courses +
                ", gender='" + gender + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
