package exercise;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/3/16.
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setFirstName("Christoph");
        employee.setLastName("Stach");
        employee.setSalary(5000);
        employee.increaseSalaryBy(500);

        Apprentice apprentice = new Apprentice();
        apprentice.setFirstName(employee.getFirstName());
        apprentice.setLastName(employee.getLastName());
        apprentice.setSalary(employee.getSalary());
        apprentice.increaseSalaryBy(250);
        apprentice.setApprenticeshipDescription("Fachinformatiker Anwendungsentwicklung");
        apprentice.setApprenticeshipYear(2);

        System.out.println(employee);
        System.out.println(apprentice);
        System.out.println();
        System.out.println("Er ist ein " + apprentice.getApprenticeshipDescription() + " im Jahr " + apprentice.getApprenticeshipYear());
    }
}
