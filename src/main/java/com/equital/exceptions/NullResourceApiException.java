package com.equital.exceptions;

import com.equital.models.Resource;

import java.io.Serializable;

public class NullResourceApiException extends NullPointerException implements Serializable {

    private static final long serialVersionUID = 4013960727150798882L;

    public NullResourceApiException(Resource<?, ?> resource) {
        super("Null pointer exception to resource api: " + resource.getClass().getName());
    }

}
