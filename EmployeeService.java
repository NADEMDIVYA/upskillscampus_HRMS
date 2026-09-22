import java.util.ArrayList;
import java.io.*;

public class EmployeeService {

    private ArrayList<Employee> employees = new ArrayList<>();

    private final String FILE_NAME = "employees.txt";

    // Constructor
    public EmployeeService() {
        loadEmployeesFromFile();
    }

    // Add Employee
    public void addEmployee(Employee employee) {

    if (employeeExists(employee.getEmployeeId())) {

        System.out.println(
                "\nEmployee ID already exists!"
        );

        return;
    }

    employees.add(employee);

    saveEmployeesToFile();

    System.out.println(
            "\nEmployee Added Successfully!"
    );
}

    // View Employees
    public void viewEmployees() {

        if (employees.isEmpty()) {

            System.out.println("\nNo Employees Found.");
            return;
        }

        System.out.println("\n===== Employee List =====");

        for (Employee emp : employees) {

            System.out.println(emp);
            System.out.println("-------------------------");
        }
    }

    // Search Employee by ID, Name, or Department
    public void searchEmployee(String searchType, String searchValue) {

        boolean found = false;

        for (Employee emp : employees) {

            if (searchType.equalsIgnoreCase("id")) {

                if (String.valueOf(emp.getEmployeeId())
                        .equals(searchValue)) {

                    System.out.println("\nEmployee Found:");
                    System.out.println(emp);
                    System.out.println("-------------------------");

                    found = true;
                }

            } else if (searchType.equalsIgnoreCase("name")) {

                if (emp.getName().equalsIgnoreCase(searchValue)) {

                    System.out.println("\nEmployee Found:");
                    System.out.println(emp);
                    System.out.println("-------------------------");

                    found = true;
                }

            } else if (searchType.equalsIgnoreCase("department")) {

                if (emp.getDepartment()
                        .equalsIgnoreCase(searchValue)) {

                    System.out.println("\nEmployee Found:");
                    System.out.println(emp);
                    System.out.println("-------------------------");

                    found = true;
                }
            }
        }

        if (!found) {

            System.out.println("\nEmployee Not Found.");
        }
    }

    // Update Employee
    public void updateEmployee(int employeeId,
                               String name,
                               String designation,
                               String department,
                               String contact) {

        for (Employee emp : employees) {

            if (emp.getEmployeeId() == employeeId) {

                emp.setName(name);
                emp.setDesignation(designation);
                emp.setDepartment(department);
                emp.setContact(contact);

                saveEmployeesToFile();

                System.out.println("\nEmployee Updated Successfully!");
                return;
            }
        }

        System.out.println("\nEmployee Not Found.");
    }

    // Delete Employee
    public void deleteEmployee(int employeeId) {

        Employee employeeToDelete = null;

        for (Employee emp : employees) {

            if (emp.getEmployeeId() == employeeId) {

                employeeToDelete = emp;
                break;
            }
        }

        if (employeeToDelete != null) {

            employees.remove(employeeToDelete);

            saveEmployeesToFile();

            System.out.println("\nEmployee Deleted Successfully!");

        } else {

            System.out.println("\nEmployee Not Found.");
        }
    }

    // Save Employees To File
    public void saveEmployeesToFile() {

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(FILE_NAME))) {

            for (Employee emp : employees) {

                writer.write(
                        emp.getEmployeeId() + "," +
                        emp.getName() + "," +
                        emp.getDesignation() + "," +
                        emp.getDepartment() + "," +
                        emp.getContact()
                );

                writer.newLine();
            }

        } catch (IOException e) {

            System.out.println(
                    "Error saving employees: "
                            + e.getMessage());
        }
    }

    // Load Employees From File
    private void loadEmployeesFromFile() {

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

                if (data.length == 5) {

                    Employee employee =
                            new Employee(
                                    Integer.parseInt(data[0]),
                                    data[1],
                                    data[2],
                                    data[3],
                                    data[4]
                            );

                    employees.add(employee);
                }
            }

        } catch (IOException e) {

            System.out.println(
                    "Error loading employees: "
                            + e.getMessage());

        } catch (NumberFormatException e) {

            System.out.println(
                    "Invalid employee data in file.");
        }
    }

    // Get Total Number of Employees
    public int getEmployeeCount() {

        return employees.size();
    }

    // Display Employee Report
    public void displayEmployeeReport() {

        if (employees.isEmpty()) {

            System.out.println("\nNo Employees Found.");
            return;
        }

        for (Employee emp : employees) {

            System.out.println("\nEmployee ID: "
                    + emp.getEmployeeId());

            System.out.println("Name: "
                    + emp.getName());

            System.out.println("Designation: "
                    + emp.getDesignation());

            System.out.println("Department: "
                    + emp.getDepartment());

            System.out.println("Contact: "
                    + emp.getContact());

            System.out.println("-------------------------");
        }
    }
    public boolean employeeExists(int employeeId) {

    for (Employee emp : employees) {

        if (emp.getEmployeeId() == employeeId) {

            return true;
        }
    }

    return false;
}
}