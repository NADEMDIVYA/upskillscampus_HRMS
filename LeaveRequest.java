public class LeaveRequest {

    private int leaveId;
    private int employeeId;
    private String leaveType;
    private String startDate;
    private String endDate;
    private String status;

    // Constructor
    public LeaveRequest(int leaveId,
                        int employeeId,
                        String leaveType,
                        String startDate,
                        String endDate,
                        String status) {

        this.leaveId = leaveId;
        this.employeeId = employeeId;
        this.leaveType = leaveType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    // Getters
    public int getLeaveId() {
        return leaveId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getStatus() {
        return status;
    }

    // Setter for status
    public void setStatus(String status) {
        this.status = status;
    }

    // Display Leave Request
    @Override
    public String toString() {

        return "\nLeave ID: " + leaveId +
               "\nEmployee ID: " + employeeId +
               "\nLeave Type: " + leaveType +
               "\nStart Date: " + startDate +
               "\nEnd Date: " + endDate +
               "\nStatus: " + status;
    }
}