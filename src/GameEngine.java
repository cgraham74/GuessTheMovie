import java.util.Scanner;


public class GameEngine{

    public static void gamePlay (GameStatus gameStatus){

        Scanner keyBoardInput = new Scanner(System.in);
        System.out.println("Rules: Your goal is to try and figure out the movie by guessing 1 letter at a time.");
        System.out.println("The movie title is \"" + gameStatus.getTitleWithUnderscores() + "\"");
        //this is printing out current movie title for testing -- can be removed later
        System.out.println(gameStatus.getCurrentMovieTitle());
        while (gameStatus.getPlayerPoints() > 0){

            System.out.print("Guess a letter: ");
            gameStatus.setPlayerGuess(keyBoardInput.nextLine());
            System.out.println("You guessed " + gameStatus.getPlayerGuess());
            // need if statement for if the letter does not match -- update updatedPlayerGuess
            if (!gameStatus.getCurrentMovieTitle().contains(gameStatus.getPlayerGuess())){
                gameStatus.setLettersGuessed(" " + gameStatus.getPlayerGuess());
            }

            System.out.println("Your guesses so far: "+ gameStatus.getLettersGuessed());
            gameStatus.setPlayerPoints(gameStatus.getPlayerPoints() - 1);

            System.out.println("You have " + gameStatus.getPlayerPoints() + " guess(es) left.");

            gameStatus.setTitleWithUnderscores(GuessTheMovie.playerProgress(gameStatus.getCurrentMovieTitle(),gameStatus.getPlayerGuess(),gameStatus.getTitleWithUnderscores()));
            System.out.println("You are guessing: "+gameStatus.getTitleWithUnderscores());
            if (gameStatus.getTitleWithUnderscores().equals(gameStatus.getCurrentMovieTitle())){
                break;
            }
        }
    }
}
