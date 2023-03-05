public class BrowserHistory {
    private Stack<String> forward;
    private Stack<String> backward;
    private String currentUrl;
    public BrowserHistory(String homepage) {
        this.forward = new LinkedStack<>();
        this.backward = new ArrayStack<>();
        this.currentUrl = homepage;
    }
    public void visit(String url) {
        this.backward.push(this.currentUrl);
        this.currentUrl = url;
        this.forward = new LinkedStack<>();

    }
    public String back(int steps) {
        while (steps > 0 && !this.backward.isEmpty()) {
            this.forward.push(this.currentUrl);
            this.currentUrl = this.backward.pop();
            steps--;
        }
        return this.currentUrl;
    }
    public String forward(int steps) {
        while (steps > 0 && !this.forward.isEmpty()) {
            this.backward.push(this.currentUrl);
            this.currentUrl = this.forward.pop();
            steps--;
        }
        return this.currentUrl;
    }
    @Override
    public String toString() {
        return String.format("You are now at link \"%s\"", this.currentUrl);
    }
}
