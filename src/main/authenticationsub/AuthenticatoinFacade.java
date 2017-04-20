package main.authenticationsub;

import main.model.Account;
import main.model.User;
import main.accountsub.AccountFacade;
import main.accountsub.AccountService;

/**
 * Created by Dora on 4/19/2017.
 */
public class AuthenticatoinFacade implements AuthenticationService {

    private AuthenticationSubcriber authenticationSubcriber = null;
    private AccountService accountService = null;

    public AuthenticatoinFacade() {
        this.accountService = new AccountFacade();
    }

    @Override
    public void registerAuthenticationSubscriber(AuthenticationSubcriber authenticationSubcriber) {
        this.authenticationSubcriber = authenticationSubcriber;
    }

    @Override
    public void login(String userName, String password) throws NullPointerException {
        Account account = this.accountService.getAccount(userName, password);
        if (this.authenticationSubcriber == null) {
            throw new NullPointerException("There is no authentication subscriber in this form");
        } else {
            if (account == null) {
                this.authenticationSubcriber.onLoginFail("Login fail!!!");
            } else {
                this.authenticationSubcriber.onLoginSuccess(account);
            }
        }
    }

    @Override
    public void forgotPassword() {

    }

    @Override
    public void resetPassword() {

    }
}
