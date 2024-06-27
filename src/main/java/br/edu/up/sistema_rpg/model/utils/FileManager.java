package br.edu.up.sistema_rpg.model.utils;

import java.io.*;

public class FileManager {

    public FileManager(String filePath) { }

    public static void adicionarConteudo(String filePath, String conteudo) throws IOException {
        File file = new File("src/main/java/br/edu/up/sistema_rpg/model/utils/arquivos/" + filePath);

        // Verifica se o arquivo existe
        if (!file.exists()) {
            // Cria o arquivo se não existir
            file.createNewFile();
        }

        try (FileWriter fileWriter = new FileWriter("src/main/java/br/edu/up/sistema_rpg/model/utils/arquivos/" + filePath, true)) {
            fileWriter.write(conteudo + "\n");
        }
    }

    public static void editarConteudo(String filePath, String conteudoAntigo, String conteudoNovo) throws IOException {
        String fileContent = lerConteudo("src/main/java/br/edu/up/sistema_rpg/model/utils/arquivos/" + filePath);
        String newContent = fileContent.replace(conteudoAntigo, conteudoNovo);

        try (FileWriter fileWriter = new FileWriter("src/main/java/br/edu/up/sistema_rpg/model/utils/arquivos/" + filePath)) {
            fileWriter.write(newContent);
        }
    }

    public static void removerConteudo(String filePath, String conteudo) throws IOException {
        String fileContent = lerConteudo("src/main/java/br/edu/up/sistema_rpg/model/utils/arquivos/" + filePath);
        String newContent = fileContent.replaceAll(conteudo, "");

        try (FileWriter fileWriter = new FileWriter("src/main/java/br/edu/up/sistema_rpg/model/utils/arquivos/" + filePath)) {
            fileWriter.write(newContent);
        }
    }

    public static String lerConteudo(String filePath) throws IOException {
        StringBuilder fileContent = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line + "\n");
            }
        }

        return fileContent.toString();
    }
}
