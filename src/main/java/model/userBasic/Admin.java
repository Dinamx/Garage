package model.userBasic;

import exeptions.EmptyFieldException;
import manipDb.ObjetBDD;

public class Admin extends ObjetBDD {
    String email;
    String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws EmptyFieldException {
        if(email.trim().equals(""))
        {
            throw new EmptyFieldException("email");
        }
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws EmptyFieldException {
        if(password.trim().equals("")) throw new EmptyFieldException("mot de passe");
        this.password = password;
    }

    public Admin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Admin() {
    }
}
