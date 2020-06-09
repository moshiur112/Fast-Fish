package com.example.fastfish;

public class User {
    private static String username = "username before";
    private static String password = "password before";
    private static String name = "name before";
    private static int highScore = -1;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        User.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {

        User.password = password;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {

        User.name = name;

    }

    public static int getHighScore() {
        return highScore;
    }

    public static void setHighScore(int highScore) {
        System.out.println("old " + User.highScore);
        User.highScore = highScore;
        System.out.println("new " + User.highScore);

    }


    /**
     * Constructor.
     *
     * @param username  username
     * @param password  password
     * @param highScore the high score
     */
//    public User(String username, String password, String name, int highScore) {
//        this.username = username;
//        this.password = password;
//        this.name = name;
//        this.highScore = highScore;
//    }

//    /**
//     * Getter for the username.
//     *
//     * @return username
//     */
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "username='" + username + '\'' +
//                ", password='" + password + '\'' +
//                ", name='" + name + '\'' +
//                ", highScore=" + highScore +
//                '}';
//    }
//
//    /**
//     * getter for the password.
//     *
//     * @return password
//     */
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    /**
//     * Getter for the high score.
//     *
//     * @return highScore
//     */
//    public int getHighScore() {
//        return highScore;
//    }
//
//    /**
//     * Setter for the highScore.
//     *
//     * @param highScore new highScore
//     */
//    public void setHighScore(int highScore) {
//        this.highScore = highScore;
//    }
}
