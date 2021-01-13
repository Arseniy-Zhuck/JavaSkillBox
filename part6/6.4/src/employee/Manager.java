package employee;


import company.Company;

public class Manager implements Employee{
    private Double percentSalary = 0.05;
    private Company company;
    private Double companyIncome;

    @Override
    public int hashCode() {
        return company.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Manager(Company company) {
        this.company = company;
    }

    public void setCompanyIncome() {
        companyIncome = 115000.0 + Math.random()*(25000.0);
    }

    @Override
    public Double getMonthSalary() {
        return company.getFixedSalary() + percentSalary*companyIncome;
    }

    public Double getCompanyIncome() {
        return companyIncome;
    }
}
