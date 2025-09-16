package Module_2.SportsTeamApp;

/**
 * The Team class represents a sports team with a name, players, 
 * and a player count. It provides methods to add players, 
 * retrieve team information, and manage player data.
 * Assignment 2.3
 * 
 * @author Suresh Sripathi Rao
 * @version 1.0
 */
public class Team {
    /** The name of the team. */
    private String teamName = "";

    /** The array that stores up to 20 player names. */
    private String[] players = new String[20];

    /** The number of players currently assigned to the team. */
    private int playerCount = 0;

    /**
     * Constructs a Team with the given name.
     *
     * @param teamName the name of the team
     */
    public Team(String teamName) {
        if (teamName != null) {
            this.teamName = teamName;
        }
    }

    /**
     * Adds a player to the team if there is space available.
     *
     * @param player the player's name
     */
    public void addPlayer(String player) {
        if (player == null || player.isEmpty()) return;
        if (playerCount < players.length) {
            players[playerCount] = player;
            playerCount++;
        }
    }

    /**
     * Returns the players array. Note: may contain null values 
     * beyond the current playerCount.
     *
     * @return the array of players
     */
    public String[] getPlayers() {
        return players;
    }

    /**
     * Returns the number of players on the team.
     *
     * @return the number of players
     */
    public int getPlayerCount() {
        return playerCount;
    }

    /**
     * Returns the team name.
     *
     * @return the name of the team
     */
    public String getTeamName() {
        return teamName;
    }
}

