import java.util.ArrayList;
import java.io.*;

public class LeaveService {

    private ArrayList<LeaveRequest> leaveRequests =
            new ArrayList<>();

    private final String FILE_NAME = "leaves.txt";

    // Constructor
    public LeaveService() {
        loadLeavesFromFile();
    }

    // Add Leave Request
    public void addLeaveRequest(LeaveRequest leaveRequest) {

        leaveRequests.add(leaveRequest);

        saveLeavesToFile();

        System.out.println("\nLeave Request Added Successfully!");
    }

    // View Leave Requests
    public void viewLeaveRequests() {

        if (leaveRequests.isEmpty()) {

            System.out.println("\nNo Leave Requests Found.");
            return;
        }

        System.out.println("\n===== Leave Requests =====");

        for (LeaveRequest leave : leaveRequests) {

            System.out.println(leave);
            System.out.println("-------------------------");
        }
    }

    // Approve Leave
    public void approveLeave(int leaveId) {

        for (LeaveRequest leave : leaveRequests) {

            if (leave.getLeaveId() == leaveId) {

                leave.setStatus("Approved");

                saveLeavesToFile();

                System.out.println(
                        "\nLeave Approved Successfully!");

                return;
            }
        }

        System.out.println("\nLeave Request Not Found.");
    }

    // Reject Leave
    public void rejectLeave(int leaveId) {

        for (LeaveRequest leave : leaveRequests) {

            if (leave.getLeaveId() == leaveId) {

                leave.setStatus("Rejected");

                saveLeavesToFile();

                System.out.println(
                        "\nLeave Rejected Successfully!");

                return;
            }
        }

        System.out.println("\nLeave Request Not Found.");
    }

    // Save Leave Requests
    private void saveLeavesToFile() {

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(FILE_NAME))) {

            for (LeaveRequest leave : leaveRequests) {

                writer.write(
                        leave.getLeaveId() + "," +
                        leave.getEmployeeId() + "," +
                        leave.getLeaveType() + "," +
                        leave.getStartDate() + "," +
                        leave.getEndDate() + "," +
                        leave.getStatus()
                );

                writer.newLine();
            }

        } catch (IOException e) {

            System.out.println(
                    "Error Saving Leave Requests: "
                            + e.getMessage());
        }
    }

    // Load Leave Requests
    private void loadLeavesFromFile() {

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

                if (data.length == 6) {

                    LeaveRequest leaveRequest =
                            new LeaveRequest(
                                    Integer.parseInt(data[0]),
                                    Integer.parseInt(data[1]),
                                    data[2],
                                    data[3],
                                    data[4],
                                    data[5]
                            );

                    leaveRequests.add(leaveRequest);
                }
            }

        } catch (IOException e) {

            System.out.println(
                    "Error Loading Leave Requests: "
                            + e.getMessage());
        }
    }
    // Count Leave Requests by Status
public int countByStatus(String status) {

    int count = 0;

    for (LeaveRequest leave : leaveRequests) {

        if (leave.getStatus().equalsIgnoreCase(status)) {

            count++;
        }
    }

    return count;
}

// Delete Leave Records of an Employee
public void deleteLeaveByEmployeeId(int employeeId) {

    leaveRequests.removeIf(
            leave ->
                    leave.getEmployeeId() == employeeId
    );

    saveLeavesToFile();
}
}