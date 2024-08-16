import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validapass extends Thread {
    private String password;
    private boolean validez;

    public Validapass(String password) {
        this.password = password;
    }

    @Override
    public void run() {
        String regex = "^(?=(?:[^A-Z]*[A-Z]){2})(?=(?:[^a-z]*[a-z]){3})(?=.*\\d)(?=.*[!@#$%^&*(),.?\":{}|<>])[A-Za-z\\d!@#$%^&*(),.?\":{}|<>]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        validez = matcher.matches();
    }

    public boolean validez() {
        return validez;
    }

    public static void main(String[] args) {
        String pass1 = "123456789";
        String pass2 = "EstaContraDeberiaPasar12@"; //Solo esta
        String pass3 = "Hola123";
        String pass4 = "@@@@@@@@@@@@@@@@";
        String pass5 = "aaaaaaaaaaaaaaaaa";
        String pass6 = "EEEEEEEEEEEEEEE";
        String pass7 = "IiIiIiIiIiIiIiIiI";
        String pass8 = "O1O1O1O1O1O1o1O1Oo1o";
        String pass9 = "U@1Pa12@@1lakmzwdmqxqlomxiw1"; //Y esta cumplen los requisitos
        String pass10 = "abcdefghijklmnñopqrstuvwxyz";

        Validapass validador1 = new Validapass(pass1);
        Validapass validador2 = new Validapass(pass2);
        Validapass validador3 = new Validapass(pass3);
        Validapass validador4 = new Validapass(pass4);
        Validapass validador5 = new Validapass(pass5);
        Validapass validador6 = new Validapass(pass6);
        Validapass validador7 = new Validapass(pass7);
        Validapass validador8 = new Validapass(pass8);
        Validapass validador9 = new Validapass(pass9);
        Validapass validador10 = new Validapass(pass10);

        validador1.start();
        validador2.start();
        validador3.start();
        validador4.start();
        validador5.start();
        validador6.start();
        validador7.start();
        validador8.start();
        validador9.start();
        validador10.start();

        try {
            validador1.join();
            validador2.join();
            validador3.join();
            validador4.join();
            validador5.join();
            validador6.join();
            validador7.join();
            validador8.join();
            validador9.join();
            validador10.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("La contraseña 1 pasa los requisitos: " + validador1.validez());
        System.out.println("La contraseña 2 pasa los requisitos: " + validador2.validez());
        System.out.println("La contraseña 3 pasa los requisitos: " + validador3.validez());
        System.out.println("La contraseña 4 pasa los requisitos: " + validador4.validez());
        System.out.println("La contraseña 5 pasa los requisitos: " + validador5.validez());
        System.out.println("La contraseña 6 pasa los requisitos: " + validador6.validez());
        System.out.println("La contraseña 7 pasa los requisitos: " + validador7.validez());
        System.out.println("La contraseña 8 pasa los requisitos: " + validador8.validez());
        System.out.println("La contraseña 9 pasa los requisitos: " + validador9.validez());
        System.out.println("La contraseña 10 pasa los requisitos: " + validador10.validez());
    }
}