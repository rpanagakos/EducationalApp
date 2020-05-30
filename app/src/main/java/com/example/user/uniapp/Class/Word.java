package com.example.user.uniapp.Class;

public class Word {
    private String enWord;
    private String grWord;
    private int Image;

    public Word(String enWord, String grWord, int image) {
        this.enWord = enWord;
        this.grWord = grWord;
        Image = image;
    }

    public String getEnWord() {
        return enWord;
    }

    public void setEnWord(String enWord) {
        this.enWord = enWord;
    }

    public String getGrWord() {
        return grWord;
    }

    public void setGrWord(String grWord) {
        this.grWord = grWord;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
