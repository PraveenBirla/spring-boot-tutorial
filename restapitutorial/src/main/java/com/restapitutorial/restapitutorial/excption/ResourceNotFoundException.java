package com.restapitutorial.restapitutorial.excption;

public class ResourceNotFoundException extends RuntimeException{

     public  ResourceNotFoundException(String message){
           super(message);
       }
}
