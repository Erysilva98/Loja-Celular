package dao;

import java.io.*;

import model.User;

public class FileUserDao {
    private static final String FILE_PATH = "users.txt";

    public void save(User user) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(user.getName());
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Implemente os demais métodos do CRUD (update, delete, etc.) de acordo com as suas necessidades
}

