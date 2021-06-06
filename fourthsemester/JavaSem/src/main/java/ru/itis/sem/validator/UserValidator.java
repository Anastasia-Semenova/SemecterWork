//package ru.itis.sem.validator;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.Validator;
//import ru.itis.sem.model.User;
//import ru.itis.sem.services.UserService;
//
//@Component
//public class UserValidator implements Validator {
//
//    @Autowired
//    private UserService userService;
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return User.class.equals(clazz);
//    }
//
//    @Override
//    public void validate(Object o, Errors errors) {
//        User user = (User)o;
//
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Required");
//        if(user.getLogin().length() < 1 || user.getLogin().length() > 32){
//            errors.rejectValue("username", "Size.userForm.username");
//        }
//
//        if(userService.findByLogin(user.getLogin()).isPresent()){
//            errors.rejectValue("username", "Duplicate.userForm.username");
//        }
//
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
//        if(user.getHashPassword().length()<8 || user.getHashPassword().length()>32){
//            errors.rejectValue("password", "Size.userForm.password");
//        }
//        if(!user.getConfirmPassword().equals(user.getHashPassword())){
//            errors.rejectValue("confirmPassword", "Different.userForm.password");
//        }
//    }
//}
