package employee;

import company.Company;

public class TopManager implements Employee{
    private double topPercent = 1.5;
    private Company company;

    public TopManager(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    @Override
    public Double getMonthSalary() {
        return company.getIncome() > company.getTopManagerBorder() ?
                company.getFixedSalary() * (1 + topPercent) : company.getFixedSalary();
    }
}
