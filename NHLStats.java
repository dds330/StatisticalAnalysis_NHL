import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class NHLStats {

    private List<PlayerRecord> recordList;

    public NHLStats(){
        recordList = new List<PlayerRecord>();
    }

    public void add(PlayerRecord record){
        recordList.add(record);
    }

    /*
     * Method to output the player with most points
     * most points = most goals + assists
     * If more than one player had the most points, it should display all players
     */
    public String printPlayerWithMostPoints(){

        //variable which is updated if another player has more points
        int max = 0;

        //stores points for each player. If they are maximum amongst all, max becomes equal to points.
        int points;

        //list that holds the players with most points
        List<PlayerRecord> mostPoints = new List<>();

        PlayerRecord player = recordList.first();

        while(player != null){
            points = player.getGoalsScored() + player.getAssists();

            //if players points are more than the max value
            if(points > max){
                max = points;
                //clear all players in the list mostPoints
                mostPoints.clear();
                mostPoints.add(player);
            }
            //if more than one player has max points, add the other player to the list
            //does not clear the list
            else if(points == max){
                mostPoints.add(player);
            }

            player = recordList.next();
        }

        String str = "Players with the highest points and their teams: \n";

        PlayerRecord mostPointsPlayer = mostPoints.first();

        //loops through mostPoints list and adds player name and team name to str
        while(mostPointsPlayer != null){
            str += mostPointsPlayer.getName() + " " + mostPointsPlayer.getTeamName() + "\n";
            mostPointsPlayer = mostPoints.next();
        }
        str += "\n";
        return str;
    }

    /*
     * Method to output the most aggressive player
     * most aggressive = most penalty minutes
     * If more than one player had the most penalty minutes, it should display all players
     */
    public String printPlayerWithMostAggressive(){

        //variable which is updated if another player has more penalty minutes
        int max = 0;
        //stores minutes for each player. If the minutes are maximum amongst all,
        // max becomes equal to minutes.
        int minutes;
        //list that holds the players with most minutes
        List<PlayerRecord> mostMinutes = new List<>();

        PlayerRecord player = recordList.first();

        while(player != null){
            minutes = player.getPenaltyMinutes();

            //if a player's penalty minutes are maximum
            if(minutes > max){
                max = minutes;
                //remove all players from the mostMinutes list
                mostMinutes.clear();
                mostMinutes.add(player);
            }
            //if more than one player have max minutes
            else if(minutes == max){
                mostMinutes.add(player);
            }

            player = recordList.next();
        }

        String str = "Most aggressive players, their teams and their positions: \n";

        PlayerRecord aggresssivePlayer = mostMinutes.first();
        //loops through mostMinutes and adds all players name and team to str
        while(aggresssivePlayer != null){
            str += aggresssivePlayer.getName() + " " + aggresssivePlayer.getTeamName() + " "
                    + aggresssivePlayer.getPosition() + "\n";
            aggresssivePlayer = mostMinutes.next();
        }
        str += "\n";
        return str;
    }

    /*
     * Method to output the MVP
     * MVP = player that scored most game winning goals
     * If more than one player is the MVP, it should display all players
     */
    public String playerMVP(){

        //variable which is updated if another player has more game winning goals
        int max = 0;
        //stores winning goals for each player. If the winGoals are maximum amongst all,
        // max becomes equal to winGoals.
        int winGoals;

        //list that holds the players with most game winning goals
        List<PlayerRecord> mostWinGoals = new List<>();

        PlayerRecord player = recordList.first();

        while(player != null){
            winGoals = player.getWinGoals();

            //if a player's winning goals are maximum
            if(winGoals > max){
                max = winGoals;
                //removes all previous players from the list
                mostWinGoals.clear();
                mostWinGoals.add(player);
            }
            //if more than 1 player has most winning goals
            else if(winGoals == max){
                mostWinGoals.add(player);
            }

            player = recordList.next();
        }

        String str = "Most valuable players and their teams: \n";

        PlayerRecord playerMVP = mostWinGoals.first();
        //loops through mostWinGoals list and adds player's name and team to str
        while(playerMVP != null){
            str += playerMVP.getName() + " " + playerMVP.getTeamName() + "\n";
            playerMVP = mostWinGoals.next();
        }
        str += "\n";
        return str;
    }

    /*
     * Method to output the most promising player
     * most promising player = most shots on goal
     * If more than one player is the most promising player, it should display all players
     */
    public String mostPromisingPlayer(){

        //variable which is updated if another player has more shots on goal
        int max = 0;
        //stores shots on goal for each player. If the shots are maximum amongst all,
        // max becomes equal to shots.
        int shots;

        //list that holds the players with most shots on goal
        List<PlayerRecord> mostgoalsOnShot = new List<>();

        PlayerRecord player = recordList.first();

        while(player != null){
            shots = player.getShotsOnGoal();
            if(shots > max){
                max = shots;
                //removes all previous players if another player has most shots on goal
                mostgoalsOnShot.clear();
                mostgoalsOnShot.add(player);
            }
            //if more than one player has most shots on goal, add all players to the list
            else if(shots == max){
                mostgoalsOnShot.add(player);
            }

            player = recordList.next();
        }

        String str = "Most promising players and their teams: \n";

        PlayerRecord promisingPlayer = mostgoalsOnShot.first();
        //loops through mostgoalsOnShot list and adds player's name and team to str
        while(promisingPlayer != null){
            str += promisingPlayer.getName() + " " + promisingPlayer.getTeamName() + "\n";
            promisingPlayer = mostgoalsOnShot.next();
        }
        str += "\n";
        return str;
    }

    /*
     * Method to output the team with most penalty minutes
     * adds penalty minutes for all players in one team and outputs the team with max minutes
     * If more than one team has the most minutes, it should display all teams
     */
    public String mostPenaltyTeam(){

        //hashmap to map the team name to penalty minutes
        Map<String, Integer> mostPenaltyTeam = new HashMap<>();

        //list to store teams with most penalty minutes
        LinkedList<String> teamName = new LinkedList<>();
        int maxMinutes = 0;

        PlayerRecord player = recordList.first();
        while(player != null){
            String team = player.getTeamName();
            int minutes = player.getPenaltyMinutes();

            //adds a player's penalty minutes to the team's minutes based on hashmap
            mostPenaltyTeam.put(team, mostPenaltyTeam.getOrDefault(team, 0) + minutes);

            //if a team has more penalty minutes than other
            if(mostPenaltyTeam.get(team) > maxMinutes){
                maxMinutes = mostPenaltyTeam.get(team);
                //removes all teams from the linkedlist teamName
                teamName.clear();
                teamName.add(team);
            }
            //if more than one team has max penalty minutes
            else if(mostPenaltyTeam.get(team) == maxMinutes){
                teamName.add(team);
            }

            player = recordList.next();
        }

        String str = "Teams that had the most number of penalty minutes: \n";
        for(String team: teamName){
            str += team + " " + "\n";
        }
        str += "\n";
        return str;
    }

    /*
     * Method to output the team with most game winning goals
     * adds winning goals for all players in one team and outputs the team with max win goals
     * If more than one team has the most win goals, it should display all teams
     */
    public String mostWinGoalTeam(){

        //maps the win goals to team
        Map<String, Integer> mostWinGoalTeam = new HashMap<>();

        //list to store teams with most winning goals
        LinkedList<String> teamName = new LinkedList<>();
        int maxWinGoals = 0;

        PlayerRecord player = recordList.first();
        while(player != null){
            String team = player.getTeamName();
            int winGoals = player.getWinGoals();

            //adds a player's winning goals to the team's goals using hashmap
            mostWinGoalTeam.put(team, mostWinGoalTeam.getOrDefault(team, 0) + winGoals);

            if(mostWinGoalTeam.get(team) > maxWinGoals){
                maxWinGoals = mostWinGoalTeam.get(team);
                //removes all previous teams if a team has more winning goals
                teamName.clear();
                teamName.add(team);
            }
            else if(mostWinGoalTeam.get(team) == maxWinGoals){
                teamName.add(team);
            }

            player = recordList.next();
        }

        String str = "Teams that had the most number of game winning goals: \n";
        for(String team: teamName) {
            str += team + " ";
        }
        str += "\n";
        return str;
    }
}
