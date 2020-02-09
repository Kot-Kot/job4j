package ru.job4j.stream;

public class Student {
    Student(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private int score;

    @Override
    public String toString() {
        return "Student{" +
                "score=" + score +
                '}';
    }
}
