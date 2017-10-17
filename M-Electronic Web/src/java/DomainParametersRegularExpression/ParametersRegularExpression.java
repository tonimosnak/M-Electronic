package DomainParametersRegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParametersRegularExpression {
    Pattern inCase;
    Matcher control;
    
    public boolean name (String username){
        inCase = Pattern.compile("^[A-ZŠČĆĐŽ][a-zščžćđ]*$");
        control = inCase.matcher(username);
        return control.matches();
    }
    
    public boolean surname (String username){
        inCase = Pattern.compile("^[A-ZŠČĆĐŽ][a-zščžćđ]*$");
        control = inCase.matcher(username);
        return control.matches();
    }
    
    public boolean username(String username){
        inCase = Pattern.compile("^(?=.*[A-ZŠČĆĐŽa-zščžćđ])[A-ZŠČĆĐŽa-zščžćđ\\d$-_*?.,!@#$&^+|;°~:%=]{6,18}$");
        control = inCase.matcher(username);
        return control.matches();
    }
    
    public boolean password (String username){
        inCase = Pattern.compile("^(?=.*[A-ZŠČĆĐŽa-zščžćđ])[A-ZŠČĆĐŽa-zščžćđ\\d$-_*?.,!@#$&^+|;°~:%=]{8,20}$");
        control = inCase.matcher(username);
        return control.matches();
    }
    
    public boolean confirmPassword (String username){
        inCase = Pattern.compile("^(?=.*[A-ZŠČĆĐŽa-zščžćđ])[A-ZŠČĆĐŽa-zščžćđ\\d$-_*?.,!@#$&^+|;°~:%=]{8,20}$");
        control = inCase.matcher(username);
        return control.matches();
    }
    
    public boolean city(String city){
        inCase = Pattern.compile("^[A-ZŠČĆĐŽ][A-ZŠČĆĐŽa-zščžćđ ]*[ ][0-9]{5}$");
        control = inCase.matcher(city);
        return control.matches();
    }
    
    public boolean street(String street){
        inCase = Pattern.compile("^[A-ZŠČĆĐŽ][A-ZŠČĆĐŽa-zščžćđ ]*[ .][0-9a-zščžćđ]*$");
        control = inCase.matcher(street);
        return control.matches();
    }
    
    public boolean email (String username){
        inCase = Pattern.compile("^(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])$");
        control = inCase.matcher(username);
        return control.matches();
    }
    
    public boolean phoneNumber (String username){
        inCase = Pattern.compile("^[0-9]{9,}$");
        control = inCase.matcher(username);
        return control.matches();
    }
}
