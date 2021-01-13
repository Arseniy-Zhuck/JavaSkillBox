package employee;

import company.Company;

public class Operator implements Employee{
    private Company company;

    public Operator(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    @Override
    public Double getMonthSalary() {
        return company.getFixedSalary();
    }
}
