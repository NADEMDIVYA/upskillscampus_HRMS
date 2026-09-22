public class Employee {

    private int employeeId;
    private String name;
    private String designation;
    private String department;
    private String contact;

    public Employee(int employeeId, String name, String designation,
                    String department, String contact) {

        this.employeeId = employeeId;
        this.name = name;
        this.designation = designation;
        this.department = department;
        this.contact = contact;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public String getDepartment() {
        return department;
    }

    public String getContact() {
        return contact;
    }
    public void setName(String name) {
    this.name = name;
}

public void setDesignation(String designation) {
    this.designation = designation;
}

public void setDepartment(String department) {
    this.department = department;
}

public void setContact(String contact) {
    this.contact = contact;
}

    @Override
    public String toString() {
        return "\nEmployee ID: " + employeeId +
               "\nName: " + name +
               "\nDesignation: " + designation +
               "\nDepartment: " + department +
               "\nContact: " + contact;
    }
}