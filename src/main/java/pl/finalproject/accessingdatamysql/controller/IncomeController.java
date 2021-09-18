package pl.finalproject.accessingdatamysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.finalproject.accessingdatamysql.model.Income;
import pl.finalproject.accessingdatamysql.model.User;
import pl.finalproject.accessingdatamysql.repository.IncomeRepository;
import pl.finalproject.accessingdatamysql.repository.UserRepository;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/user")
public class IncomeController {

    @Autowired
    private IncomeRepository incomeRepository;
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/income")
    public String addNewIncome(@RequestParam Double salary,
                               @RequestParam String type,
                               HttpSession session) {

        String login = String.valueOf(session.getAttribute("login"));
        User user = userRepository.findByLogin(login);

        Income income = user.getIncome();
        income.setSalary(salary);
        income.setType(type);
        incomeRepository.save(income);

        user.setIncome(income);
        userRepository.save(user);

        return "savedIncomeSuccess";
    }
}
