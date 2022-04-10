package co.com.sofka.task;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetTags implements Task {

    private String resource;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(resource)
                        .with(
                                requestSpecification -> requestSpecification.relaxedHTTPSValidation()
                        )
        );

    }

    public GetTags usingTheResource(String resource) {
        this.resource=resource;
        return this;
    }

    public static GetTags getTags() {
        return new GetTags ();
    }

}
