import java.util.regex.Pattern;

public class EMail implements Comparable{
    private String address;

    public EMail(String address) {
        this.address = address;
    }

    public static boolean isEMail(String mayBeEMail) {
        return Pattern.compile("([A-Za-z0-9][\\w-]*\\.)*[\\w-]*[A-Za-z0-9]@([A-Za-z0-9][\\w-]*\\.){1,2}[A-Za-z]{2,11}").matcher(mayBeEMail).matches();
    }

    public String getAddress() {
        return address;
    }

    @Override
    public int hashCode() {
        return address.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof EMail) {
            return address.equals((String) obj);
        } else return false;
    }

    @Override
    public String toString() {
        return address;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof EMail) {
            return address.compareTo(((EMail) o).getAddress());
        } else throw new IllegalArgumentException();
    }
}
