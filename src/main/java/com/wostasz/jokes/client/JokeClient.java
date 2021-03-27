package com.wostasz.jokes.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JokeClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(JokeClient.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JokeTellerConfiguration jokeTellerConfiguration;

    @Autowired
    private JokeTellerService jokeTellerService;

    @Autowired
    private JokeTellerMapper jokeTellermapper;


//    public JokeTellerDTO getJoke(String name, int age) {
//        try {
//            LOGGER.info("Starting method getJoke in JokeTellerClient");
//            LOGGER.info("Getting joke for " + name + " " + age);
//
//            if (name == null || age == null) {
//                if (name == null) {
//                    LOGGER.error("name is null! " + fname);
//                }
//                if (age == null) {
//                    LOGGER.error("age is null!" + sname);
//                }
//                return errorMessageGetPercentageClient2;
//            }
//
//            URI url = UriComponentsBuilder.fromHttpUrl("https://love-calculator.p.rapidapi.com/getPercentage")
//                    .queryParam("fname", fname)
//                    .queryParam("sname", sname)
//                    .build().encode().toUri();
//            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
//            headers.add("X-RapidAPI-Host", loveCalculatorConfiguration.getLoveCalculatorEndpoint());
//            headers.add("X-RapidAPI-Key", loveCalculatorConfiguration.getLoveCalculatorKey());
//
//            HttpEntity<?> entity = new HttpEntity<>(headers);
//
//            HttpEntity<LoveCalculatorDto> response = restTemplate.exchange(url, HttpMethod.GET, entity, LoveCalculatorDto.class);
//
//            LOGGER.info("Ended getPercentage in LoveCalculatorClient.");
//
//            loveCalculatorService.createLoveCalculator(loveCalculatorMapper.mapToLoveCalculator(response.getBody()));
//
//            return response.getBody();
//
//        } catch (HttpServerErrorException e) {
//            LOGGER.error("HttpServerErrorException " + e);
//        }
//
//        LOGGER.warn("Ended method getRandomQuoteClient in QuotesClient = failure.");
//
//        return errorMessageGetPercentageClient;
//    }

}
