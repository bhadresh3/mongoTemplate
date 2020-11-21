package com.system27.mongo.Service;

import com.system27.mongo.Model.Person;
import com.system27.mongo.Repo.PersonRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepo personRepo;

    public Person add(Person person) {
        return personRepo.add(person);
    }

    public List<Person> findAll() {
        return personRepo.findAll();
    }

    public Person update(Person person) {
         return personRepo.update(person);
    }

    public void delete(String id) {
        personRepo.delete(id);
    }

    public List<Person> getBySalary(int salary) {
        return personRepo.getBySalary(salary);
    }
}
