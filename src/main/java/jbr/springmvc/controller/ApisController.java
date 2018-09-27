package jbr.springmvc.controller;

import jbr.springmvc.jsonMapper.Quote;
import jbr.springmvc.jsonMapper.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@PropertySource("classpath:application.properties")
public class ApisController {

    @Value("${quote.url}")
    private String quoteUrl;
    @Autowired
    public RestTemplate restTemplate;
    @RequestMapping(value = "/getQuotes", method= RequestMethod.GET)
    public ModelAndView getQuotes(Model model) {
        ModelAndView mav = new ModelAndView("apis");
       // Quote quote = restTemplate.getForObject(quoteUrl, Quote.class);


        ResponseEntity<List<Rate>> rateResponse =
                restTemplate.exchange("https://bitpay.com/api/rates",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Rate>>() {
                        });
        List<Rate> rates = rateResponse.getBody();
        System.out.println(rates);
        mav.addObject("Rates", rates);
        return mav;
    }

}
