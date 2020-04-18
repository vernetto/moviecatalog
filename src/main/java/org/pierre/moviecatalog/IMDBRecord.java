package org.pierre.moviecatalog;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class IMDBRecord {

    @CsvBindByName
    String Const;
    @CsvBindByName
    String Your_Rating;
    @CsvBindByName
    String Date_Rated;
    @CsvBindByName
    String Title;
    @CsvBindByName
    String URL;
    @CsvBindByName
    String  Title_Type;
    @CsvBindByName
    String  IMDb_Rating;
    @CsvBindByName
    String Runtime_mins;
    @CsvBindByName
    String Year;
    @CsvBindByName
    String Genres;
    @CsvBindByName
    String Num_Votes;
    @CsvBindByName
    String Release_Date;
    @CsvBindByName
    String Directors;
}
