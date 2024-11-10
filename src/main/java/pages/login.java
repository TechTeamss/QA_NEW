package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class login {

    @FindBy(id="user-name") private WebElement UN ;
    @FindBy(id="password") private WebElement PWD;
    @FindBy(id="login-button") private WebElement LoginBtn;
    @FindBy(xpath="//div[@class='error-message-container error']") private WebElement errorMsg;

public void enterCredentials(String username,String password){
    UN.sendKeys(username);
    PWD.sendKeys(password);
    LoginBtn.click();
}
public String getErrorMsg(){
    return errorMsg.getText();
}
}
