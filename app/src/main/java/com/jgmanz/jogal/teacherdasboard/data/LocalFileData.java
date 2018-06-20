package com.jgmanz.jogal.teacherdasboard.data;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class LocalFileData {

    public static void saveFile(String filename, String content, Context con) throws IOException {
        FileOutputStream fos = con.openFileOutput(filename, Context.MODE_PRIVATE);
        fos.write(content.getBytes());
        fos.close();
    }

    public static String readFile(String filename, Context con) throws IOException {
        File directory = con.getFilesDir();
        File file = new File(directory, filename);
        FileInputStream stream = con.openFileInput(filename);

        InputStreamReader inputStreamReader = new InputStreamReader(stream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }
}
