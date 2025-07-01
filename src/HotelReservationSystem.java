
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class HotelReservationSystem {
    private static final String url = "jdbc:mysql://localhost:3306/hotel_db";
    private static final String username = "root";
    private static final String password = "US0726unaiz@";
    private static Connection connection;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            HotelReservationSystem.connection = DriverManager.getConnection(url, username, password);

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
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        reserveRoom(scanner);
                        break;
                    case 2:
                        viewReservations();
                        break;
                    case 3:
                        getRoomNumber(scanner);
                        break;
                    case 4:
                        updateReservation(scanner);
                        break;
                    case 5:
                        deleteReservations(scanner);
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

    public static void reserveRoom(Scanner scanner) throws SQLException {
        System.out.print("Enter the Guest Name: ");
        String guestName = scanner.nextLine();
        System.out.print("Enter the Room Number: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the Contact Number: ");
        String contactNumber = scanner.nextLine().trim();

        String query = "INSERT INTO reservations(guest_name, room_number, contact_number) VALUES('" + guestName + "'," + roomNumber + ", '" + contactNumber + "');";
        try {

            Statement statement = connection.createStatement();
            int effectedRow = statement.executeUpdate(query);
            if (effectedRow > 0) {
                System.out.println("Reservation Successful.");
            } else {
                System.out.println("Reservation Failed.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void viewReservations() throws SQLException {
        String query = "SELECT * FROM reservations;";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            String listInfo = resultSet.next() ? "\n------Reservation List------\n" : "\n------Reservation List is Empty.\n";
            System.out.println(listInfo);

            while (resultSet.next()) {
                int reservationId = resultSet.getInt("reservation_id");
                String guestName = resultSet.getString("guest_name");
                int roomNumber = resultSet.getInt("room_number");
                String contactNumber = resultSet.getString("contact_number");
                String reservationDate = resultSet.getTimestamp("reservation_date").toString();

                System.out.println("Reservation Id: " + reservationId);
                System.out.println("Guest Name: " + guestName);
                System.out.println("Room Number: " + roomNumber);
                System.out.println("Contact Number: " + contactNumber);
                System.out.println("Reservation Date: " + reservationDate);
                System.out.println("---------------------------------------------------------------------\n");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return;
        }

    }

    public static void getRoomNumber(Scanner scanner) {

    }

    public static void updateReservation(Scanner scanner) {

    }

    public static void deleteReservations(Scanner scanner) {

    }

    public static void exit() {

    }
}