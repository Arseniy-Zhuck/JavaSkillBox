package man;

import employee.Employee;

public class Working {
    private Man man;
    private Employee employee;

    public Working(Man man) {
        this.man = man;
    }

    public Working(Man man, Employee employee) {
        this.man = man;
        this.employee = employee;
    }

    public Man getMan() {
        return man;
    }

    public Employee getEmployee() {
        return employee;
    }

    @Override
    public int hashCode() {
        return man.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Working) {
            Working working = (Working) obj;
            Man man1 = working.getMan();
            return man.equals(man1);
        } else return false;
    }
}
