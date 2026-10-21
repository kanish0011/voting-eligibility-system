
package com.example.voting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VotingEligibilitySystemTest {

    @Test
    void eligibleIndianCitizen() {
        Voter voter =
                new Voter("Arun", 25, "Indian", "V123", true);

        assertEquals(
                "Arun: Eligible to vote",
                VotingEligibilitySystem.evaluate(voter));
    }

    @Test
    void voterExactly18IsEligible() {
        Voter voter =
                new Voter("Priya", 18, "Indian", "V124", true);

        assertTrue(
                VotingEligibilitySystem.evaluate(voter)
                        .contains("Eligible to vote"));
    }

    @Test
    void underageVoterIsRejected() {
        Voter voter =
                new Voter("Ravi", 17, "Indian", "V125", true);

        assertTrue(
                VotingEligibilitySystem.evaluate(voter)
                        .contains("Underage"));
    }

    @Test
    void nonCitizenIsRejected() {
        Voter voter =
                new Voter("John", 30, "Other", "V126", true);

        assertTrue(
                VotingEligibilitySystem.evaluate(voter)
                        .contains("Not an Indian citizen"));
    }

    @Test
    void invalidVoterIdIsRejected() {
        Voter voter =
                new Voter("Meena", 30, "Indian", "V127", false);

        assertTrue(
                VotingEligibilitySystem.evaluate(voter)
                        .contains("Invalid voter ID"));
    }

    @Test
    void missingVoterIdIsRejected() {
        Voter voter =
                new Voter("Kumar", 30, "Indian", "", true);

        assertTrue(
                VotingEligibilitySystem.evaluate(voter)
                        .contains("Invalid voter ID"));
    }

    @Test
    void multipleReasonsAreReported() {
        Voter voter =
                new Voter("Sam", 16, "Other", "", false);

        String result = VotingEligibilitySystem.evaluate(voter);

        assertTrue(result.contains("Underage"));
        assertTrue(result.contains("Not an Indian citizen"));
        assertTrue(result.contains("Invalid voter ID"));
    }
}
