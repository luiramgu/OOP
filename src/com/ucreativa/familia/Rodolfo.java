package com.ucreativa.familia;

public class Rodolfo {
    private int age;
    private String hobby;
    private String lastname;

    public Rodolfo() {

    }

    public int getAge() {
        return age;
    }

    public void setAge() {
        this.age = this.age++;
    }

    public Rodolfo(String saludo){
        System.out.println(saludo);
    }

    public Rodolfo(int age, String hobby, String lastname){
        this.age=age;
        this.hobby=hobby;
        this.lastname=lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
