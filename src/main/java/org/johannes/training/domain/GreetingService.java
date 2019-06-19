package org.johannes.training.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    @Autowired
    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Transactional
    public void createGreetingAndSaveIt(String text){
        greetingRepository.save(new Greeting(text));
    }

    @Transactional
    public List<Greeting> getGreetings(){
        Iterable<Greeting> all = greetingRepository.findAll();
        return Lists.newArrayList(all.iterator());


    }

    @Transactional
    public Greeting getGreeting(Long id){
        Optional<Greeting> greeting = greetingRepository.findById(id);
        return greeting.get();


    }
}
