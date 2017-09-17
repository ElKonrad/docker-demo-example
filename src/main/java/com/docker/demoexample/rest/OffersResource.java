package com.docker.demoexample.rest;

import com.docker.demoexample.domain.OffersResponse;
import com.docker.demoexample.service.OffersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by konrad on 17.09.17.
 */
@RestController
@RequestMapping
public class OffersResource {

    private static final String LUBLIN_CITY = "Lublin";
    private static final String DOCKERCLOUD_CONTAINER_HOSTNAME = "DOCKERCLOUD_CONTAINER_HOSTNAME";
    private static final String PLATFORM_ENV = "platform";
    private final OffersService offersService;

    public OffersResource(OffersService offersService) {
        this.offersService = offersService;
    }

    @GetMapping
    public ResponseEntity<OffersResponse> offers() {
        return new ResponseEntity<>(
                OffersResponse.builder()
                        .platform(System.getenv(PLATFORM_ENV))
                        .container(getContainerNameEnv())
                        .city(LUBLIN_CITY)
                        .jobOffers(offersService.openOffers())
                        .build(),
                HttpStatus.OK
        );
    }

    private String getContainerNameEnv() {
        return Optional.ofNullable(System.getenv(DOCKERCLOUD_CONTAINER_HOSTNAME))
                .orElse("Container hostname not defined");
    }


}
