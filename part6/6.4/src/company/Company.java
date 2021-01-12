package company;

import employee.Employee;
import employee.Manager;
import man.Man;
import man.Working;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private List<Working> workers = new ArrayList<>();
    private Double fixedSalary;
    private Double income;

    public Company(String name, Double fixedSalary) {
        this.name = name;
        this.fixedSalary = fixedSalary;
    }

    public void hire(Man man, String post) throws IllegalArgumentException{
        Employee employee;
        switch (post) {
            case "manager": employee = new Manager(this); break;
            default: throw new IllegalArgumentException();
        }
        workers.add(new Working(man, employee));
    }

    private void setIncome() {
        income = workers.stream().filter((p) -> (p.getEmployee() instanceof Manager)).mapToDouble()
    }


    public void hireAll(List<Man> people, ) {}
    public void fire() {}
    public double getIncome() {
        return income;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        List<Employee> result = new ArrayList<>();
        return result;
    }

    public List<Employee> getLowestSalatyStaff(int count) {
        List<Employee> result = new ArrayList<>();
        return result;
    }


    public Double getFixedSalary() {
        return fixedSalary;
    }
}
