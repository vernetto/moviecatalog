package org.pierre.moviecatalog;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.util.List;

public class IMDBLoaderService {
    public List<IMDBRecord> loadAllIMDBRatings(File file) throws FileNotFoundException {
        Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        CsvToBean<IMDBRecord> csvToBean = new CsvToBeanBuilder(reader).withType(IMDBRecord.class).withIgnoreLeadingWhiteSpace(true).build();
        List<IMDBRecord> imdbRecords = csvToBean.parse();
        return null;
    }
}
