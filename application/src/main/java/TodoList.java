public class TodoList {

    int id;
    String newEntry;
    String date;

    public TodoList(int id, String newEntry, String date) {
        this.id = id;
        this.newEntry = newEntry;
        this.date = date;
    }

    @Override
    public String toString() {
        return "todolist{" +
                "id=" + id +
                ", newEntry='" + newEntry + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
