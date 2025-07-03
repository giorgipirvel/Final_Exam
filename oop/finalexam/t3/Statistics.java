package oop.finalexam.t3;

public class Statistics {
    private int totalPosts;
    private int maxPosts;
    private int remainingPosts;
    private double percentageUsed;
    private boolean canAddMore;

    // Getters and setters
    public int getTotalPosts() {
        return totalPosts;
    }

    public void setTotalPosts(int totalPosts) {
        this.totalPosts = totalPosts;
    }

    public int getMaxPosts() {
        return maxPosts;
    }

    public void setMaxPosts(int maxPosts) {
        this.maxPosts = maxPosts;
    }

    public int getRemainingPosts() {
        return remainingPosts;
    }

    public void setRemainingPosts(int remainingPosts) {
        this.remainingPosts = remainingPosts;
    }

    public double getPercentageUsed() {
        return percentageUsed;
    }

    public void setPercentageUsed(double percentageUsed) {
        this.percentageUsed = percentageUsed;
    }

    public boolean isCanAddMore() {
        return canAddMore;
    }

    public void setCanAddMore(boolean canAddMore) {
        this.canAddMore = canAddMore;
    }

    @Override
    public String toString() {
        return String.format(
                "=== Blog Statistics ===\n" +
                        "Total Posts: %d\n" +
                        "Max Posts: %d\n" +
                        "Remaining Posts: %d\n" +
                        "Percentage Used: %.1f%%\n" +
                        "Can Add More: %s\n",
                totalPosts, maxPosts, remainingPosts, percentageUsed, canAddMore ? "Yes" : "No"
        );
    }
}
