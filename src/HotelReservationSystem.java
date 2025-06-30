
import java.sql.*;
import java.util.Scanner;

public class HotelReservationSystem {
    private static final String url = "jdbc:mysql://localhost:3306/hostel_db";
    private static final String username = "root";
    private static final String password = "US0726unaiz@";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            while (true) {
                System.out.println();
                System.out.println("HOTEL MANAGEMENT SYSTEM");
                Scanner scanner = new Scanner(System.in);
                System.out.println("1. Reserve a room");
                System.out.println("2. View Reservations");
                System.out.println("3. Get Room Number");
                System.out.println("4. Update Reservation");
                System.out.println("5. Delete Reservation");
                System.out.println("0. Exit");

                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        reserveRoom(connection, scanner);
                        break;
                    case 2:
                        viewReservations(connection);
                        break;
                    case 3:
                        getRoomNumber(connection, scanner);
                        break;
                    case 4:
                        updateReservation(connection, scanner);
                        break;
                    case 5:
                        deleteReservations(connection, scanner);
                        break;
                    case 0:
                        exit();
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");

                }

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void reserveRoom(Connection connection, Scanner scanner) {
//        Statement statement = connection.createStatement();
//        int effectedRow = statement.executeUpdate("");

        try {
            System.out.print("Enter the Guest Name: ");
            String guestName = scanner.nextLine();

            System.out.print("Enter the Room Number: ");
            int roomNumber = scanner.nextInt();

            System.out.print("Enter the Contact Number: ");
            String contactNumber = scanner.next();

            String Query = "INSERT INTO reservations(guest_name,room_number,contact,number) VALUES('Alice Smith', 125, '9876543210');";

            Statement statement = connection.createStatement();


        }

    }

    public static void viewReservations(Connection connection) {

    }

    public static void getRoomNumber(Connection connection, Scanner scanner) {

    }

    public static void updateReservation(Connection connection, Scanner scanner) {

    }

    public static void deleteReservations(Connection connection, Scanner scanner) {

    }

    public static void exit() {

    }
}