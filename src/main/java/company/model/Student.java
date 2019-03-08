package main.java.company.model;

import java.util.*;
import java.util.stream.Collectors;

public class Student {
    private final String name;
    private final long id;
    private Map<String, Double> scoreList;
    private double average;
    private double sum;

    public Student(String name, long id) {
        this.name = name;
        this.id = id;
        this.scoreList = new HashMap<>();
    }

    public long getId() {
        return this.id;
    }

    public void addScoreToScoreList(String subject, double score) {
        this.scoreList.put(subject, score);
    }

    public void setAverage() {
        this.average = this.scoreList.values()
                .stream()
                .collect(Collectors.averagingDouble(Double::valueOf));
    }

    public double getSum() {
        return this.sum;
    }

    public void setSum() {
        this.sum = this.scoreList.values()
                .stream()
                .mapToDouble(Double::valueOf)
                .sum();
    }

    @Override
    public String toString() {
        double math = null != this.scoreList.get("数学") ? this.scoreList.get("数学") : 0;
        double chinese = null != this.scoreList.get("语文") ? this.scoreList.get("语文")  : 0;
        double english = null != this.scoreList.get("英语") ? this.scoreList.get("英语") : 0;
        double programming = null != this.scoreList.get("编程") ? this.scoreList.get("编程") : 0;
        return this.name + "|" + math + "|" + chinese + "|" + english + "|" + programming + "|" + this.average + "|" + this.sum;
    }

    @Override
    public boolean equals(Object student) {
        if (student instanceof Student) {
            return this.id == ((Student) student).getId();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (int) this.id;
    }
}
