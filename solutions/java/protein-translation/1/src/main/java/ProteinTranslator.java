import java.util.*;

class ProteinTranslator {

    private final String INVALID_CODON = "Invalid codon";

    List<String> translate(String rnaSequence) {
        if (rnaSequence.isEmpty()) return Collections.emptyList();
        Map<String, String> rnaToAminoAcid = getStringStringMap();
        List<String> proteins = new ArrayList<>();
        for (int i = 0; i < rnaSequence.length(); i += 3) {
            if (i + 3 > rnaSequence.length()) {
                throw new IllegalArgumentException(INVALID_CODON);
            }
            String codon = rnaSequence.substring(i, i + 3);
            if (!rnaToAminoAcid.containsKey(codon)) {
                throw new IllegalArgumentException(INVALID_CODON);
            } else if (rnaToAminoAcid.get(codon).equals("STOP")) {
                break;
            }
            proteins.add(rnaToAminoAcid.get(codon));
        }

        return proteins;
    }

    private static Map<String, String> getStringStringMap() {
        Map<String, String> rnaToAminoAcid = new HashMap<>();
        rnaToAminoAcid.put("AUG", "Methionine");
        rnaToAminoAcid.put("UUU", "Phenylalanine");
        rnaToAminoAcid.put("UUC", "Phenylalanine");
        rnaToAminoAcid.put("UUA", "Leucine");
        rnaToAminoAcid.put("UUG", "Leucine");
        rnaToAminoAcid.put("UCU", "Serine");
        rnaToAminoAcid.put("UCC", "Serine");
        rnaToAminoAcid.put("UCA", "Serine");
        rnaToAminoAcid.put("UCG", "Serine");
        rnaToAminoAcid.put("UAU", "Tyrosine");
        rnaToAminoAcid.put("UAC", "Tyrosine");
        rnaToAminoAcid.put("UGU", "Cysteine");
        rnaToAminoAcid.put("UGC", "Cysteine");
        rnaToAminoAcid.put("UGG", "Tryptophan");
        rnaToAminoAcid.put("UAA", "STOP");
        rnaToAminoAcid.put("UAG", "STOP");
        rnaToAminoAcid.put("UGA", "STOP");
        return rnaToAminoAcid;
    }
}
