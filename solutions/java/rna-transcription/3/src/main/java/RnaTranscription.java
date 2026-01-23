class RnaTranscription {

    String transcribe(String dnaStrand) {
        if (dnaStrand.isEmpty()) return "";
        StringBuilder rnaStrand = new StringBuilder();
        dnaStrand.chars().mapToObj(c -> transcribeChar((char) c)).forEach(rnaStrand::append);
        return rnaStrand.toString();
    }

    char transcribeChar(char c) {
        if (c == 'G') return 'C';
        else if (c == 'C') return 'G';
        else if (c == 'T') return 'A';
        else if (c == 'A') return 'U';
        else throw new IllegalArgumentException();
    }
}
