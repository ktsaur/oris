package ru.kpfu.itis.dto;

public class userDto {
    private String name;
    private int score;
    private String login;

    public userDto(String name, int score, String login) {
        this.name = name;
        this.score = score;
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
