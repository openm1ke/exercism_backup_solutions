class RnaTranscription {

    String transcribe(String dnaStrand) {
        if (dnaStrand.isEmpty()) return "";
        StringBuilder rnaStrand = new StringBuilder();
        dnaStrand.chars().forEach(c -> {
            if (c == 'G') rnaStrand.append('C');
            else if (c == 'C') rnaStrand.append('G');
            else if (c == 'T') rnaStrand.append('A');
            else if (c == 'A') rnaStrand.append('U');
        });
        return rnaStrand.toString();
    }
}
