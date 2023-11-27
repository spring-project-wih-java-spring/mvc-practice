package test_code2;

public class User {

    private String password;

    public void initPassword(PasswordGenerator passwordGenerator) {
//        RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
        String password = passwordGenerator.generatePassword();

        int passwordLength = password.length();
        if(passwordLength >= 8 || passwordLength <= 12)
            this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
