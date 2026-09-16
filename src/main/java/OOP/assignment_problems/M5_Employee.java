package OOP.assignment_problems;

class StaticEmployee {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    StaticEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class M5_Employee {
    public static void main(String[] args) {
        StaticEmployee e1 = new StaticEmployee("Divya", 65000);
        StaticEmployee e2 = new StaticEmployee("Arjun", 40000);
        StaticEmployee e3 = new StaticEmployee("Priya", 50000);

        StaticEmployee.printCompanyInfo();
    }
}