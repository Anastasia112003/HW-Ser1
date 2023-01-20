import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder mes = new StringBuilder();
        List<File> games = Arrays.asList(
                new File("C://Games"),
                new File("C://Games//src"),
                new File("C://Games//res"),
                new File("C://Games//saveGames"),
                new File("C://Games//temp"),
                new File("C://Games//res//drawables"),
                new File("C://Games//res//vectors"),
                new File("C://Games//res//icons"),
                new File("C://Games//src//test"),
                new File("C://Games//src//main")
        );

        List<File> gamesFails = Arrays.asList(
                new File("C://Games//temp//tmp.text"),
                new File("C://Games//src//main//Utils.java"),
                new File("C://Games//src//main//Main.java")
        );
        games.stream().forEach(g -> {
            if (g.mkdir()) mes.append(" Каталог " + g + " успешно создан ;");
            else mes.append(" Создание каталога " + g + " завершилось с ошибкой ;");
        });
        gamesFails.stream().forEach(gg -> {
            try {
                if (gg.createNewFile()) mes.append(" Файл " + gg + " был успешно создан ;");
                else mes.append(" Что-то пошло не так, файл " + " создать не удалось ;");
            } catch (IOException ex) {
                mes.append(ex.getMessage());
            }
        });


        try (FileWriter writer = new FileWriter("C://Games//temp//tmp.text", false)) {
            writer.write(mes.toString());
            writer.flush();
        } catch (IOException ex) {
            mes.append(ex.getMessage());
        }
        try (BufferedReader br = new BufferedReader(new FileReader("C://Games//temp//tmp.text"))) {
            String s;
            while ((s = br.readLine()) != null) System.out.println(s);
        } catch (IOException ex) {
            mes.append(ex.getMessage());
        }
    }


}

