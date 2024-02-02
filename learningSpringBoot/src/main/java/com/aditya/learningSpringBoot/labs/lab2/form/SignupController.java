// package com.example.demo;


// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// @Controller
// @RequestMapping("/signup")
// public class SignupController {

//     @GetMapping
//     public String showSignupForm() {
//         return "signup";
//     }

//     @PostMapping
//     public String processSignup(@RequestParam String firstName, @RequestParam String lastName) {
//         // Handle signup logic (e.g., save user to the database)
//         // For simplicity, we're not doing anything here.
//         return "redirect:/signup/success";
//     }

//     @GetMapping("/success")
//     public String signupSuccess() {
//         return "signup_success";
//     }
// }

// src/main/java/com/example/demo/lab2/SignupController.java

package com.aditya.learningSpringBoot.labs.lab2.form;

// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// @Controller
// @RequestMapping("/signup")
// public class SignupController {

//     @GetMapping
//     public String showSignupForm(Model model) {
//         return "signup";
//     }

//     @PostMapping
//     public String processSignup(@RequestParam String firstName, @RequestParam String lastName) {
//         // Handle signup logic (e.g., save user to the database)
//         // For simplicity, we're not doing anything here.
//         return "redirect:/signup/success";
//     }

//     @GetMapping("/success")
//     public String signupSuccess() {
//         return "signup_success";
//     }
// }

// src/main/java/com/example/demo/lab2/SignupController.java


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/signup")
public class SignupController {


    @GetMapping
    public String showSignupForm(Model model) {
        return "signup.html";
    }

    @PostMapping
    public String processSignup(@RequestParam String firstName, @RequestParam String lastName) {    
        return "redirect:/signup/success";    
    }

    @GetMapping("/success")
    public String signupSuccess() {
        return "signup_success.html";
    }
}
