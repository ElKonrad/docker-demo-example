package com.docker.demoexample.domain;

import lombok.Builder;
import lombok.Value;

import java.util.List;

/**
 * Created by konrad on 17.09.17.
 */
@Value
@Builder
public class OffersResponse {

    String platform;
    String container;
    String city;
    List<JobOffer> jobOffers;
}
