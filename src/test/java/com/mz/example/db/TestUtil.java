package com.mz.example.db;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.springframework.data.repository.CrudRepository;

import java.util.Iterator;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestUtil {

    public static void assertNumberOfRecords(int expectedNumber, CrudRepository repository){
        int actualNumber = 0;
        Iterator it = repository.findAll().iterator();
        for(; it.hasNext(); ++actualNumber){}
        Assert.assertEquals(expectedNumber, actualNumber);
    }
}
