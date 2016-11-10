package exercise;

/**
 * Bildet einen Mitarbeiter ab
 *
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/3/16.
 */
public class Employee {
    protected String firstName;
    protected String lastName;
    protected double salary;

    /**
     * Konstruktor
     */
    public Employee() {
    }

    /**
     * Konstruktor
     *
     * @param firstName Vorname
     * @param lastName  Nachname
     * @param salary    Gehalt
     */
    public Employee(String firstName, String lastName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.setSalary(salary);
    }

    /**
     * @return Vorname
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName Vorname
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return Nachname
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName Nachname
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return Gehalt
     */
    public double getSalary() {
        return salary;
    }

    /**
     * @param salary Gehalt
     */
    public void setSalary(double salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("Salary must be greater 0");
        }

        this.salary = salary;
    }

    /**
     * Erhoeht das Gehalt um einen absoluten Wert
     *
     * @param value Wert der Gehaltserhoehung
     */
    public void increaseSalaryBy(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Salary increase must be greater 0");
        }

        this.salary += value;
    }

    /**
     * @return Darstellung eines Mitarbeiters
     */
    @Override
    public String toString() {
        return "Employee{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", salary=" + salary +
            '}';
    }
}
