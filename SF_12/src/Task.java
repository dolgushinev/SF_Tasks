abstract class Task {

    private int number;
    private String description;

    public Task() {
        this.number = 0;
        this.description = "Task description";
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
