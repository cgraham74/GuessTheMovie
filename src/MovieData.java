import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MovieData {

    static String selectRandomMovie() throws FileNotFoundException {
        String movie;
        File file = new File("listOfMovies.txt");
        List<String> movieList = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            movieList.add(scanner.nextLine());
        }
        Collections.shuffle(movieList);
        movie = movieList.subList(0,1).toString();
        return movie.substring(1, movie.length()-1);
    }
    //replace movie title letters with underscores and spaces
    static String convertMovie(String movie){
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


}
