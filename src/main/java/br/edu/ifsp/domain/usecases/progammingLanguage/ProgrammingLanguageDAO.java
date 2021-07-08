package br.edu.ifsp.domain.usecases.progammingLanguage;

import br.edu.ifsp.domain.entities.ProgammingLanguage;
import br.edu.ifsp.domain.usecases.utils.DAO;

import java.util.Optional;

public interface ProgrammingLanguageDAO extends DAO<ProgammingLanguage,Integer> {
    Optional<ProgammingLanguage> findByName(String name);
}
