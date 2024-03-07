package com.practice.practice.exception;

import javax.management.InstanceAlreadyExistsException;

public class ExceptionAlreadyExists extends InstanceAlreadyExistsException {
    public ExceptionAlreadyExists(){
        super("Este dato ya existe en la tabla que se quiere ingresar, revise la información y vuelva a intentar");
    }
}
