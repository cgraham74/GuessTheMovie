public class GameStatus {

    private int playerPoints;
    private String currentMovieTitle;
    private String playerGuess;
    private String titleWithUnderscores;
    private StringBuilder lettersGuessed;

    public GameStatus(int playerPoints, String currentMovieTitle, String playerGuess) {
        this.playerPoints = playerPoints;
        this.currentMovieTitle = currentMovieTitle;
        this.playerGuess = playerGuess;
        this.titleWithUnderscores = MovieData.convertMovie(currentMovieTitle);
        this.lettersGuessed = new StringBuilder();
    }

    public int getPlayerPoints() {
        return playerPoints;
    }

    public void setPlayerPoints(int playerPoints) {
        this.playerPoints = playerPoints;
    }

    public String getCurrentMovieTitle() {
        return currentMovieTitle;
    }

    public void setCurrentMovieTitle(String currentMovieTitle) {
        this.currentMovieTitle = currentMovieTitle;
    }

    public String getPlayerGuess() {
        return playerGuess;
    }

    public void setPlayerGuess(String playerGuess) {
        this.playerGuess = playerGuess;
    }

    public String getTitleWithUnderscores() {
        return titleWithUnderscores;
    }

    public void setTitleWithUnderscores(String titleWithUnderscores) {
        this.titleWithUnderscores = titleWithUnderscores;
    }

    public StringBuilder getLettersGuessed() {
        return lettersGuessed;
    }

    public void setLettersGuessed(String lettersGuessed) {
        this.lettersGuessed.append(lettersGuessed);
    }
}
