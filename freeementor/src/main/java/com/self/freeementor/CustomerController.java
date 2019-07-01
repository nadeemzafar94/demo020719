package com.self.freeementor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.self.hibernate.model.Customer;
import com.self.hibernate.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
    private CustomerService customerService;
	
    @GetMapping("/list")
    public String listCustomers(Model theModel) {
        List < Customer > theCustomers = customerService.getCustomers();
        theModel.addAttribute("customers", theCustomers);
        return "user.home";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(/*@ModelAttribute("customer") Customer theCustomer*/) {
    	Customer c = new Customer();
    	c.setFirstName("Nadeem");
    	c.setLastName("Zafar");
    	c.setEmail("iamnadeemzafar@gmail.com");
        customerService.saveCustomer(c);
        return "redirect:/customer/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("customerId") int theId,
        Model theModel) {
        Customer theCustomer = customerService.getCustomer(theId);
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId) {
        customerService.deleteCustomer(theId);
        return "redirect:/customer/list";
    }
   
}
