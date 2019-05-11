package com.example.my_mosquesdata;

public class MetaData {
    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public int getLast_page() {
        return last_page;
    }

    public void setLast_page(int last_page) {
        this.last_page = last_page;
    }

    int current_page;
int from;
int last_page;
String path;
int per_page;
int to;
int total;
}
