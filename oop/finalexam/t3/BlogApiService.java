package oop.finalexam.t3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BlogApiService {
    private String baseUrl;

    public BlogApiService(String baseUrl) {
        this.baseUrl = baseUrl;
        // Ensure URL ends with proper API path
        if (!this.baseUrl.contains("?api=")) {
            if (this.baseUrl.endsWith("/")) {
                this.baseUrl += "?api=";
            } else {
                this.baseUrl += "/?api=";
            }
        }
    }

    public List<BlogPost> getAllBlogs() throws IOException {
        String url = baseUrl + "blogs";
        String response = HttpUtil.sendGetRequest(url);

        List<BlogPost> blogs = new ArrayList<>();

        // NOTE: You'd parse the JSON response here with a library in a real app
        System.out.println("API Response: " + response);

        return blogs;
    }

    public boolean createBlog(String title, String content, String author) throws IOException {
        String url = baseUrl + "blogs";

        String jsonData = String.format(
                "{\"title\": \"%s\", \"content\": \"%s\", \"author\": \"%s\"}",
                escapeJson(title), escapeJson(content), escapeJson(author)
        );

        try {
            String response = HttpUtil.sendPostRequest(url, jsonData);
            System.out.println("Blog created successfully!");
            System.out.println("Response: " + response);
            return true;
        } catch (IOException e) {
            System.err.println("Error creating blog: " + e.getMessage());
            return false;
        }
    }

    public Statistics getStatistics() throws IOException {
        String url = baseUrl + "stats";
        String response = HttpUtil.sendGetRequest(url);

        Statistics stats = new Statistics();

        // NOTE: JSON parsing should go here
        System.out.println("Statistics Response: " + response);

        return stats;
    }

    private String escapeJson(String value) {
        if (value == null) return "";
        return value.replace("\"", "\\\"").replace("\n", "\\n").replace("\r", "\\r");
    }
}
