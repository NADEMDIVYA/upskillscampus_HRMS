public class ReportService implements ReportGenerator {

    private EmployeeService employeeService;
    private AttendanceService attendanceService;
    private LeaveService leaveService;

    // Constructor
    public ReportService(
            EmployeeService employeeService,
            AttendanceService attendanceService,
            LeaveService leaveService) {

        this.employeeService = employeeService;
        this.attendanceService = attendanceService;
        this.leaveService = leaveService;
    }

    // Generate all reports
    @Override
    public void generateReport() {

        employeeReport();

        attendanceReport();

        leaveReport();
    }

    // Employee Report
    public void employeeReport() {

        System.out.println("\n===== Employee Report =====");

        employeeService.displayEmployeeReport();

        System.out.println(
                "\nTotal Employees: "
                        + employeeService.getEmployeeCount());
    }

    // Attendance Report
    public void attendanceReport() {

        System.out.println("\n===== Attendance Report =====");

        int present =
                attendanceService.countByStatus("Present");

        int absent =
                attendanceService.countByStatus("Absent");

        System.out.println("Present: " + present);
        System.out.println("Absent: " + absent);
    }

    // Leave Report
    public void leaveReport() {

        System.out.println("\n===== Leave Report =====");

        int pending =
                leaveService.countByStatus("Pending");

        int approved =
                leaveService.countByStatus("Approved");

        int rejected =
                leaveService.countByStatus("Rejected");

        System.out.println("Pending Leaves: " + pending);
        System.out.println("Approved Leaves: " + approved);
        System.out.println("Rejected Leaves: " + rejected);
    }
}