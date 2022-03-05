public class WinCondition {

    static void playerWinStatus (int playerPoints,String currentMovieTitle, String titleWithUnderscores){
        if (playerPoints == 0 && !titleWithUnderscores.equals(currentMovieTitle)){
            System.out.println("You LOSE!!!!");
            System.out.println("The movie title was: \""+currentMovieTitle + "\", better luck next time!");
        } else {
            System.out.println("You WIN!!!!");
        }
    }

}
