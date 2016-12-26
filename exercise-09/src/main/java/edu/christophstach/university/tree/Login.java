/*
 * Copyright (c) 2016 Christoph Stach <christoph.stach@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package edu.christophstach.university.tree;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 12/11/16
 */
public class Login {
    private boolean angemeldet;

    /**
     * Meldete einen Benutzer an
     *
     * @param benutzer Der Benutzer
     * @param passwort Das Passwort
     * @throws ZugriffUngueltigException Wird geworfen wenn die Anmeldung fehlschlägt
     */
    public void anmelden(String benutzer, String passwort) throws ZugriffUngueltigException {
        if (benutzer.equals("christophstach") && passwort.equals("123456")) {
            angemeldet = true;
        } else {
            throw new ZugriffUngueltigException();
        }
    }

    /**
     * Meldet den Benutzer ab
     */
    public void abmelden() {
        angemeldet = false;
    }

    /**
     * Simuliert eine das Bearbeiten eines Benutzers
     *
     * @throws KeineBerechtigungException Wird geworfen wenn Benutzer nicht angemeldet ist
     */
    public void bearbeiten() throws KeineBerechtigungException {
        if (angemeldet) {
            System.out.println("Es wird bearbeitet...");
        } else {
            throw new KeineBerechtigungException();
        }
    }
}
