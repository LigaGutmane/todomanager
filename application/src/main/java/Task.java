import java.text.SimpleDateFormat;
import java.util.Scanner;


public class Task {

    String date;
    String time;
    String nameOfTask;
    String description;
    String priority;
    int taskID;

//    getters and setters

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNameOfTask() {
        return nameOfTask;
    }

    public void setNameOfTask(String nameOfTask) {
        this.nameOfTask = nameOfTask;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }


//    Constructor: prompting user to enter task date, time, name, description and priority (high, medium or low)

    public Task() {

        Scanner scanner = new Scanner(System.in);

        getDate();

        getTime();

        System.out.println("Enter the name of the task: ");
        this.nameOfTask = scanner.nextLine();

        System.out.println("Enter a description of the task (optional): ");
        this.description = scanner.nextLine();

        System.out.println("Assign priority:\n1 - High\n2 - Medium\n3 - Low");
        this.priority = scanner.nextLine();

        String newLine = System.getProperty("line.separator");

        System.out.println("ID: " + this.taskID + newLine + "Date: " + this.date + newLine +
                "Time: " + this.time + newLine + "Task: " + this.nameOfTask + newLine +
                "Description: " + this.description + newLine +
                "Priority: " + this.priority);
        System.out.println("=====================================");

    }


//    SimpleDateFormat will parse the given date and throws Exception if input is not valid

    public void getDate() {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat date1 = new SimpleDateFormat("dd/MM/yyyy");
        date1.setLenient(false);
        System.out.println("Enter a date (dd/mm/yyyy): ");
        this.date = scanner.nextLine();
        try {
            date1.parse(this.date);
        } catch (Exception e) {
            System.out.println(this.date + " is not a valid date");
        }
    }

    public void getTime() {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat time1 = new SimpleDateFormat("HH:mm");
        time1.setLenient(false);
        System.out.println("Enter a time (hh:mm): ");
        this.time = scanner.nextLine();
        try {
            time1.parse(this.time);
        } catch (Exception e) {
            System.out.println(this.time + " is not a valid time");
        }
    }


    //    Generate an ID
    public void setTaskID() {
//        Every time when adding a new task, ID is incremented by one
        this.taskID++;
        System.out.println(this.taskID);
    }


}


