package co.com.sofka.stepdefinition.gettags;

import co.com.sofka.stepdefinition.common.ServiceSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.hamcrest.Matchers;

import static co.com.sofka.question.ResponseCode.responseCode;
import static co.com.sofka.task.GetTags.getTags;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class GetTagsStepDefinition extends ServiceSetUp {

    private static final Logger LOGGER = Logger.getLogger(GetTagsStepDefinition.class);
    private final Actor actor = Actor.named("Johan The dev");


    @Given("I am in the web")
    public void iAmInTheWeb() {

        try {
            generalSetUp();
            actor.can(CallAnApi.at(BASE_URI+RESOURCE));

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }



    @When("I do a Get solicitation")
    public void iDoAGetSolicitation() {

        try {
            actor.attemptsTo(
                    getTags().usingTheResource(BASE_URI+RESOURCE)
            );
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }


    @Then("I obtain a http response of the business flow")
    public void iObtainAHttpResponseOfTheBusinessFlow() {



                actor.should(
                        seeThatResponse("el status debería ser"+HttpStatus.SC_OK,
                                validatableResponse -> validatableResponse.statusCode(HttpStatus.SC_OK)

                                ),
                        seeThat("la respuesta debería ser nula: ", responseCode(),Matchers.notNullValue())

                )

                ;


    }


}
