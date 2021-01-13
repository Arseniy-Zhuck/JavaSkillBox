import company.Company;
import man.Man;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Main {
    public static Calendar currentDate = new GregorianCalendar();
    public static List<Man> tops = new ArrayList<>();
    public static List<Man> managers = new ArrayList<>();
    public static List<Man> operators = new ArrayList<>();
    public static Calendar getRandomDate() {
        Double ran = Math.random();

        Calendar startDate = new GregorianCalendar();
        startDate.set(1970,0,1);
        Calendar finishDate = new GregorianCalendar();
        finishDate.set(2000,0,1);
        long r = ((long)(ran*(- startDate.getTimeInMillis() + finishDate.getTimeInMillis())))+startDate.getTimeInMillis();
        Calendar resCal = new GregorianCalendar();
        resCal.setTimeInMillis(r);
        return resCal;
    }

    public static void setTops(int count) {
        for (int i = 0; i < count; i++) {
            tops.add(new Man("Top"+i,"Name"+i,"LastName"+i,getRandomDate()));
        }
    }

    public static void setManagers(int count) {
        for (int i = 0; i < count; i++) {
            managers.add(new Man("Manager"+i,"Name"+i,"LastName"+i,getRandomDate()));
        }
    }


    public static void setOpers(int count) {
        for (int i = 0; i < count; i++) {
            operators.add(new Man("Operator"+i,"Name"+i,"LastName"+i,getRandomDate()));
        }
    }

    public static void main(String[] args) throws IOException {
        setTops(10);
        setManagers(80);
        setOpers(180);
        Company company = new Company("Company", 50000.0);
        company.hireAll(tops, "top");
        company.hireAll(managers, "manager");
        company.hireAll(operators, "oper");
        company.nextMonth();
        //company.getWorkers().stream().forEach((p) -> System.out.println(p));
        company.getTopSalaryStaff(10).stream().forEach(p -> System.out.println(p.printSalary()));
        company.getLowestSalatyStaff(30).stream().forEach(p -> System.out.println(p.printSalary()));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        tops.stream().limit(tops.size() / 2).forEach(p -> company.fire(p));
        managers.stream().limit(managers.size() /2).forEach(p -> company.fire(p));
        operators.stream().limit(operators.size() / 2).forEach(p -> company.fire(p));
        company.nextMonth();
        //company.getWorkers().stream().forEach((p) -> System.out.println(p));
        company.getTopSalaryStaff(10).stream().forEach(p -> System.out.println(p.printSalary()));
        company.getLowestSalatyStaff(30).stream().forEach(p -> System.out.println(p.printSalary()));

    }
}
