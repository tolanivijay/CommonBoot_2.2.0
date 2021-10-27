package com.opencsv.service;

import com.opencsv.CSVWriter;
import com.opencsv.bean.*;
import com.opencsv.model.Employee;
import com.sun.deploy.ref.Helpers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Component
public class CsvService {

    @Value("${csv-app.persist-dir}")
    private String persistPath;


    public String createCsv(List<Employee> emps){
        try{
            String path = persistPath +"\\emp_%s.csv";
            path = String.format(path,System.currentTimeMillis());
            Files.createFile(Paths.get(path));
            Writer writer  = new FileWriter(path.toString());

            ColumnPositionMappingStrategy<Employee> strategy = new MyStrategy<Employee>();
            strategy.setType(Employee.class);
            StatefulBeanToCsv<Employee> sbc = new StatefulBeanToCsvBuilder<Employee>(writer)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .withMappingStrategy(strategy)
                    .build();

            sbc.write(emps);
            writer.close();
            System.out.println("Writen employees to csv"+emps);
            return Paths.get(path).toString();
            //return true;
        }catch(Exception e){
            e.printStackTrace();
            return "Error";
        }

    }

    public List<Employee> getEmpsFromCsv(String csvPath){
        try{
            ColumnPositionMappingStrategy<Employee> strategy = new MyStrategy<Employee>();
            strategy.setType(Employee.class);
            Reader reader = Files.newBufferedReader(Paths.get(csvPath));
            CsvToBean csvBean = new CsvToBeanBuilder(reader)
                                    .withType(Employee.class)
                                    .withMappingStrategy(strategy)
                                    .withSkipLines(1)
                                    .build();
            return csvBean.parse();
        }catch (Exception e){
            System.out.println("Exception while fetching employees from CSV");
            e.printStackTrace();
            return null;
        }

    }

    private class MyStrategy<T> extends ColumnPositionMappingStrategy<T> {

        @Override
        public String[] generateHeader() {
            Map<String, BeanField> map = this.fieldMap;
            if (!CollectionUtils.isEmpty(map)){
                String[] returnValue = map.keySet().toArray(new String[0]);
                return returnValue;
            }
            String[] fields = {"TMP", "TMP", "TMP"};
            return fields;
        }
    }

}
