package org.pierre.moviecatalog;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class IMDBLoaderService {
    public List<IMDBRecord> loadAllIMDBRatings(String filename) throws IOException {
        Resource resource = new ClassPathResource(filename);
        InputStream inputStream = resource.getInputStream();
        Reader reader = new BufferedReader(new InputStreamReader(inputStream));
        CsvToBean<IMDBRecord> csvToBean = new CsvToBeanBuilder(reader).withType(IMDBRecord.class).withIgnoreLeadingWhiteSpace(true).build();
        List<IMDBRecord> imdbRecords = csvToBean.parse();
        return imdbRecords;
    }
}
