package jbr.springmvc.controller.apis;

public class EntryNotFoundException extends  RuntimeException{

    public EntryNotFoundException(String $message) {
        super($message);
    }
}
