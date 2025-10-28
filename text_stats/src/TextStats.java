import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TextStats {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Использование: java TextStats ");
            return;
        }

        Path filePath = Path.of(args[0]);

        try {
            List<String> lines = Files.readAllLines(filePath);
            int lineCount = lines.size();
            int wordCount = 0;
            int charCount = 0;

            for (String line : lines) {
                wordCount += line.split("\\s+").length;
                charCount += line.length();
            }

            System.out.println("Статистика для файла: " + filePath);
            System.out.println("Строк: " + lineCount);
            System.out.println("Слов: " + wordCount);
            System.out.println("Символов: " + charCount);

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
