
package com.example.voting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VotingEligibilitySystem {

    public static String evaluate(Voter voter) {
        List<String> reasons = new ArrayList<>();

        if (voter.getAge() < 18) {
            reasons.add("Underage");
        }

        if (!"Indian".equalsIgnoreCase(
                voter.getCitizenship().trim())) {
            reasons.add("Not an Indian citizen");
        }

        if (voter.getVoterId() == null
                || voter.getVoterId().trim().isEmpty()
                || !voter.hasValidId()) {
            reasons.add("Invalid voter ID");
        }

        if (reasons.isEmpty()) {
            return voter.getName() + ": Eligible to vote";
        }

        return voter.getName() + ": Not eligible to vote - "
                + String.join(", ", reasons);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of voters: ");
            int count = Integer.parseInt(scanner.nextLine());

            if (count < 1) {
                System.out.println(
                        "Number of voters must be at least 1.");
                return;
            }

            List<Voter> voters = new ArrayList<>();

            for (int i = 1; i <= count; i++) {
                System.out.println("\nEnter details for voter " + i);

                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("Age: ");
                int age = Integer.parseInt(scanner.nextLine());

                System.out.print("Citizenship (Indian/Other): ");
                String citizenship = scanner.nextLine();

                System.out.print("Voter ID: ");
                String voterId = scanner.nextLine();

                System.out.print("Is voter ID valid? (yes/no): ");
                boolean validId =
                        scanner.nextLine().equalsIgnoreCase("yes");

                voters.add(new Voter(
                        name, age, citizenship, voterId, validId));
            }

            System.out.println("\n--- Voting Eligibility Results ---");

            for (Voter voter : voters) {
                System.out.println(evaluate(voter));
            }
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Age and voter count must be numbers.");
        }
    }
}
