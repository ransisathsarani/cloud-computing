package handler;


import com.amazonaws.services.lambda.runtime.Context;

public class LambdaHandler {

    public String handleRequest(String input, Context context){
        context.getLogger().log("User Input: " + input);
        return "Hello - " + input;
    }
}
