package com.demo.gatling.unicorns.web;

import com.demo.gatling.unicorns.mappers.Gender;
import com.demo.gatling.unicorns.mappers.Unicorn;
import com.demo.gatling.unicorns.mappers.UnicornMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class FrontendController {

    private final UnicornMapper unicornMapper;

    @Autowired
    public FrontendController(UnicornMapper unicornMapper) {
        this.unicornMapper = unicornMapper;
    }

    @GetMapping
    public ModelAndView list(@RequestParam(required = false) Integer maxAge, @RequestParam(required = false) Gender gender,
                             @RequestParam(required = false, defaultValue = "500") int maxResults) {
        Iterable<Unicorn> unicorns = this.unicornMapper.filter(maxAge, gender, maxResults);
        return new ModelAndView("list", "unicorns", unicorns);
    }

    @GetMapping("/details/{id}")
    public ModelAndView details(@PathVariable("id") Unicorn unicorn) {
        return new ModelAndView("details", "unicorn", unicorn);
    }

    @GetMapping("/registration")
    public String registrationForm(@ModelAttribute Unicorn unicorn) {
        return "registration";
    }

    @PostMapping
    public ModelAndView create(Unicorn unicorn, BindingResult result,
                               RedirectAttributes redirect) {
        this.unicornMapper.create(unicorn);
        redirect.addFlashAttribute("globalMessage", "Successfully registered.");
        return new ModelAndView("redirect:/details/{unicorn.id}", "unicorn.id", unicorn.getId());
    }
}
