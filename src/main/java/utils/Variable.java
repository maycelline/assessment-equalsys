package utils;

public class Variable {
    private final String HOME_URL = "https://qa.eqlsys.site/";

    private final String LOGIN_URL = HOME_URL + "#login";

    private final String FORGOT_PASSWORD = HOME_URL + "#forgot_password";

    private final int WAIT_DURATION = 5000; //seconds

    public int getWAIT_DURATION() {
        return WAIT_DURATION;
    }

    public String getHOME_URL() {
        return HOME_URL;
    }

    public String getLOGIN_URL() {
        return LOGIN_URL;
    }

    public String getFORGOT_PASSWORD() {
        return FORGOT_PASSWORD;
    }
}
