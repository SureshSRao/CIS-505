package Module_2.SportsTeamApp;

import java.util.Scanner;

/**
 * TestSportsTeamApp is a driver class used to test the Team class.
 * It prompts the user to enter team and player names, 
 * adds players to the team, and displays team details.
 * The program allows repeated entry of teams until the user exits.
 * Assignment 2.3
 * 
 * @author Suresh Sripathi Rao
 * @version 1.0
 */
public class TestSportsTeamApp {
    /**
     * Main method to run the Team test application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean keepGoing = true;

        System.out.println("  Welcome to the Sports Team App: \n");

        while (keepGoing) {
            // Prompt team name
            System.out.print("  Enter a team name: ");
            String teamName = sc.nextLine().trim();

            // Create team instance
            Team team = new Team(teamName);

            // Prompt players (comma-separated, no spaces)
            System.out.println("\n  Enter the player names: ");
            System.out.print("    hint: use commas for multiple players; no spaces>: ");
            String rawPlayers = sc.nextLine().trim();
            rawPlayers = rawPlayers.replace(" ", ""); // sanitize input

            // Split input and add each player
            if (!rawPlayers.isEmpty()) {
                String[] names = rawPlayers.split(",");
                for (String p : names) {
                    if (!p.isEmpty()) {
                        team.addPlayer(p);
                    }
                }
            }

            // Display results
            System.out.println();
            System.out.println("  --Team Summary-- ");
            System.out.println("  Number of players in team " + team.getPlayerCount());
            System.out.print("  Players on team: ");
            String[] stored = team.getPlayers();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < team.getPlayerCount(); i++) {
                if (i > 0) sb.append(",");
                sb.append(stored[i]);
            }
            System.out.println(sb.toString());

            // Prompt user to continue
            System.out.print("\n  Continue? (y/n): ");
            String ans = sc.nextLine().trim().toLowerCase();
            keepGoing = ans.equals("y") || ans.equals("yes");

            if (keepGoing) {
                System.out.println();
            }
        }

        sc.close();
    }
}

