package com.spartaglobal.finalweek.util.dbmanager;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;

public class ResetData {
    public static void resetData() {
        Connection connection = ConnectionManager.openConnection();
        ScriptRunner sr = new ScriptRunner(connection);
        Reader reader;

        {
            try {
                reader = new BufferedReader(new FileReader("C:\\Users\\joshu\\Documents\\Work\\Sparta Global\\Week 10 & 12 - Final Project\\sparta-final-project\\src\\test\\resources\\courseorganisationFinal .sql"));
                sr.runScript(reader);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
