import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemAdd {

    Connection connection = DbConnectionItems.getConnection();


        String date;
        String time;
        String nameOfTask;
        String description;
        String priority;


    public ItemAdd(Integer itemId, String date, String time, String nameOfTask, String description, String priority) throws SQLException, ClassNotFoundException {
    }


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



//    Constructor: prompting user to enter task date, time, name, description and priority (high, medium or low)

        public ItemAdd() throws SQLException, ClassNotFoundException {

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

            System.out.println("Date: " + this.date + newLine +
                    "Time: " + this.time + newLine + "Task: " + this.nameOfTask + newLine +
                    "Description: " + this.description + newLine +
                    "Priority: " + this.priority);
            System.out.println("=====================================");

        }


//    SimpleDateFormat will parse the given date and throws Exception if input is not valid

        public String getDate() {
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
            return this.date;
        }

        public String getTime() {
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
            return this.time;
        }

    @Override
    public String toString() {
        return "ItemAdd{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", nameOfTask='" + nameOfTask + '\'' +
                ", description='" + description + '\'' +
                ", priority='" + priority + '\''+
                '}';
    }


    List<ItemAdd> itemList () throws SQLException, ClassNotFoundException {


        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from items");
        List<ItemAdd> items = new ArrayList<ItemAdd>();
        while (resultSet.next()){

            Integer itemId = resultSet.getInt("id");
            String date = resultSet.getString("date");
            String time = resultSet.getString("time");
            String nameOfTask = resultSet.getString("nameOfTask");
            String description = resultSet.getString("description");
            String priority = resultSet.getString("priority");
            ItemAdd item = new ItemAdd (itemId, date, time, nameOfTask, description, priority);
            items.add(item);
        }
        return items;
    }

    void insertItem (ItemAdd item) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO items (date, time, nameOfTask, description, priority)";
        PreparedStatement preparedStatement = DbConnectionItems.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, item.getDate());
        preparedStatement.setString(2, item.getTime());
        preparedStatement.setString(3, item.getNameOfTask());
        preparedStatement.setString(4, item.getDescription());
        preparedStatement.setString(5, item.getPriority());
        preparedStatement.executeUpdate();
    }
}


