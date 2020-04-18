package org.pierre.moviecatalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MoviecatalogApplication implements CommandLineRunner {
    @Autowired
    IMDBLoaderService imdbLoaderService;

    public static void main(String[] args) {
        SpringApplication.run(MoviecatalogApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<IMDBRecord> ratings = imdbLoaderService.loadAllIMDBRatings("ratings.csv");
        ratings.stream().forEach(imdbRecord -> {
            System.out.println(imdbRecord);
        });


    }
}
