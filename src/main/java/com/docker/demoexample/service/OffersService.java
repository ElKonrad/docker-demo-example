package com.docker.demoexample.service;

import com.docker.demoexample.domain.JobOffer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static com.docker.demoexample.domain.Technology.*;

/**
 * Created by konrad on 17.09.17.
 */
@Service
public class OffersService {

    public List<JobOffer> openOffers() {
        JobOffer javaDev = JobOffer.builder()
                .title("Java Developer")
                .technologies(new HashSet<>(Arrays.asList(JAVA, SPRING)))
                .build();
        JobOffer rubyDev = JobOffer.builder()
                .title("Ruby Developer")
                .technologies(new HashSet<>(Arrays.asList(RUBY, JAVASCRIPT)))
                .build();
        
        return new ArrayList<>(Arrays.asList(javaDev, rubyDev));
    }
}
