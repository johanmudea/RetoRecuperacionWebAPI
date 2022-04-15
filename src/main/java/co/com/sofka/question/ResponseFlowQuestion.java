package co.com.sofka.question;

import co.com.sofka.model.ResponseFlow;
import co.com.sofka.model.Tag;
import io.restassured.parsing.Parser;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

import java.util.Arrays;
import java.util.List;

public class ResponseFlowQuestion implements Question {

    private static  final String HTML = "html";
    private static  final String CSS = "css";
    private static  final String JAVASCRIPT = "javascript";


    @Override
    public Boolean answeredBy(Actor actor) {


        List<ResponseFlow> responseFlowList = Arrays.asList(
                LastResponse.received().answeredBy(actor).
                        then().parser("text/html", Parser.JSON).extract().response().as(ResponseFlow[].class)
        );

        int i = 0;
        int cantidadLibros = responseFlowList.size();

        for (ResponseFlow book : responseFlowList) {

            boolean cumpleCriterio = false;

            List<Tag> listaTag = book.getTags();

            for (Tag tag : listaTag) {

                if (tag.getNicename().contains(HTML) || tag.getNicename().contains(CSS) || tag.getNicename().contains(JAVASCRIPT)){
                    cumpleCriterio = true;
                    ++i;
                    break;

                }

            }

        }

        return i==cantidadLibros;

    }

    public static ResponseFlowQuestion responseFlowQuestion(){
        return new ResponseFlowQuestion();
    }

}
