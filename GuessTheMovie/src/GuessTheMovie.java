import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GuessTheMovie {

    //pulls a list of movies from a text file and returns a random movie title
  /*  private static String selectRandomMovie() throws FileNotFoundException {
        String movie;
        File file = new File("listOfMovies.txt");
        List<String>movieList = new ArrayList<>();
        Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
            movieList.add(scanner.nextLine());
            }
            Collections.shuffle(movieList);
            movie = movieList.subList(0,1).toString();
        return movie.substring(1, movie.length()-1);
    }
    //replace movie title letters with underscores and spaces
    private static String convertMovie(String movie){
        StringBuilder underScore = new StringBuilder();
        for (int i = 0; i < movie.length(); i++){
            if(movie.charAt(i) == ' '){
                underScore.append(" ");
            } else {
                underScore.append("_");
            }
        }
        return underScore.toString();
    }
*/
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
    private static String playerProgress(String movie, String playerGuess, String underscored){
        StringBuilder underScore = new StringBuilder(underscored);
    for (int i = 0; i < movie.length(); i++){
        if (movie.substring(i, i + 1).equals(playerGuess)){
            underScore.replace(i,i + 1,playerGuess);
        }
    }
    return underScore.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {

        int playerPoints = 10;
        String currentMovieTitle = Game.selectRandomMovie();
        String playerGuess;
        String titleWithUnderscores = Game.convertMovie(currentMovieTitle);
        StringBuilder lettersGuessed = new StringBuilder();

        Scanner keyBoardInput = new Scanner(System.in);
        System.out.println("Rules: Your goal is to try and figure out the movie by guessing 1 letter at a time.");
        System.out.println("The movie title is \"" + Game.convertMovie(currentMovieTitle) + "\"");
        //this is printing out current movie title for testing -- can be removed later
        System.out.println(currentMovieTitle);
        while (playerPoints > 0){

            System.out.print("Guess a letter: ");
            playerGuess = keyBoardInput.nextLine();
            System.out.println("You guessed " + playerGuess);
            // need if statement for if the letter does not match -- update updatedPlayerGuess
            if (!currentMovieTitle.contains(playerGuess)){
                lettersGuessed.append(" ").append(playerGuess);
            }

            System.out.println("Your guesses so far: "+ lettersGuessed);
            playerPoints--;

            System.out.println("You have " + playerPoints + " guess(es) left.");

            titleWithUnderscores = playerProgress(currentMovieTitle, playerGuess, titleWithUnderscores);
            System.out.println("You are guessing: "+titleWithUnderscores);
            if (titleWithUnderscores.equals(currentMovieTitle)){
                break;
            }
        }
        if (playerPoints == 0 && !titleWithUnderscores.equals(currentMovieTitle)){
            System.out.println("You LOSE!!!!");
            System.out.println("The movie title was: \""+currentMovieTitle + "\", better luck next time!");
        } else {
            System.out.println("You WIN!!!!");
        }
    }
}
