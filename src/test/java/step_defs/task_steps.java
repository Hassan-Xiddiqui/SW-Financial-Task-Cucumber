package step_defs;
import POM.PageObject;
import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class task_steps {


    @Given("^User navigates to the Website$")
    public void user_navigates_to_the_Login_Page() {
        // Write code here that turns the phrase above into concrete actions

//        PageObject.chromeConfig();
        PageObject.edgeConfig();
    }

    @Then("^User Login to the Website with valid creds$")
    public void user_Login_in_to_the_Website_with_valid_creds() {
        // Write code here that turns the phrase above into concrete actions

        PageObject.signIn("standard_user","secret_sauce");
    }

    @When("^Change Dropdown from A-Z to Z-A$")
    public void change_Dropdown_from_A_Z_to_Z_A() {
        // Write code here that turns the phrase above into concrete actions

        PageObject.filterProducts("za");
    }

    @When("^Add item to cart if the price is lower than \\$(\\d+)\\.(\\d+)$")
    public void add_item_to_cat_if_the_price_is_lower_than_$(int arg1, int arg2) {
        // Write code here that turns the phrase above into concrete actions

        PageObject.addProductcondition();
    }

    @Then("^Click on the Cart$")
    public void click_on_the_Cart() {
        // Write code here that turns the phrase above into concrete actions

        PageObject.clickCart();
    }

    @Then("^Remove item if the price is greater than \\$(\\d+)$")
    public void remove_item_if_the_price_is_greater_than_$(int arg1) {
        // Write code here that turns the phrase above into concrete actions

        PageObject.removeProductcondition();
    }

    @Then("^Click Check out$")
    public void click_Check_out() {
        // Write code here that turns the phrase above into concrete actions

        PageObject.clickCheckout();
    }

    @Then("^Fill the form$")
    public void fill_the_form() {
        // Write code here that turns the phrase above into concrete actions

        PageObject.fillForm("Hassan","Siddiqui",75300);
    }

    @Then("^Press the Continue Button$")
    public void press_the_Continue_Button() {
        // Write code here that turns the phrase above into concrete actions

        PageObject.contButton();
    }

    @Then("^Press the Finish Button$")
    public void press_the_Finish_Button() {
        // Write code here that turns the phrase above into concrete actions

        PageObject.finishButton();
    }

    @And("^User will logout$")
    public void user_will_logout() {
        // Write code here that turns the phrase above into concrete actions

        PageObject.logout();
    }

    @Then("^New User will Login to the Website")
    public void new_user_will_login_to_the_website() {
        // Write code here that turns the phrase above into concrete actions

        PageObject.signIn("problem_user","secret_sauce");
    }

    @After
    public void TearDown(){
        PageObject.close();
    }
}
