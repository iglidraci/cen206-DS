public class Process {
    private int id;
    private int workToDo = 100;

    public Process() {
    }

    public Process(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWorkToDo() {
        return workToDo;
    }
    public void doWork(int work) {
        this.workToDo -= work;
    }
    public boolean isFinished() {
        return this.workToDo <= 0;
    }

    @Override
    public String toString() {
        return "Process{" +
                "id=" + id +
                ", workToDo=" + workToDo +
                '}';
    }
}
