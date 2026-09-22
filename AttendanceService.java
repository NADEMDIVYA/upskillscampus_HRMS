import java.util.ArrayList;
import java.io.*;

public class AttendanceService {

    private ArrayList<Attendance> attendanceList = new ArrayList<>();

    private final String FILE_NAME = "attendance.txt";

    public AttendanceService() {
        loadAttendanceFromFile();
    }

    // Mark Attendance
    public void markAttendance(Attendance attendance) {

        attendanceList.add(attendance);

        saveAttendanceToFile();

        System.out.println("\nAttendance Recorded Successfully!");
    }

    // View Attendance
    public void viewAttendance() {

        if (attendanceList.isEmpty()) {

            System.out.println("\nNo Attendance Records Found.");
            return;
        }

        System.out.println("\n===== Attendance Records =====");

        for (Attendance attendance : attendanceList) {

            System.out.println(attendance);
            System.out.println("-------------------------");
        }
    }

    // Save Attendance
    private void saveAttendanceToFile() {

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(FILE_NAME))) {

            for (Attendance attendance : attendanceList) {

                writer.write(
                        attendance.getEmployeeId() + "," +
                        attendance.getDate() + "," +
                        attendance.getStatus()
                );

                writer.newLine();
            }

        } catch (IOException e) {

            System.out.println(
                    "Error Saving Attendance: "
                            + e.getMessage());
        }
    }

    // Load Attendance
    private void loadAttendanceFromFile() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 3) {

                    Attendance attendance =
                            new Attendance(
                                    Integer.parseInt(data[0]),
                                    data[1],
                                    data[2]
                            );

                    attendanceList.add(attendance);
                }
            }

        } catch (IOException e) {

            System.out.println(
                    "Error Loading Attendance: "
                            + e.getMessage());
        }
    }
    // Get Total Attendance Records
public int getAttendanceCount() {

    return attendanceList.size();
}
// Count Attendance by Status
public int countByStatus(String status) {

    int count = 0;

    for (Attendance attendance : attendanceList) {

        if (attendance.getStatus().equalsIgnoreCase(status)) {

            count++;
        }
    }

    return count;
}
// Delete Attendance Records of an Employee
public void deleteAttendanceByEmployeeId(int employeeId) {

    attendanceList.removeIf(
            attendance ->
                    attendance.getEmployeeId() == employeeId
    );

    saveAttendanceToFile();
}
}