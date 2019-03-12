package com.vogella.java.retrofitgerrit.model;

import java.util.List;

public class RestExerciceResponse {
    private int count;
    private String next;

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public int getPrevious() {
        return previous;
    }

    public void setPrevious(int previous) {
        this.previous = previous;
    }

    private int previous;
    private List<Exercice> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Exercice> getResults() {
        return results;
    }

    public void setResults(List<Exercice> results) {
        this.results = results;
    }
}
