package man;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Man {
    private String surName, name, lastName;
    private Calendar dateOfBirth;



    public Man(String surName, String name, String lastName, Calendar dateOfBirth) {
        this.surName = surName;
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getSurName() {
        return surName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public int hashCode() {
        return
                surName.hashCode() + name.hashCode() + lastName.hashCode() + dateOfBirth.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Man) {
            Man man1 = (Man) obj;
            return name.equals(man1.getName()) &&
                    surName.equals(man1.surName) &&
                    lastName.equals(man1.lastName) &&
                    dateOfBirth.equals(man1.dateOfBirth);
        } else return false;
    }

    @Override
    public String toString() {
        SimpleDateFormat sDF = new SimpleDateFormat("yyyy.MM.dd");

        return surName + " " + name.toCharArray()[0] + ". " + lastName.toCharArray()[0] + ". " +
                sDF.format(dateOfBirth.getTime());
    }
}
