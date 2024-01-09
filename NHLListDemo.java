import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class NHLListDemo {
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the filename to read from: ");
        String fileName = in.nextLine();

        File file = new File(fileName);
        Scanner inputFile = new Scanner(file);

        NHLStats recordList = new NHLStats();
        String name, position, teamName;
        int gamesPlayed, goalsScored, assists, penaltyMinutes, shotsOnGoal, winGoals;
        PlayerRecord player = null;

        while(inputFile.hasNextLine()){
            String line = inputFile.nextLine();
            //the string has variable values separated by tabs
            StringTokenizer token = new StringTokenizer(line, "\t");

            name = token.nextToken();
            position = token.nextToken();
            teamName = token.nextToken();
            gamesPlayed = Integer.parseInt(token.nextToken());
            goalsScored = Integer.parseInt(token.nextToken());
            assists = Integer.parseInt(token.nextToken());
            penaltyMinutes = Integer.parseInt(token.nextToken());
            shotsOnGoal = Integer.parseInt(token.nextToken());
            winGoals = Integer.parseInt(token.nextToken());

            player = new PlayerRecord(name, position, teamName, gamesPlayed, goalsScored,
                    assists, penaltyMinutes, shotsOnGoal, winGoals);

            recordList.add(player);
        }

        inputFile.close();

        //creates a file to store the output
        FileWriter outputFile = new FileWriter("nhlstatsoutput.txt");

        //adds all outputs to the file
        outputFile.write(recordList.printPlayerWithMostPoints());
        outputFile.write(recordList.printPlayerWithMostAggressive());
        outputFile.write(recordList.playerMVP());
        outputFile.write(recordList.mostPromisingPlayer());
        outputFile.write(recordList.mostPenaltyTeam());
        outputFile.write(recordList.mostWinGoalTeam());

        outputFile.close();
    }
}
