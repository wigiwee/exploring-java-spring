package com.kaustubh.SpEL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Demo {
    @Value("#{22-1}") //Spring Expression Language 
    private int x;
    
    @Value("#{34*2}")
    private int y;

    @Value("#{ T(java.lang.Math).sqrt(25)}") //value 5 got inserted in z; this is how static methods are called from SpEL
    private int z;                             // SpEL syntax is like @Value("#{T(className).VarNameOrMethodName}")

    @Value("#{T(java.lang.Math).PI}") //PI is a variable of class Math in java, this is how PI variable is accessed //any class static contents can be accessed like this 
    private double PI;

    @Value("#{new java.lang.String('Java Spring Framework')}") //creating object in SpEL,
    private String name;                                        // syntax is like @Value("#{new ObjectName(params)}")
    
    @Value("#{(3-2-223+32) > (45+54-98-74-6)}")
    private boolean isActive;
    
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPI() {
        return PI;
    }
    public void setPI(double pI) {
        PI = pI;
    }
    public int getZ() {
        return z;
    }
    public void setZ(int z) {
        this.z = z;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    @Override
    public String toString() {
        return "Demo [x=" + x + ", y=" + y + ", z=" + z + ", PI=" + PI + ", name=" + name + ", isActive=" + isActive
                + "]";
    }
    



    
}
