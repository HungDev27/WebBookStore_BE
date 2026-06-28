package com.hungjava.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		loadEnv();
		SpringApplication.run(BookstoreApplication.class, args);
	}

	private static void loadEnv() {
		File envFile = new File(".env");
		if (envFile.exists()) {
			try {
				List<String> lines = Files.readAllLines(Paths.get(".env"));
				for (String line : lines) {
					line = line.trim();
					if (line.isEmpty() || line.startsWith("#")) {
						continue;
					}
					int separatorIdx = line.indexOf("=");
					if (separatorIdx > 0) {
						String key = line.substring(0, separatorIdx).trim();
						String value = line.substring(separatorIdx + 1).trim();
						// Remove surrounding quotes if any
						if (value.startsWith("\"") && value.endsWith("\"")) {
							value = value.substring(1, value.length() - 1);
						} else if (value.startsWith("'") && value.endsWith("'")) {
							value = value.substring(1, value.length() - 1);
						}
						System.setProperty(key, value);
					}
				}
			} catch (IOException e) {
				System.err.println("Không thể đọc file .env: " + e.getMessage());
			}
		}
	}

}
