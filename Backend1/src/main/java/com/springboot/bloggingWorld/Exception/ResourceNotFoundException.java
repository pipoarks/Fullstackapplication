package com.springboot.bloggingWorld.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;

    private String fieldName;

    private long fieldValue;

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {

        super( String.format("%s not found with %s : '%s'",resourceName,fieldName , fieldValue) );
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public void setFieldValue(long fieldValue) {
        this.fieldValue = fieldValue;
    }
}
