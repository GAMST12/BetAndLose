package ua.skillsup.betandlose.model.message;

public class ResponseMessage {

    private String status;
    private String errorMessage;

    public static ResponseMessage okMessage(String message) {
        return new ResponseMessage("OK", message);
    }

    public static ResponseMessage errorMessage(String message) {
        return new ResponseMessage("ERROR", message);
    }


    private ResponseMessage(String status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public String getStatus() {
        return status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
