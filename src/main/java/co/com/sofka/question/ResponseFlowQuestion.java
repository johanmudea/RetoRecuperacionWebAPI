package co.com.sofka.question;

import co.com.sofka.model.ResponseFlow;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseFlowQuestion implements Question {

    @Override
    public ResponseFlow answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(ResponseFlow.class);
    }

    public static ResponseFlowQuestion responseFlowQuestion(){
        return new ResponseFlowQuestion();
    }

}
