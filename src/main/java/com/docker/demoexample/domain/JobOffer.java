package com.docker.demoexample.domain;

import lombok.Builder;
import lombok.Value;

import java.util.Set;

/**
 * Created by konrad on 17.09.17.
 */
@Value
@Builder
public class JobOffer {

    String title;
    Set<Technology> technologies;
}
