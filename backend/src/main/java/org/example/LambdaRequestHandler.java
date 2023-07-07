package org.example;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import marsrover.MarsRover;

public class LambdaRequestHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {


    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
        MarsRover marsRover = new MarsRover();
        String requestInput = Json.parse(input.getBody()).asObject().getString("input", "");

        String execute = marsRover.run(requestInput);

        JsonObject responseOutput = new JsonObject();
        responseOutput.add("instructions", execute);

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        response.setStatusCode(200);
        response.setBody(responseOutput.toString());
        return response;
    }


}
