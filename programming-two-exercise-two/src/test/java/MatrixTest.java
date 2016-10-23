import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit-Tests für Matritzen
 *
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 17.10.2016
 */
public class MatrixTest {
    private Matrix matrix;

    @Before
    public void setUp() {
        this.matrix = new Matrix(
            new double[][]{
                new double[]{1, 2, 3},
                new double[]{4, 5, 6},
                new double[]{7, 8, 9}
            }
        );
    }

    @After
    public void tearDown() {

    }

    /**
     * Testet ob der Konstruktor bei falschen Argumenten eine Exception wirft
     * Grenzfall
     */
    @Test(expected = IllegalArgumentException.class)
    public void setTableExceptionOnWrongTable() {
        this.matrix.setTable(
            new double[][]{
                new double[]{1, 2, 3},
                new double[]{4, 5, 6},
                new double[]{7, 9}
            }
        );
    }

    /**
     * Testet ob der Konstruktor bei einer leeren Tabelle eine Exception wirft
     * Grenzfall
     */
    @Test(expected = IllegalArgumentException.class)
    public void setTableExceptionOnEmptyTable() {
        this.matrix.setTable(
            new double[][]{}
        );
    }

    /**
     * Testet ob das Multiplizieren zweier Matrizen korrekt funktioniert
     */
    @Test
    public void multiply() {
        // Normaler Fall
        Assert.assertTrue(
            this.matrix.multiply(
                new Matrix(
                    new double[][]{
                        new double[]{1, 2, 3},
                        new double[]{4, 5, 6},
                        new double[]{7, 8, 9}
                    }
                )
            ).equals(
                new Matrix(
                    new double[][]{
                        new double[]{30, 36, 42},
                        new double[]{66, 81, 96},
                        new double[]{102, 126, 150}
                    }
                )
            )
        );

        // Bester Fall
        Assert.assertFalse(
            this.matrix.multiply(
                new Matrix(
                    new double[][]{
                        new double[]{1, 2, 3},
                        new double[]{4, 5, 6},
                        new double[]{7, 8, 9}
                    }
                )
            ).equals(
                new Matrix(
                    new double[][]{
                        new double[]{1, 1, 1},
                        new double[]{1, 1, 1},
                        new double[]{1, 1, 1}
                    }
                )
            )
        );
    }

    /**
     * Testet ob die bei einer Falschen Matrix eine Exception geworfen wird
     * Grenzfall
     */
    @Test(expected = IllegalArgumentException.class)
    public void multiplyExceptionOnWrongMatrix() {
        this.matrix.multiply(
            new Matrix(
                new double[][]{
                    new double[]{1, 2, 3},
                    new double[]{4, 5, 6}
                }
            )
        );
    }

    /**
     * Testet ob das Addieren zweier Matrizen korrekt funktioniert
     */
    @Test
    public void add() {
        // Normaler Fall
        Assert.assertTrue(
            this.matrix.add(
                new Matrix(
                    new double[][]{
                        new double[]{1, 2, 3},
                        new double[]{4, 5, 6},
                        new double[]{7, 8, 9}
                    }
                )
            ).equals(
                new Matrix(
                    new double[][]{
                        new double[]{2, 4, 6},
                        new double[]{8, 10, 12},
                        new double[]{14, 16, 18}
                    }
                )
            )
        );

        // Normaler Fall
        Assert.assertTrue(
            this.matrix.add(
                new Matrix(
                    new double[][]{
                        new double[]{-1, -2, -3},
                        new double[]{-4, -5, -6},
                        new double[]{-7, -8, -9}
                    }
                )
            ).equals(
                new Matrix(
                    new double[][]{
                        new double[]{0, 0, 0},
                        new double[]{0, 0, 0},
                        new double[]{0, 0, 0}
                    }
                )
            )
        );

        // Bester Fall
        Assert.assertFalse(
            this.matrix.add(
                new Matrix(
                    new double[][]{
                        new double[]{-1, -2, -3},
                        new double[]{-4, -5, -6},
                        new double[]{-7, -8, -9}
                    }
                )
            ).equals(
                new Matrix(
                    new double[][]{
                        new double[]{1, 0, 0},
                        new double[]{0, 0, 0},
                        new double[]{0, 0, 0}
                    }
                )
            )
        );
    }

