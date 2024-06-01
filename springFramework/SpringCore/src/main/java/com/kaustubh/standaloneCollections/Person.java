package com.kaustubh.standaloneCollections;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class Person {
    private List <String> friends;
    private Map<String, Integer> freeStructure;
    private Properties properties;

    public Properties getProperties() {
        return this.properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
    

    public List<String> getFriends() {
        return this.friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }


    public Person() {
    }

    public Person(List<String> friends, Map<String,Integer> freeStructure) {
        this.friends = friends;
        this.freeStructure = freeStructure;
    }

    public Person friends(List<String> friends) {
        setFriends(friends);
        return this;
    }

    public Person freeStructure(Map<String,Integer> freeStructure) {
        setFreeStructure(freeStructure);
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(friends, freeStructure);
    }


    @Override
    public String toString() {
        return "{" +
            " friends='" + getFriends() + "'" +
            ", freeStructure='" + getFreeStructure() + "'" +
            ", properties='" + getProperties() + "'" +
            "}";
    }

    

    public Map<String, Integer> getFreeStructure() {
        return freeStructure;
    }

    public void setFreeStructure(Map<String, Integer> freeStructure) {
        this.freeStructure = freeStructure;
    }
    
}
