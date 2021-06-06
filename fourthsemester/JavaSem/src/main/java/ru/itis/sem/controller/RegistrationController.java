package ru.itis.sem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.sem.dto.RegistrationFormDto;
import ru.itis.sem.model.User;
import ru.itis.sem.services.SignUpService;
import ru.itis.sem.utils.FileUploadUtil;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Objects;
import java.util.UUID;

@Controller
public class RegistrationController {
    @Autowired
    private SignUpService signUpService;


    @Autowired
    private FileUploadUtil fileUploadUtil;

    @Value("${path.user-photo}")
    private String userPhotoPath;


    @Value("${path.user-photo-for-html}")
    private String userPhotoPathForHtml;


    public RegistrationController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @PermitAll
    @GetMapping("/registration")
    public String getSignUpPage(Model model, HttpSession session) {
        model.addAttribute("registrationFormDto", new RegistrationFormDto());
        session.setAttribute("Authenticated", "false");
        return "registration";
    }

    @PermitAll
    @PostMapping("/registration")
    public String signUp(@Valid RegistrationFormDto form, BindingResult bindingResult, Model model, @RequestParam("image") MultipartFile multipartFile) {
        /*if (bindingResult.hasErrors()) {

            bindingResult.getAllErrors().stream().anyMatch(error -> {
                if (Objects.requireNonNull(error.getCodes())[0].equals("registrationFormDto.ValidNames")) {
                    model.addAttribute("namesErrorMessage", error.getDefaultMessage());
                }
                if (Objects.requireNonNull(error.getCodes())[0].equals("registrationFormDto.FieldMatch")) {
                    model.addAttribute("passwordMismatchErrorMessage", error.getDefaultMessage());
                }
                return true;
            });
            model.addAttribute("registrationFormDto", form);
            return "registration";
        }*/


        if (!multipartFile.isEmpty()) {
            String fileName = UUID.randomUUID().toString() + "."
                    + StringUtils.cleanPath((Objects.requireNonNull(multipartFile.getOriginalFilename())).split("\\.")[1]);
            form.setImage(userPhotoPathForHtml + fileName);
            User newUser = signUpService.signUpWithPhoto(form);

            String uploadDir = userPhotoPath + newUser.getId();
            fileUploadUtil.saveFile(uploadDir, userPhotoPath + fileName, multipartFile);

        } else {
            signUpService.signUp(form);
        }
        return "redirect:/login";
    }
}
