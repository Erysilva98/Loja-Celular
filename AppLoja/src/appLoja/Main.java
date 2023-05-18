package appLoja;

import dao.FileUserDao;
import view.UserForm;

public class Main {
    public static void main(String[] args) {
        FileUserDao userDao = new FileUserDao();
        UserForm userForm = new UserForm(userDao);
    }
}

