import java.io.FileNotFoundException;
import java.util.Scanner;

public class GuessTheMovie {

    //check if players letter matches any letter in the movie title
    private static boolean isMatch(String movie, String a){
    String[] title = movie.split("");
        for (String s : title) {
            if (s.equals(a)) {

                return true;
            }
        }
    return false;
    }

    //if the letter is in the word - the underscore will be replaced with the correct letter.
    public static String playerProgress(String movie, String playerGuess, String underscored){
        StringBuilder underScore = new StringBuilder(underscored);
    for (int i = 0; i < movie.length(); i++){
        if (movie.substring(i, i + 1).equals(playerGuess)){
            underScore.replace(i,i + 1,playerGuess);
        }
    }
    return underScore.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {

        GameStatus gameStatus = new GameStatus(10,MovieData.selectRandomMovie(),"");
        GameEngine.gamePlay(gameStatus);
        WinCondition.playerWinStatus(gameStatus.getPlayerPoints(), gameStatus.getCurrentMovieTitle(), gameStatus.getTitleWithUnderscores());

    }
}
