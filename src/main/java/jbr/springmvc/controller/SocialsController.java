package jbr.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.CursoredList;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

@Controller
public class SocialsController {

    @Autowired
    private Twitter twitter;

    @RequestMapping(value = "/fetchTweets", method= RequestMethod.GET)
    public ModelAndView fetchTweets(Model model) {
        List<Tweet> tweets = twitter.timelineOperations().getUserTimeline();
        ModelAndView mav = new ModelAndView("tweets");
        mav.addObject("tweets", tweets);
        return mav;
    }

}
