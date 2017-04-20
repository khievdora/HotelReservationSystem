package main.authenticationsub;

import main.model.User;

/**
 * Created by Dora on 4/19/2017.
 */
public interface AuthenticationSubcriber {

    public void onLoginSuccess(User user);
    public void onLoginFail(String errMessage);
    public void onSessionExpired();

}
