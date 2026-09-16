package constructors.class_problems;

class PayrollEmployee {
    String empId;
    double salary;

    PayrollEmployee(String empId, double salary) {
        this.empId = empId;
        this.salary = salary;
    }

    void raiseSalary(double salary) {
        this.salary += salary;
    }
}

public class M2_PayrollBonus {
    public static void main(String[] args) {
        PayrollEmployee[] employees = new PayrollEmployee[4];
        employees[0] = new PayrollEmployee("E-101", 40000);
        employees[1] = new PayrollEmployee("E-102", 55000);
        employees[2] = new PayrollEmployee("E-103", 62000);
        employees[3] = new PayrollEmployee("E-104", 48000);

        for (PayrollEmployee emp : employees) {
            emp.raiseSalary(5000);
            System.out.println(emp.empId + " | Final Salary: Rs " + emp.salary);
        }
    }
}