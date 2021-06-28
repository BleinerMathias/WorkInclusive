package br.edu.ifsp.domain.entities.candidacy;

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
}
