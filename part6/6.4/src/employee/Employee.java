package employee;

public interface Employee extends Comparable<Employee>{
    Double getMonthSalary();

    @Override
    default int compareTo(Employee o) {
        return getMonthSalary().compareTo(o.getMonthSalary());
    }

    default String printSalary() {
        return getMonthSalary().toString();
    }
}
