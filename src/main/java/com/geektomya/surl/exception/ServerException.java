package com.geektomya.surl.exception;

import com.geektomya.surl.common.message.Messsage;

public class ServerException extends RuntimeException {

    public ServerException(){
        super(Messsage.SERVER_ERROR);
    }
}