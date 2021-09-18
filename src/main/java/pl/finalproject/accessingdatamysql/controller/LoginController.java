package pl.finalproject.accessingdatamysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.finalproject.accessingdatamysql.model.User;
import pl.finalproject.accessingdatamysql.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final double B2B_TAX = 0.22;
    private final double CONTRACT_TAX = 0.25;
    private final double PRODUCT_TAX = 0.19;
    private final double ALCOHOL_TAX = 0.37;
    private final double BILLS_TAX = 0.11;
    private final double CIGARETTES_TAX = 0.8496;
    private final double ENTERTAINMENT_TAX = 0.8;
    private final double GROCERY_TAX = 0.23;
    private final double SERVICES_TAX = 0.8;
    private String message = "Niepoprawny login lub hasło";
    @Autowired
    UserRepository userRepository;

    @PostMapping("/loginSuccess")
    public String aboutProject(HttpServletRequest request,
                               @RequestParam String login,
                               @RequestParam String password,
                               Model model) {
        if (userRepository.findByLogin(login) == null) {
            model.addAttribute("message", message);
            return "login";
        }
        if (login.equals(userRepository.findByLogin(login).getLogin())
                && password.equals(userRepository.findByLogin(login).getPassword())) {

            HttpSession session = request.getSession();
            session.setAttribute("login", login);

            User user = userRepository.findByLogin(login);

            Double salary = user.getIncome().getSalary();
            String type = user.getIncome().getType();
            double salaryTax;

            if (type != null && salary != null && salary >= 0) {
                if (type.equals("contract")) {
                    salaryTax = salary * CONTRACT_TAX;
                } else if (type.equals("product")) {
                    salaryTax = salary * PRODUCT_TAX;
                } else {
                    salaryTax = salary * B2B_TAX;
                }
            } else {
                salaryTax = 0.0;
            }

            //model.addAttribute("salaryTax", salaryTax);
            session.setAttribute("salaryTax", salaryTax);

            Double alcohol = user.getVat().getAlcohol();
            double vatAlcohol;
            if (alcohol != null && alcohol >= 0) {
                vatAlcohol = alcohol * ALCOHOL_TAX;
            } else {
                vatAlcohol = 0.0;
            }
            //model.addAttribute("vatAlcohol", vatAlcohol);
            session.setAttribute("vatAlcohol", vatAlcohol);

            Double bills = user.getVat().getBills();
            double vatBills;
            if (bills != null && bills >= 0) {
                vatBills = bills * BILLS_TAX;
            } else {
                vatBills = 0.0;
            }
            //model.addAttribute("vatBills", vatBills);
            session.setAttribute("vatBills", vatBills);

            Double cigarettes = user.getVat().getCigarettes();
            double vatCigarettes;
            if (cigarettes != null && cigarettes >= 0) {
                vatCigarettes = cigarettes * CIGARETTES_TAX;
            } else {
                vatCigarettes = 0.0;
            }
            //model.addAttribute("vatCigarettes", vatCigarettes);
            session.setAttribute("vatCigarettes", vatCigarettes);

            Double entertainment = user.getVat().getEntertainment();
            double vatEntertainment;
            if (entertainment != null && entertainment >= 0) {
                vatEntertainment = entertainment * ENTERTAINMENT_TAX;
            } else {
                vatEntertainment = 0.0;
            }
            //model.addAttribute("vatEntertainment", vatEntertainment);
            session.setAttribute("vatEntertainment", vatEntertainment);

            Double grocery = user.getVat().getGrocery();
            double vatGrocery;
            if (grocery != null && grocery >= 0) {
                vatGrocery = grocery * GROCERY_TAX;
            } else {
                vatGrocery = 0.0;
            }
            //model.addAttribute("vatGrocery", vatGrocery);
            session.setAttribute("vatGrocery", vatGrocery);

            Double services = user.getVat().getServices();
            double vatServices;
            if (services != null && services >= 0) {
                vatServices = services * SERVICES_TAX;
            } else {
                vatServices = 0.0;
            }
            //model.addAttribute("vatServices", vatServices);
            session.setAttribute("vatServices", vatServices);

            double sumVat = vatAlcohol + vatBills + vatCigarettes + vatEntertainment + vatGrocery + vatServices;
            //model.addAttribute("sumVat", sumVat);
            session.setAttribute("sumVat", sumVat);

            double sum = sumVat + salaryTax;
            //model.addAttribute("sum", sum);
            session.setAttribute("sum", sum);

            double sumAnnual = 12 * sum;
            //model.addAttribute("sumAnnual", sumAnnual);
            session.setAttribute("sumAnnual", sumAnnual);

            double percentAnnual;
            if (salary != null && salary >= 0) {
                percentAnnual = (sumAnnual / (salary * 12)) * 100;
            } else {
                percentAnnual = 0;
            }
            //model.addAttribute("percentAnnual", percentAnnual);
            session.setAttribute("percentAnnual", percentAnnual);

            return "userView";

        } else {
            model.addAttribute("message", message);
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
                         Model model) {
        HttpSession session = request.getSession();
        if (!session.isNew()) {
            session.invalidate();
//            session = request.getSession();
//            model.addAttribute("login", session.getAttribute("login"));
        }
        return "logout";
    }

    @GetMapping("/formIncome")
    public String formIncome() {
        return "createIncome";
    }

    @GetMapping("/formVat")
    public String formVat() {
        return "createVat";
    }

    @GetMapping("/userDetails")
    public String userDetails(HttpServletRequest request) {

        HttpSession session = request.getSession();
        String login = String.valueOf(session.getAttribute("login"));

        User user = userRepository.findByLogin(login);

        Double salary = user.getIncome().getSalary();
        String type = user.getIncome().getType();
        double salaryTax;

        if (type != null && salary != null && salary >= 0) {
            if (type.equals("contract")) {
                salaryTax = salary * CONTRACT_TAX;
            } else if (type.equals("product")) {
                salaryTax = salary * PRODUCT_TAX;
            } else {
                salaryTax = salary * B2B_TAX;
            }
        } else {
            salaryTax = 0.0;
        }

        //model.addAttribute("salaryTax", salaryTax);
        session.setAttribute("salaryTax", salaryTax);

        Double alcohol = user.getVat().getAlcohol();
        double vatAlcohol;
        if (alcohol != null && alcohol >= 0) {
            vatAlcohol = alcohol * ALCOHOL_TAX;
        } else {
            vatAlcohol = 0.0;
        }
        //model.addAttribute("vatAlcohol", vatAlcohol);
        session.setAttribute("vatAlcohol",vatAlcohol);

        Double bills = user.getVat().getBills();
        double vatBills;
        if (bills != null && bills >= 0) {
            vatBills = bills * BILLS_TAX;
        } else {
            vatBills = 0.0;
        }
        //model.addAttribute("vatBills", vatBills);
        session.setAttribute("vatBills", vatBills);

        Double cigarettes = user.getVat().getCigarettes();
        double vatCigarettes;
        if (cigarettes != null && cigarettes >= 0) {
            vatCigarettes = cigarettes * CIGARETTES_TAX;
        } else {
            vatCigarettes = 0.0;
        }
        //model.addAttribute("vatCigarettes", vatCigarettes);
        session.setAttribute("vatCigarettes", vatCigarettes);

        Double entertainment = user.getVat().getEntertainment();
        double vatEntertainment;
        if (entertainment != null && entertainment >= 0) {
            vatEntertainment = entertainment * ENTERTAINMENT_TAX;
        } else {
            vatEntertainment = 0.0;
        }
        //model.addAttribute("vatEntertainment", vatEntertainment);
        session.setAttribute("vatEntertainment", vatEntertainment);

        Double grocery = user.getVat().getGrocery();
        double vatGrocery;
        if (grocery != null && grocery >= 0) {
            vatGrocery = grocery * GROCERY_TAX;
        } else {
            vatGrocery = 0.0;
        }
        //model.addAttribute("vatGrocery", vatGrocery);
        session.setAttribute("vatGrocery", vatGrocery);

        Double services = user.getVat().getServices();
        double vatServices;
        if (services != null && services >= 0) {
            vatServices = services * SERVICES_TAX;
        } else {
            vatServices = 0.0;
        }
        //model.addAttribute("vatServices", vatServices);
        session.setAttribute("vatServices", vatServices);

        double sumVat = vatAlcohol + vatBills + vatCigarettes + vatEntertainment + vatGrocery + vatServices;
        //model.addAttribute("sumVat", sumVat);
        session.setAttribute("sumVat", sumVat);

        double sum = sumVat + salaryTax;
        //model.addAttribute("sum", sum);
        session.setAttribute("sum", sum);

        double sumAnnual = 12 * sum;
        //model.addAttribute("sumAnnual", sumAnnual);
        session.setAttribute("sumAnnual", sumAnnual);

        double percentAnnual;
        if (salary!=null && salary>=0) {
            percentAnnual = (sumAnnual / (salary * 12)) * 100;
        } else {
            percentAnnual = 0;
        }
        //model.addAttribute("percentAnnual", percentAnnual);
        session.setAttribute("percentAnnual", percentAnnual);

        return "userView";
    }
}
