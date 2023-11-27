package test_code2;

public class PasswordValidator {

    private static final String WRONG_WARNING_MESSAGE = "비밀번호는 최소 8자 이상 12자 이하여야 합니다.";

    public static void validate(String password) {
        int length = password.length();

        if(length < 8 || length > 12)
            throw new IllegalArgumentException(WRONG_WARNING_MESSAGE);

    }

}
