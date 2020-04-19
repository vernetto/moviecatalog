package org.pierre.moviecatalog;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmuleService {
    public List<EmuleRecord> loadEmulerecords(String filename) throws IOException {
        Resource resource = new ClassPathResource(filename);
        InputStream inputStream = resource.getInputStream();

        List<String> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));) {
            list = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<EmuleRecord> result = new ArrayList<>();
        list.forEach(s -> {
            String[] items = s.split("\\|");
            if (items.length >= 6) {
                EmuleRecord newItem = new EmuleRecord();
                newItem.setProtocol(items[0]);
                newItem.setURL(items[1]);
                try {
                    newItem.setTitle(URLDecoder.decode(items[2], StandardCharsets.UTF_8.name()));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                newItem.setId1(items[3]);
                newItem.setId2(items[4]);
                newItem.setId3(items[5]);
                result.add(newItem);
            }
            else {
                System.out.println(items);
            }
        });

        return result;
    }

}
