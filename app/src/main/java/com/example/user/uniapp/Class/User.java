package com.example.user.uniapp.Class;

public class User {
   private int Animals;
   private int Colors;
   private int Family;
   private int Food;
   private String Name;
   private int Numbers;
   private int Random;
   private String StudentId;
   private String Password;

    public User() {
    }

    public int getAnimals() {
        return Animals;
    }

    public void setAnimals(int animals) {
        Animals = animals;
    }

    public int getColors() {
        return Colors;
    }

    public void setColors(int colors) {
        Colors = colors;
    }

    public int getFamily() {
        return Family;
    }

    public void setFamily(int family) {
        Family = family;
    }

    public int getFood() {
        return Food;
    }

    public void setFood(int food) {
        Food = food;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getNumbers() {
        return Numbers;
    }

    public void setNumbers(int numbers) {
        Numbers = numbers;
    }

    public int getRandom() {
        return Random;
    }

    public void setRandom(int random) {
        Random = random;
    }

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String studentId) {
        StudentId = studentId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public User(int animals, int colors, int family, int food, String name, int numbers, int random, String studentId, String password) {

        Animals = animals;
        Colors = colors;
        Family = family;
        Food = food;
        Name = name;
        Numbers = numbers;
        Random = random;
        StudentId = studentId;
        Password = password;
    }
}
