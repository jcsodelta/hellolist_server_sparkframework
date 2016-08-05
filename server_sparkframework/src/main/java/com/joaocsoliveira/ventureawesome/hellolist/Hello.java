package com.joaocsoliveira.ventureawesome.hellolist;

/**
 * Created by joaocsoliveira on 04/08/16.
 */
class Hello {
    private String name;

    Hello(String name){
        this.name = name;
    }

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "Hello, " + name + "!";
    }
}
