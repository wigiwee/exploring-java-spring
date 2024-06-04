package com.SpringCore.classConfiguration;


//@Component 
public class Student {

    private Samosa samosa;

    
    public Samosa getSamosa() {
        return samosa;
    }
    public void setSamosa(Samosa samosa) {
        this.samosa = samosa;
    }
    public void study(){
        System.out.println("Student is studying");
    }
    @Override
    public String toString() {
        return "Student [samosa=" + samosa + "]";
    }

    public Student(Samosa samosa) {
        this.samosa = samosa;
    }


    
}
