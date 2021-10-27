package com.opencsv.service;

import com.opencsv.model.Employee;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {CsvService.class})
@ActiveProfiles("test")
class CsvServiceTest {

    @Autowired
    private CsvService service;

    @Value("${csv-app.persist-dir}")
    private String dir;

    @Test
    public void checkLogic(){
        assertNotNull(service);
        String path =service.createCsv(getEmps());
        List<Employee> returned = service.getEmpsFromCsv(path);
        assertEquals(returned.size(),2);
    }

    @AfterEach
    public void tearDown(){
        try{
            Files.list(Paths.get(dir)).forEach(
                    file -> {
                        try{
                            Files.deleteIfExists(file);
                        }catch (Exception e){
                            System.out.println("Exception deleting file "+file);
                        }
                    }
            );
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private List<Employee> getEmps(){
        List<Employee> empList = new ArrayList<Employee>();
        Employee e1 = new Employee();
        e1.setEmpId(1).setEmpName("Test1").setRegion("Test1");

        Employee e2 = new Employee();
        e2.setEmpId(2).setEmpName("Test2").setRegion("Test2");

        empList.add(e1);
        empList.add(e2);
        return empList;
    }

}