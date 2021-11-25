package api.steps;

import api.helperModel.GraphQLQuery;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.Country;
import model.Language;
import org.json.JSONObject;

import static org.testng.Assert.*;

public class CountrySteps extends BaseSteps {

    RequestSpecification requestSpecification = RestAssured.given().baseUri(baseURI).contentType("application/json");
    Response response;
    Country country;

    @Given("send request for getting country with code {string}")
    public void send_request_for_getting_country_with_code(String code) {
        GraphQLQuery graphQLQuery = new GraphQLQuery();
        graphQLQuery.setQuery("query country($code: ID!) {\r\n  country(code: $code) {\r\n    code\r\n    name\r\n    native\r\n    phone\r\n    continent {\r\n      code\r\n      name\r\n    }\r\n    capital\r\n    currency\r\n    languages {\r\n      code\r\n      native\r\n      name\r\n    }\r\n    emoji\r\n    states {\r\n      name\r\n    }\r\n  }\r\n}");

        JSONObject variables = new JSONObject();
        variables.put("code", code);

        graphQLQuery.setVariables(variables.toString());

        response = requestSpecification
                .body(graphQLQuery)
                .when()
                .post();

        country = response.jsonPath().getObject("data.country", Country.class);
    }

    @Then("country in response has language {string}")
    public void country_in_response_has_language(String language) {
        assertEquals(country.getLanguages().get(0).getName(), language);
    }

    @And("country in response has phone {string}")
    public void country_in_response_has_phone(String phone) {
        assertEquals(country.getPhone(), phone);
    }
}
