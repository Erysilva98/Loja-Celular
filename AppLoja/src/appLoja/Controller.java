package appLoja;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<Model> celulares;
    private String filePath;

    public Controller(String filePath) {
        this.celulares = new ArrayList<>();
        this.filePath = filePath;
    }

    public void create(String nome, String marca, double preco) {
        Model celular = new Model();
        celular.setNome(nome);
        celular.setMarca(marca);
        celular.setPreco(preco);

        celulares.add(celular);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            String data = nome + "," + marca + "," + preco;
            writer.write(data);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Model> read() {
        List<Model> celulares = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String nome = parts[0];
                String marca = parts[1];
                double preco = Double.parseDouble(parts[2]);

                Model celular = new Model();
                celular.setNome(nome);
                celular.setMarca(marca);
                celular.setPreco(preco);

                celulares.add(celular);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return celulares;
    }

    public void update(Model celular, String novoNome, String novaMarca, double novoPreco) {
        celular.setNome(novoNome);
        celular.setMarca(novaMarca);
        celular.setPreco(novoPreco);

        try {
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder inputBuffer = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String nome = parts[0];

                if (nome.equals(celular.getNome())) {
                    line = novoNome + "," + novaMarca + "," + novoPreco;
                }

                inputBuffer.append(line);
                inputBuffer.append('\n');
            }

            reader.close();
            String inputStr = inputBuffer.toString();

            FileOutputStream fileOut = new FileOutputStream(file);
            fileOut.write(inputStr.getBytes());
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(Model celular) {
        celulares.remove(celular);

        try {
            File file = new File(filePath);
            File tempFile = new File("temp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String lineToRemove = celular.getNome();
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String[] parts = currentLine.split(",");
                String nome = parts[0];

                if (nome.equals(lineToRemove))
                    continue;

                writer.write(currentLine + System.getProperty("line.separator"));
            }

            writer.close();
            reader.close();

            if (file.delete())
                tempFile.renameTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
