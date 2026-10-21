
package com.example.voting;

public class Voter {
    private final String name;
    private final int age;
    private final String citizenship;
    private final String voterId;
    private final boolean validId;

    public Voter(String name, int age, String citizenship,
                 String voterId, boolean validId) {
        this.name = name;
        this.age = age;
        this.citizenship = citizenship;
        this.voterId = voterId;
        this.validId = validId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public String getVoterId() {
        return voterId;
    }

    public boolean hasValidId() {
        return validId;
    }
}