    /**
     * Test ob die Methode eine Exception wirft falls zwei Matrizen mit unterschiedlichen größen addiert werden
     * Grenzfall
     */
    @Test(expected = IllegalArgumentException.class)
    public void addExceptionOnWrongMatrix() {
        this.matrix.add(
            new Matrix(
                new double[][]{
                    new double[]{1, 2},
                    new double[]{3, 4}
                }
            )
        );
    }

    /**
     * Testet ob die das Vergleichen zweier Matrizen korrekt funktioniert
     */
    @Test
    public void equals() {
        // Normaler Fall
        Assert.assertTrue(this.matrix.equals(
            new Matrix(
                new double[][]{
                    new double[]{1, 2, 3},
                    new double[]{4, 5, 6},
                    new double[]{7, 8, 9}
                }
            )
        ));

        // Bester Fall
        Assert.assertFalse(this.matrix.equals(
            new Matrix(
                new double[][]{
                    new double[]{1, 1, 1},
                    new double[]{1, 1, 1},
                    new double[]{1, 1, 1}
                }
            )
        ));

        // Bester Fall
        Assert.assertFalse(this.matrix.equals(
            new Matrix(
                new double[][]{
                    new double[]{1, 2, 3},
                    new double[]{4, 5, 6}
                }
            )
        ));

        // Bester Fall
        Assert.assertFalse(this.matrix.equals(
            new Matrix(
                new double[][]{
                    new double[]{1, 2},
                    new double[]{4, 5},
                    new double[]{7, 8}
                }
            )
        ));
    }

    /**
     * Testet ob das Skalare Multiplizieren zweier Matrizen korrekt funktioniert
     */
    @Test
    public void multipleScalar() {
        // Normaler Fall
        Assert.assertTrue(
            this.matrix.multiplyScalar(1).equals(
                new Matrix(
                    new double[][]{
                        new double[]{1, 2, 3},
                        new double[]{4, 5, 6},
                        new double[]{7, 8, 9}
                    }
                )
            )
        );

        // Normaler Fall
        Assert.assertTrue(
            this.matrix.multiplyScalar(-1).equals(
                new Matrix(
                    new double[][]{
                        new double[]{-1, -2, -3},
                        new double[]{-4, -5, -6},
                        new double[]{-7, -8, -9}
                    }
                )
            )
        );

        // Normaler Fall
        Assert.assertTrue(
            this.matrix.multiplyScalar(2).equals(
                new Matrix(
                    new double[][]{
                        new double[]{2, 4, 6},
                        new double[]{8, 10, 12},
                        new double[]{14, 16, 18}
                    }
                )
            )
        );

        // Bester Fall
        Assert.assertFalse(
            this.matrix.multiplyScalar(2).equals(
                new Matrix(
                    new double[][]{
                        new double[]{3, 4, 6},
                        new double[]{8, 10, 12},
                        new double[]{14, 16, 18}
                    }
                )
            )
        );
    }

    /**
     * Testet ob die Zeilenanzahl stimmt
     * Normaler Fall
     */
    @Test
    public void getRows() {
        Assert.assertEquals(3, this.matrix.getRows());
    }

    /**
     * Testet ob die Spaltenanzahl stimmt
     * Normaler Fall
     */
    @Test
    public void getCols() {
        Assert.assertEquals(3, this.matrix.getCols());
    }

    /**
     * Testet ob die Tabelle der Matrix korrekt gesetzt wurde
     * Normaler Fall
     */
    @Test
    public void getTable() {
        Assert.assertArrayEquals(
            new double[][]{
                new double[]{1, 2, 3},
                new double[]{4, 5, 6},
                new double[]{7, 8, 9}
            },
            this.matrix.getTable()
        );
    }

    /**
     * Testet ob eine Matrix korrekt angezeigt wird
     */
    @Test
    public void testToString() {
        String matrix = "[1.0, 2.0, 3.0]\n" +
            "[4.0, 5.0, 6.0]\n" +
            "[7.0, 8.0, 9.0]\n";

        Assert.assertEquals(this.matrix.toString(), matrix);
    }
}
