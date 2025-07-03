package oop.finalexam.t3;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class BlogChatBot {
    private ConfigManager configManager;
    private BlogApiService apiService;
    private Scanner scanner;
    private String botName;

    public BlogChatBot() {
        configManager = new ConfigManager();
        apiService = new BlogApiService(configManager.getServerUrl());
        scanner = new Scanner(System.in);
        botName = configManager.getBotName();
    }

    public void start() {
        printWelcomeMessage();

        boolean running = true;
        while (running) {
            showMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    createNewBlogPost();
                    break;
                case "2":
                    viewAllBlogPosts();
                    break;
                case "3":
                    viewStatistics();
                    break;
                case "4":
                    showConfiguration();
                    break;
                case "5":
                    running = false;
                    System.out.println(botName + ": Goodbye! Thanks for using the blog management system!");
                    break;
                default:
                    System.out.println(botName + ": Invalid choice. Please try again.");
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
    }

    private void printWelcomeMessage() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║          " + botName + "           ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println();
        System.out.println("Welcome to Blog Management!");
        System.out.println("Server: " + configManager.getServerUrl());
        System.out.println();
    }

    private void showMenu() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println(botName + ": What would you like to do?");
        System.out.println("=".repeat(40));
        System.out.println("1. Create New Blog Post");
        System.out.println("2. View All Blog Posts");
        System.out.println("3. View Statistics");
        System.out.println("4. Show Configuration");
        System.out.println("5. Exit");
        System.out.println("=".repeat(40));
        System.out.print("Enter your choice (1-5): ");
    }

    private void createNewBlogPost() {
        System.out.println("\n" + botName + ": Let's create a new blog post!");
        System.out.println("-".repeat(40));

        System.out.print("Enter blog title: ");
        String title = scanner.nextLine().trim();

        if (title.isEmpty()) {
            System.out.println(botName + ": Title cannot be empty!");
            return;
        }

        System.out.print("Enter author name: ");
        String author = scanner.nextLine().trim();

        if (author.isEmpty()) {
            author = "Anonymous";
        }

        System.out.println("Enter blog content (type 'END' on a new line to finish):");
        StringBuilder content = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).equals("END")) {
            content.append(line).append("\n");
        }

        if (content.length() == 0) {
            System.out.println(botName + ": Content cannot be empty!");
            return;
        }

        System.out.println(botName + ": Creating your blog post...");

        try {
            boolean success = apiService.createBlog(title, content.toString().trim(), author);
            if (success) {
                System.out.println(botName + ": ✓ Blog post created successfully!");
            } else {
                System.out.println(botName + ": ✗ Failed to create blog post.");
            }
        } catch (IOException e) {
            System.out.println(botName + ": ✗ Error: " + e.getMessage());
        }
    }

    private void viewAllBlogPosts() {
        System.out.println("\n" + botName + ": Fetching all blog posts...");
        System.out.println("-".repeat(40));

        try {
            List<BlogPost> blogs = apiService.getAllBlogs();

            if (blogs.isEmpty()) {
                System.out.println(botName + ": No blog posts found or received raw API response above.");
            } else {
                System.out.println(botName + ": Found " + blogs.size() + " blog post(s):");
                System.out.println("=".repeat(50));

                for (int i = 0; i < blogs.size(); i++) {
                    System.out.println("Post #" + (i + 1));
                    System.out.println(blogs.get(i));
                    System.out.println("-".repeat(50));
                }
            }
        } catch (IOException e) {
            System.out.println(botName + ": ✗ Error fetching blog posts: " + e.getMessage());
        }
    }

    private void viewStatistics() {
        System.out.println("\n" + botName + ": Fetching blog statistics...");
        System.out.println("-".repeat(40));

        try {
            Statistics stats = apiService.getStatistics();
            System.out.println(botName + ": Here are the current statistics:");
            System.out.println(stats);
        } catch (IOException e) {
            System.out.println(botName + ": ✗ Error fetching statistics: " + e.getMessage());
        }
    }

    private void showConfiguration() {
        System.out.println("\n" + botName + ": Current Configuration:");
        System.out.println("-".repeat(40));
        System.out.println("Bot Name: " + configManager.getBotName());
        System.out.println("Server URL: " + configManager.getServerUrl());
        System.out.println("Config File: config.txt");
    }

    public static void main(String[] args) {
        try {
            BlogChatBot bot = new BlogChatBot();
            bot.start();
        } catch (Exception e) {
            System.err.println("Fatal error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
