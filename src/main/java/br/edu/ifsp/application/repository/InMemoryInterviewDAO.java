package br.edu.ifsp.application.repository;

import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.entities.interview.Interview;
import br.edu.ifsp.domain.usecases.interview.InterviewDAO;

import java.util.*;
import java.util.stream.Collectors;

public class InMemoryInterviewDAO implements InterviewDAO {

    private static Map<Integer, Interview> db = new LinkedHashMap<>();
    private static int id;


    @Override
    public Integer create(Interview interview) {
        id++;
        interview.setId(id);
        db.put(id, interview);
        return null;
    }

    @Override
    public Optional<Interview> findOne(Integer key) {
        return Optional.empty();
    }

    @Override
    public List<Interview> findAll() {
        return null;
    }

    @Override
    public boolean update(Interview type) {
        return false;
    }

    @Override
    public boolean deleteByKey(Integer key) {
        return false;
    }

    @Override
    public boolean delete(Interview type) {
        return false;
    }

    @Override
    public List<Interview> findAllInterviewByCandidate(Candidate candidate) {

        List<Interview> interviews = new ArrayList<>(db.values().stream().
                filter(interview -> interview.getCandidacy().getCandidate().equals(candidate))
                .collect(Collectors.toList()));
        if(!interviews.isEmpty()){
            return interviews;
        }
        return null;
    }
}
