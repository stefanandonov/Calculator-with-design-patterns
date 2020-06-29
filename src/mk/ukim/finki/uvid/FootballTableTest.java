//package mk.ukim.finki.uvid;
//package ukim.finki.np.Kolokvium2;
///*       ..:Zorica:..           */
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
///**
// * Partial exam II 2016/2017
// */
//public class FootballTableTest {
//    public static void main(String[] args) throws IOException {
//        FootballTable table = new FootballTable();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        reader.lines()
//                .map(line -> line.split(";"))
//                .forEach(parts -> table.addGame(parts[0], parts[1],
//                        Integer.parseInt(parts[2]),
//                        Integer.parseInt(parts[3])));
//        reader.close();
//        System.out.println("=== TABLE ===");
//        System.out.printf("%-19s%5s%5s%5s%5s%5s\n", "Team", "P", "W", "D", "L", "PTS");
//        table.printTable();
//    }
//}
//
//// Your code here
//class Team{
//    String teamName;
//    int wins, loses, games, draws, homeGoals, awayGoals;
//
//    Team(String teamName){
//        this.teamName = teamName;
//        wins = loses = games = draws = homeGoals = awayGoals = 0;
//    }
//
//    public String getTeamName() {
//        return teamName;
//    }
//
//    public int getWins() {
//        return wins;
//    }
//
//    public int getLoses() {
//        return loses;
//    }
//
//    public int getGames() {
//        return games;
//    }
//
//    public int getDraws() {
//        return draws;
//    }
//
//    public int getHomeGoals() {
//        return homeGoals;
//    }
//
//    public int getAwayGoals() {
//        return awayGoals;
//    }
//    public int points(){
//        return wins*3 + draws;
//    }
//
//    public int goalGameDifference() {
//        return homeGoals-awayGoals;
//    }
//
//    @Override
//    public String toString(){
//        return String.format("%-15s%5d%5d%5d%5d%5d",teamName,games,wins,draws,loses,points());
//    }
//}
//class FootballTable{
//    Map<String, Team> footballTeams;
//
//    FootballTable(){
//        footballTeams = new HashMap<>();
//    }
//    Comparator<Team> teamComparator = Comparator.comparing(Team::points)
//            .thenComparing(Team::goalGameDifference)
//            .thenComparing(Team::getTeamName);
//
//    public void addGame(String homeTeam, String awayTeam, int homeGoals, int awayGoals) {
//        Team home = null;
//
//        if(home == null){
//            home = new Team(homeTeam);
//            footballTeams.put(homeTeam,home);
//        }
//
//        for(String team : footballTeams.keySet()){
//            if (team.equals(homeTeam)){
//                home = footballTeams.get(team);
//            }
//        }
//        home.games +=1;
//        home.homeGoals += homeGoals;
//        home.awayGoals += awayGoals;
//
//        Team away = footballTeams.computeIfAbsent(awayTeam,key-> new Team(awayTeam));
//        away.games +=1;
//        away.awayGoals += awayGoals;
//        away.homeGoals += homeGoals;
//
//        if(homeGoals == awayGoals){//ex 0:0
//            home.draws++;
//            away.draws++;
//        }
//        if(homeGoals < awayGoals){//ex. 0:1
//            home.loses++;
//            away.wins++;
//        }
//        if(homeGoals > awayGoals){//ex. 1:0
//            home.wins++;
//            away.loses++;
//        }
//
//    }
//
//    public void printTable(){
//        List<Team> listOfFootballTeams = footballTeams.values()
//                .stream()
//                .sorted(teamComparator)
//                .collect(Collectors.toList());
//
//        for(int i=1;i<listOfFootballTeams.size();i++) {
//            System.out.print(String.format("%d. %s\n",i,listOfFootballTeams));
//        }
//    }
//}
//
//// Your code here
//
