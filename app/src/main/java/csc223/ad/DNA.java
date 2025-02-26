package csc223.ad;

public class DNA {

    // Returns the count of each nucleotide in a given string of DNA
    public static String countNucleotides(String dna) {

        int[] letters = {0, 0, 0, 0};

        for (int i = 0; i <= dna.length(); i++) {
            char letter = dna.charAt(i);
            
            if (letter == 'A') {
                letters[0] += 1;
            }
            else if (letter == 'C') {
                letters[1] += 1;
            }
            else if (letter == 'G') {
                letters[2] += 1;
            }
            else {
                letters[3] += 1;
            }
        }
        return letters[0] + " " + letters[1] + " " + letters[2] + " " + letters[3];
    }

    // Converts the DNA string into RNA
    public static String transcribe(String dna) {

        String rna = "";

        for (int i = 0; i <= dna.length(); i++) {
            char letter = dna.charAt(i);
            
            if (letter == 'T') {
                rna = rna + 'U';
            }
            else {
                rna = rna + letter;
            }
            
        }
        return rna;
    }

    // Returns the complement of a given DNA string
    public static String reverseComplement(String dna) {

        String complement = "";

        for (int i = dna.length(); i >= 0; i--) {
            char letter = dna.charAt(i);
            
            if (letter == 'A') {
                complement = complement + "T";
            }
            else if (letter == 'T') {
                complement = complement + "A";
            }
            else if (letter == 'C') {
                complement = complement + "G";
            }
            else {
                complement = complement + "C";
            }
        }

        return complement;
    }
}