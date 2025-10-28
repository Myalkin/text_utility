package textutils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TextStats {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Использование: java TextStats <имя_файла> [--to-file]");
            return;
        }

        Path filePath = Path.of(args[0]);
        boolean toFile = args.length > 1 && args[1].equals("--to-file");

        try {
            List<String> lines = Files.readAllLines(filePath);
            int lineCount = lines.size();
            int wordCount = 0;
            int charCount = 0;

            for (String line : lines) {
                wordCount += line.split("\\s+").length;
                charCount += line.length();
            }

            String stats = String.format("""
                    Статистика для файла: %s
                    Строк: %d
                    Слов: %d
                    Символов: %d
                    """, filePath.getFileName(), lineCount, wordCount, charCount);

            if (toFile) {
                Files.writeString(Path.of("stats.txt"), stats);
                System.out.println("✅ Статистика сохранена в stats.txt");
            } else {
                System.out.println(stats);
            }

        } catch (IOException e) {
            System.out.println("Ошибка при обработке файла: " + e.getMessage());
        }
    }
}
