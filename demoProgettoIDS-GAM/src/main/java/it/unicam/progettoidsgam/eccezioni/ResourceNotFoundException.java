package it.unicam.progettoidsgam.eccezioni;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;
@ResponseStatus(value= HttpStatus.CONFLICT)
public class ResourceNotFoundException extends RuntimeException {

    @Serial
    private static final long sarialVersionUID = 1L;

    public ResourceNotFoundException(String s) {
        super(s);
    }

    public ResourceNotFoundException() {
        super("non esiste");
    }
}