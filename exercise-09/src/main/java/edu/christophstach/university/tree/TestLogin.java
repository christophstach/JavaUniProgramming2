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

import java.util.Scanner;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 12/11/16
 */
public class TestLogin {
    public static void main(String[] args) {
        Login login = new Login();
        Scanner input = new Scanner(System.in);
        String benutzer = "";
        String passwort = "";
        System.out.print("Bitte geben Sie den Benutzernamen ein:");
        benutzer = input.next();
        System.out.println("Bitte geben Sie das Passwort ein:");
        passwort = input.next();
        try {
            System.out.println("Sie werden angemeldet ...");
            login.anmelden(benutzer, passwort);
            System.out.println("Anmeldung erfolgreich!");
        } catch (ZugriffUngueltigException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            System.out.println("Methode bearbeiten() wird aufgerufen ...");
            login.bearbeiten();
        } catch (KeineBerechtigungException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Sie werden abgemeldet ...");
        login.abmelden();
        try {
            System.out.println("Methode bearbeiten() wird aufgerufen ...");
            login.bearbeiten();
        } catch (KeineBerechtigungException ex) {
            System.out.println(ex.getMessage());
        }
    }
}