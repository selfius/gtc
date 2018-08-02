package local.self.gtc.controller;

import local.self.gtc.model.PullRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/pr/")
public class PullRequestController {

    public static final Logger LOGGER = LoggerFactory.getLogger(PullRequestController.class);

    @RequestMapping(value = "submit", method = RequestMethod.POST)
    public void submit(@RequestBody PullRequest pullRequest, HttpServletResponse response) {
        LOGGER.info("Received a PR submission for {}", pullRequest);
        response.setStatus(HttpServletResponse.SC_OK);

    }

}
