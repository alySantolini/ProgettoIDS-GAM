package it.unicam.progettoidsgam.eccezioni;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value= HttpStatus.CONFLICT)
public class ResourceAlreadyExistsException extends RuntimeException {

    @Serial
    private static final long sarialVersionUID=1L;

    public ResourceAlreadyExistsException(String s) {
        super(s);
    }

    public ResourceAlreadyExistsException(){
        super("Esiste già");
    }
}
