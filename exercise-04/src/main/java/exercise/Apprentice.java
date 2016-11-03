package exercise;

/**
 * Bildet einen Auszubildenden ab
 *
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/3/16.
 */
public class Apprentice extends Employee {
    private String apprenticeshipDescription;
    private int apprenticeshipYear;

    /**
     * Konstruktor
     */
    public Apprentice() {
    }

    /**
     * Konstruktor
     *
     * @param firstName                 Vorname
     * @param lastName                  Nachname
     * @param salary                    Gehalt
     * @param apprenticeshipDescription Ausbildungsbeschreibung
     * @param apprenticeshipYear        Ausbildungsjahr
     */
    public Apprentice(String firstName, String lastName, double salary, String apprenticeshipDescription, int apprenticeshipYear) {
        super(firstName, lastName, salary);
        this.apprenticeshipDescription = apprenticeshipDescription;
        this.apprenticeshipYear = apprenticeshipYear;
    }

    /**
     * @return Auslbildungsbeschreibung
     */
    public String getApprenticeshipDescription() {
        return apprenticeshipDescription;
    }

    /**
     * @param apprenticeshipDescription Ausbildungsbeschreibung
     */
    public void setApprenticeshipDescription(String apprenticeshipDescription) {
        this.apprenticeshipDescription = apprenticeshipDescription;
    }

    /**
     * @return Ausbildungsjahr
     */
    public int getApprenticeshipYear() {
        return apprenticeshipYear;
    }

    /**
     * @param apprenticeshipYear Ausbildungsjahr
     */
    public void setApprenticeshipYear(int apprenticeshipYear) {
        this.apprenticeshipYear = apprenticeshipYear;
    }

    /**
     * @return Darstellung eines Auszubildenden
     */
    @Override
    public String toString() {
        return "Apprentice{" +
            "firstName='" + this.firstName + '\'' +
            ", lastName='" + this.lastName + '\'' +
            ", salary=" + this.salary +
            ", apprenticeshipDescription='" + apprenticeshipDescription + '\'' +
            ", apprenticeshipYear=" + apprenticeshipYear +
            '}';
    }
}
