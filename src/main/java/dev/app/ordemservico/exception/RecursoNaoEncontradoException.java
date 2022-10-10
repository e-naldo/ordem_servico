package dev.app.ordemservico.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class RecursoNaoEncontradoException extends EntityNotFoundException {
    public RecursoNaoEncontradoException() {
        super(String.format("Recurso não encontrado"));
    }
}
