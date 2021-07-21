package br.edu.ifsp.domain.entities.candidacy;

import br.edu.ifsp.domain.entities.candidate.AcademicDegree;

import java.util.Arrays;

public enum StatusCandidacy {
    IN_ANALYSIS("Em análise"),
    ACCEPT("Aceito para entrevista"),
    UNACCEPT("Não aceito")
    ;

    private String label;

    StatusCandidacy(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
    public static StatusCandidacy toEnum(String value){
        return Arrays.stream(StatusCandidacy.values())
                .filter(c -> value.equals(c.toString()))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
