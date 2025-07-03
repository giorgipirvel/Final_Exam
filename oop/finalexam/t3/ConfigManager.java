package oop.finalexam.t3;

import java.io.*;
import java.util.Properties;

public class ConfigManager {
    private static final String CONFIG_FILE = "config.txt";
    private Properties properties;

    public ConfigManager() {
        loadConfig();
    }

    private void loadConfig() {
        properties = new Properties();

        InputStream input = null;
        try {
            input = getClass().getClassLoader().getResourceAsStream(CONFIG_FILE);

            if (input == null) {
                File configFile = new File(CONFIG_FILE);
                if (configFile.exists()) {
                    input = new FileInputStream(configFile);
                } else {
                    createDefaultConfig();
                    input = new FileInputStream(CONFIG_FILE);
                }
            }

            properties.load(input);

        } catch (IOException e) {
            System.err.println("Error loading config file: " + e.getMessage());
            setDefaultProperties();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    System.err.println("Error closing config file: " + e.getMessage());
                }
            }
        }
    }

    private void createDefaultConfig() {
        try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
            writer.write("server.url=max.ge/final/t3/69384751/index.php\n");
            writer.write("bot.name=ChatBot Assistant\n");
            System.out.println("Created default config.txt file");
        } catch (IOException e) {
            System.err.println("Error creating default config file: " + e.getMessage());
        }
    }

    private void setDefaultProperties() {
        properties.setProperty("server.url", "max.ge/final/t3/69384751/index.php");
        properties.setProperty("bot.name", "ChatBot Assistant");
    }

    public String getServerUrl() {
        String url = properties.getProperty("server.url", "max.ge/final/t3/69384751/index.php");
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
        }
        return url;
    }

    public String getBotName() {
        return properties.getProperty("bot.name", "ChatBot Assistant");
    }
}
