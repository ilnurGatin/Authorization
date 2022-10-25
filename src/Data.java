public class Data {
    private static final String VALID_CHARS = "abcdifghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_";

    public static boolean validation(String login, String password, String confirmPassword) {
        try {
            checkLoginPassword(login, password, confirmPassword);
        } catch (WrongLoginExeption | WrongPasswordExeption e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            System.out.println("Данные проверены");
        }
        return true;
    }

    private static void checkLoginPassword(String login, String password, String confirmPassword)
            throws WrongLoginExeption, WrongPasswordExeption {
        if (!validate(login)) {
            throw new WrongLoginExeption("Невалидный логин");
        }
        if (!validate(password)) {
            throw new WrongPasswordExeption("Невалидный пароль");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordExeption("Пароли не совпадают");
        }
    }

    private static boolean validate(String s) {
        if (s.length() > 20 || s.isBlank())
            return false;

        for (int i = 0; i < s.length(); i++) {
            if (!VALID_CHARS.contains(String.valueOf(s.charAt(i)))) {
                return false;
            }
        }
        return true;
        }
    }



