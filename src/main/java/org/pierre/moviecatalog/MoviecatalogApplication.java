package org.pierre.moviecatalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MoviecatalogApplication implements CommandLineRunner {
    EmuleService emuleService;
    IMDBLoaderService imdbLoaderService;
    @Autowired
    public MoviecatalogApplication(IMDBLoaderService imdbLoaderService, EmuleService emuleService) {
        this.imdbLoaderService = imdbLoaderService;
        this.emuleService = emuleService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MoviecatalogApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<IMDBRecord> ratings = imdbLoaderService.loadAllIMDBRatings("ratings.csv");
        ratings.stream().forEach(imdbRecord -> {
            System.out.println(imdbRecord);
        });
        List<EmuleRecord> emules = emuleService.loadEmulerecords("sampleemule.txt");
        emules.stream().forEach(emuleRecord -> {
            System.out.println(emuleRecord);
        });

    }
}
