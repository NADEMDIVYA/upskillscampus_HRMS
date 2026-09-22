import java.util.Scanner;

public class Main {

    // Read an integer safely
    public static int readInt(Scanner sc, String message) {

        while (true) {

            System.out.print(message);

            String input = sc.nextLine();

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a number."
                );
            }
        }
    }

    // Read a non-empty string
    public static String readNonEmptyString(
            Scanner sc,
            String message) {

        while (true) {

            System.out.print(message);

            String input = sc.nextLine().trim();

            if (!input.isEmpty()) {

                return input;
            }

            System.out.println(
                    "Input cannot be empty. Please try again."
            );
        }
    }

    // Read attendance status
    public static String readAttendanceStatus(Scanner sc) {

        while (true) {

            System.out.print("Status (Present/Absent): ");

            String status = sc.nextLine().trim();

            if (status.equalsIgnoreCase("Present")) {

                return "Present";

            } else if (status.equalsIgnoreCase("Absent")) {

                return "Absent";
            }

            System.out.println(
                    "Invalid status. Please enter Present or Absent."
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AuthService authService = new AuthService();

        EmployeeService employeeService =
                new EmployeeService();

        AttendanceService attendanceService =
                new AttendanceService();

        LeaveService leaveService =
                new LeaveService();

        ReportService reportService =
                new ReportService(
                        employeeService,
                        attendanceService,
                        leaveService
                );

        // =========================
        // LOGIN
        // =========================

        System.out.println("===== HRMS Login =====");

        String username =
                readNonEmptyString(sc, "Username: ");

        String password =
                readNonEmptyString(sc, "Password: ");

        if (!authService.login(username, password)) {

            System.out.println(
                    "\nInvalid Username or Password!"
            );

            sc.close();
            return;
        }

        System.out.println("\nLogin Successful!");

        // =========================
        // MAIN MENU
        // =========================

        while (true) {

            System.out.println("\n=========================");
            System.out.println("          HRMS");
            System.out.println("=========================");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Mark Attendance");
            System.out.println("7. View Attendance");
            System.out.println("8. Add Leave Request");
            System.out.println("9. View Leave Requests");
            System.out.println("10. Approve Leave");
            System.out.println("11. Reject Leave");
            System.out.println("12. Reports");
            System.out.println("13. Exit");

            int choice =
                    readInt(sc, "Enter Choice: ");

            switch (choice) {

                // =========================
                // ADD EMPLOYEE
                // =========================

                case 1:

                    int id =
                            readInt(sc, "Employee ID: ");

                    String name =
                            readNonEmptyString(
                                    sc,
                                    "Name: "
                            );

                    String designation =
                            readNonEmptyString(
                                    sc,
                                    "Designation: "
                            );

                    String department =
                            readNonEmptyString(
                                    sc,
                                    "Department: "
                            );

                    String contact =
                            readNonEmptyString(
                                    sc,
                                    "Contact: "
                            );

                    Employee employee =
                            new Employee(
                                    id,
                                    name,
                                    designation,
                                    department,
                                    contact
                            );

                    employeeService.addEmployee(employee);

                    break;

                // =========================
                // VIEW EMPLOYEES
                // =========================

                case 2:

                    employeeService.viewEmployees();

                    break;

                // =========================
                // SEARCH EMPLOYEE
                // =========================

                case 3:

                    System.out.println(
                            "\n===== Search Employee ====="
                    );

                    System.out.println("1. Search by ID");
                    System.out.println("2. Search by Name");
                    System.out.println("3. Search by Department");

                    int searchChoice =
                            readInt(
                                    sc,
                                    "Enter Search Choice: "
                            );

                    switch (searchChoice) {

                        case 1:

                            String searchId =
                                    readNonEmptyString(
                                            sc,
                                            "Enter Employee ID: "
                                    );

                            employeeService.searchEmployee(
                                    "id",
                                    searchId
                            );

                            break;

                        case 2:

                            String searchName =
                                    readNonEmptyString(
                                            sc,
                                            "Enter Employee Name: "
                                    );

                            employeeService.searchEmployee(
                                    "name",
                                    searchName
                            );

                            break;

                        case 3:

                            String searchDepartment =
                                    readNonEmptyString(
                                            sc,
                                            "Enter Department: "
                                    );

                            employeeService.searchEmployee(
                                    "department",
                                    searchDepartment
                            );

                            break;

                        default:

                            System.out.println(
                                    "Invalid Search Choice."
                            );
                    }

                    break;

                // =========================
                // UPDATE EMPLOYEE
                // =========================

                case 4:

                    int updateId =
                            readInt(
                                    sc,
                                    "Enter Employee ID to Update: "
                            );

                    String newName =
                            readNonEmptyString(
                                    sc,
                                    "New Name: "
                            );

                    String newDesignation =
                            readNonEmptyString(
                                    sc,
                                    "New Designation: "
                            );

                    String newDepartment =
                            readNonEmptyString(
                                    sc,
                                    "New Department: "
                            );

                    String newContact =
                            readNonEmptyString(
                                    sc,
                                    "New Contact: "
                            );

                    employeeService.updateEmployee(
                            updateId,
                            newName,
                            newDesignation,
                            newDepartment,
                            newContact
                    );

                    break;

                // =========================
                // DELETE EMPLOYEE
                // =========================

                case 5:

                    int deleteId =
                            readInt(
                                    sc,
                                    "Enter Employee ID to Delete: "
                            );

                    employeeService.deleteEmployee(
                            deleteId
                    );
                    attendanceService
        .deleteAttendanceByEmployeeId(deleteId);

leaveService
        .deleteLeaveByEmployeeId(deleteId);

                    break;

                // =========================
                // MARK ATTENDANCE
                // =========================

                case 6:

                    int attendanceEmpId =
                            readInt(
                                    sc,
                                    "Employee ID: "
                            );

                    String date =
                            readNonEmptyString(
                                    sc,
                                    "Date (YYYY-MM-DD): "
                            );

                    String status =
                            readAttendanceStatus(sc);

                    Attendance attendance =
                            new Attendance(
                                    attendanceEmpId,
                                    date,
                                    status
                            );

                   // attendanceService.markAttendance( attendance );
if (employeeService.employeeExists(attendanceEmpId)) {

    attendanceService.markAttendance(attendance);

} else {

    System.out.println(
            "\nEmployee ID does not exist."
    );
}
                    break;

                // =========================
                // VIEW ATTENDANCE
                // =========================

                case 7:

                    attendanceService.viewAttendance();

                    break;

                // =========================
                // ADD LEAVE
                // =========================

                case 8:

                    int leaveId =
                            readInt(
                                    sc,
                                    "Leave ID: "
                            );

                    int leaveEmployeeId =
                            readInt(
                                    sc,
                                    "Employee ID: "
                            );

                    String leaveType =
                            readNonEmptyString(
                                    sc,
                                    "Leave Type: "
                            );

                    String startDate =
                            readNonEmptyString(
                                    sc,
                                    "Start Date (YYYY-MM-DD): "
                            );

                    String endDate =
                            readNonEmptyString(
                                    sc,
                                    "End Date (YYYY-MM-DD): "
                            );

                    LeaveRequest leaveRequest =
                            new LeaveRequest(
                                    leaveId,
                                    leaveEmployeeId,
                                    leaveType,
                                    startDate,
                                    endDate,
                                    "Pending"
                            );

                    //leaveService.addLeaveRequest(leaveRequest);
if (employeeService.employeeExists(leaveEmployeeId)) {

    leaveService.addLeaveRequest(leaveRequest);

} else {

    System.out.println(
            "\nEmployee ID does not exist."
    );
}
                    break;

                // =========================
                // VIEW LEAVES
                // =========================

                case 9:

                    leaveService.viewLeaveRequests();

                    break;

                // =========================
                // APPROVE LEAVE
                // =========================

                case 10:

                    int approveId =
                            readInt(
                                    sc,
                                    "Enter Leave ID to Approve: "
                            );

                    leaveService.approveLeave(
                            approveId
                    );

                    break;

                // =========================
                // REJECT LEAVE
                // =========================

                case 11:

                    int rejectId =
                            readInt(
                                    sc,
                                    "Enter Leave ID to Reject: "
                            );

                    leaveService.rejectLeave(
                            rejectId
                    );

                    break;

                // =========================
                // REPORTS
                // =========================
                case 12:

    System.out.println("\n===== Reports =====");

    System.out.println("1. Employee Report");
    System.out.println("2. Attendance Report");
    System.out.println("3. Leave Report");
    System.out.println("4. Generate All Reports");

    int reportChoice =
            readInt(
                    sc,
                    "Enter Report Choice: "
            );

    switch (reportChoice) {

        case 1:

            reportService.employeeReport();

            break;

        case 2:

            reportService.attendanceReport();

            break;

        case 3:

            reportService.leaveReport();

            break;

        case 4:

            reportService.generateReport();

            break;

        default:

            System.out.println(
                    "Invalid Report Choice."
            );
    }
                    break;

                // =========================
                // EXIT
                // =========================

                case 13:

                    System.out.println(
                            "\nThank You for Using HRMS!"
                    );

                    sc.close();

                    return;

                default:

                    System.out.println(
                            "\nInvalid Choice."
                    );
            }
        }
    }
}