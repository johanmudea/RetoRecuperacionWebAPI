package co.com.sofka.stepdefinition.gettags;



import co.com.sofka.model.Tag;
import co.com.sofka.stepdefinition.common.ServiceSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.hamcrest.Matchers;
import java.util.HashMap;

import static co.com.sofka.question.ResponseCode.responseCode;
import static co.com.sofka.question.ResponseFlowQuestion.responseFlowQuestion;
import static co.com.sofka.task.GetTags.getTags;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class GetTagsStepDefinition extends ServiceSetUp {

    private static final Logger LOGGER = Logger.getLogger(GetTagsStepDefinition.class);
    private final Actor actor = Actor.named("Johan The dev");
    private HashMap<String, Object> headers = new HashMap<>();


    @Given("I am in the web")
    public void iAmInTheWeb() {
        try {
            generalSetUp();
            actor.can(CallAnApi.at(BASE_URI));

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @When("I do a Get solicitation")
    public void iDoAGetSolicitation() {

        try {
            actor.attemptsTo(
                    getTags().usingTheResource(RESOURCE)
                            .withHeaders(headers)
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

        );

        actor.should(
                seeThat("devuelve elementos css: ", responseFlowQuestion(),Matchers.is(true))
        );

       // String tag = responseFlowQuestion().answeredBy(actor).getTags().get(1).getNicename().toString();

/*

        Tag tags = responseFlowQuestion().answeredBy(actor)
                .getTags().stream()
                .filter(x-> x.getNicename()=="css").findFirst().orElse(null);




        actor.should(
                seeThat("niceName",act -> tags,Matchers.notNullValue())

        );



    /*


        Category category = new ResponseFlowQuestion().answeredBy(actor)
                .getCategories().stream()
                .filter(x-> x.getNicename()=="HTML").findFirst().orElse(null);

        actor.should(
                seeThat("Is not null", act -> category, notNullValue())

        );

        /*

        actor.should(
               seeThat("nicename", actor1 -> category.getNicename(), equalTo("HTML"))
        );

       seeThat("el name", act -> category.getNicename(), equalTo("HTML"))


        */



    }


}
