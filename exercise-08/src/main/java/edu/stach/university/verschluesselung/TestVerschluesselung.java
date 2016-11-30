/*
 * Copyright (c) 2016 Christoph Stach <christoph.stach@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package edu.stach.university.verschluesselung;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/29/16
 */
public class TestVerschluesselung {
    /**
     * Entry point for the application
     *
     * @param args Console arguments
     */
    public static void main(String[] args) {
        Chiffrierung verschluesselung1 = new Caesar();
        String klarText1 = "hallo ich muss verschluesselt werden";
        String geheimText1 = Verschluesselung.verschluesseln(klarText1, verschluesselung1);
        System.out.println("Ceasar");
        System.out.println("Klar-Text:" + klarText1);
        System.out.println("Geheim-Text:" + geheimText1);
        System.out.println("Klar-Text:" + Verschluesselung.entschluesseln(geheimText1, verschluesselung1));

        System.out.println("\n------------------------------------------------\n");

        Chiffrierung verschluesselung2 = new Benutzerdefiniert(
                new char[]{
                        '#', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
                        'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
                        'y', 'z', 'a'
                }
        );
        String klarText2 = "hallo ich muss auch verschluesselt werden";
        String geheimText2 = Verschluesselung.verschluesseln(klarText2, verschluesselung2);
        System.out.println("Benutzer");
        System.out.println("Klar-Text:" + klarText2);
        System.out.println("Geheim-Text:" + geheimText2);
        System.out.println("Klar-Text:" + Verschluesselung.entschluesseln(geheimText2, verschluesselung2));

    }
}
