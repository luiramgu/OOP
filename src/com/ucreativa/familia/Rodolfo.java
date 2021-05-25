package com.ucreativa.familia;

public class Rodolfo {
    private int age;
    private String hobby;


    public int getAge() {
        return age;
    }

    public void setAge() {
        this.age = this.age++;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Rodolfo(String saludo){
        System.out.println(saludo);
    }


}
