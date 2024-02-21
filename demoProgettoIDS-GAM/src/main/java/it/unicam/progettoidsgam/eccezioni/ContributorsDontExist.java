package it.unicam.progettoidsgam.eccezioni;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value= HttpStatus.CONFLICT)
public class ContributorsDontExist extends RuntimeException {

    @Serial
    private static final long sarialVersionUID = 1L;

    public ContributorsDontExist(String s) {
        super(s);
    }

    public ContributorsDontExist() {
        super("non esiste");
    }}