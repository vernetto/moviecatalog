package org.pierre.moviecatalog;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class IMDBRecord {

    @CsvBindByName(column = "Const")
    String filmId;
    @CsvBindByName(column = "Your Rating")
    String yourRating;
    @CsvBindByName(column = "Date Rated")
    String dateRated;
    @CsvBindByName(column = "Title")
    String title;
    @CsvBindByName(column = "URL")
    String URL;
    @CsvBindByName(column = "Title Type")
    String  titleType;
    @CsvBindByName(column = "IMDb Rating")
    String  IMDbRating;
    @CsvBindByName(column = "Runtime (mins)")
    String runtimeMins;
    @CsvBindByName(column = "Year")
    String year;
    @CsvBindByName(column = "Genres")
    String genres;
    @CsvBindByName(column = "Num Votes")
    String numVotes;
    @CsvBindByName(column = "Release Date")
    String releaseDate;
    @CsvBindByName(column = "Directors")
    String directors;
}
