package company;

import employee.Employee;
import employee.Manager;
import employee.Operator;
import employee.TopManager;
import man.Man;
import man.Working;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Company {
    private String name;
    private List<Working> workers = new ArrayList<>();
    private Double fixedSalary;
    private Double income;
    private Double topManagerBorder = 10000000.0;

    public List<Working> getWorkers() {
        return workers;
    }

    public Company(String name, Double fixedSalary) {
        this.name = name;
        this.fixedSalary = fixedSalary;
    }

    public void hire(Man man, String post) throws IllegalArgumentException{
        Employee employee;
        switch (post) {
            case "manager": employee = new Manager(this); break;
            case "top": employee = new TopManager(this); break;
            case "oper": employee = new Operator(this); break;
            default: throw new IllegalArgumentException();
        }
        workers.add(new Working(man, employee));
    }

    public void nextMonth() {
        workers.stream().filter((p) -> (p.getEmployee() instanceof Manager)).map(Working::getEmployee).
                forEach((p) -> {
                    Manager p1 = (Manager) p;
                    p1.setCompanyIncome();
                });
        setIncome();
    }

    private void setIncome() {
        income = workers.stream().filter((p) -> (p.getEmployee() instanceof Manager)).map(Working::getEmployee).
                mapToDouble(Employee::getMonthSalary).map(p -> (p - fixedSalary)/0.05).sum();
    }


    public void hireAll(List<Man> people, String post) {
        for (Man person : people) {
            hire(person, post);
        }
    }

    public void fire(Man man) {
        workers.remove(new Working(man));
    }

    public double getIncome() {
        return income;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        return workers.stream().map(Working::getEmployee).sorted((o1, o2) -> -o1.compareTo(o2)).
                limit(count).collect(Collectors.toList());
    }

    public List<Employee> getLowestSalatyStaff(int count) {
        return workers.stream().map(Working::getEmployee).sorted().limit(count).collect(Collectors.toList());
    }

    public Double getFixedSalary() {
        return fixedSalary;
    }

    public Double getTopManagerBorder() {
        return topManagerBorder;
    }
}
