package pl.finalproject.accessingdatamysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.finalproject.accessingdatamysql.model.User;
import pl.finalproject.accessingdatamysql.model.Vat;
import pl.finalproject.accessingdatamysql.repository.UserRepository;
import pl.finalproject.accessingdatamysql.repository.VatRepository;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/user")
public class VatController {

    @Autowired
    private VatRepository vatRepository;
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/vat")
    public String addNewVat(@RequestParam Double grocery,
                            @RequestParam Double bills,
                            @RequestParam Double entertainment,
                            @RequestParam Double services,
                            @RequestParam Double alcohol,
                            @RequestParam Double cigarettes,
                            HttpSession session) {

        String login = String.valueOf(session.getAttribute("login"));
        User user = userRepository.findByLogin(login);

        Vat vat = user.getVat();
        vat.setGrocery(grocery);
        vat.setBills(bills);
        vat.setEntertainment(entertainment);
        vat.setServices(services);
        vat.setAlcohol(alcohol);
        vat.setCigarettes(cigarettes);
        vatRepository.save(vat);

        user.setVat(vat);
        userRepository.save(user);

        return "savedVatSuccess";
    }

}
