/**
 * Converter.java
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.calindex.service;

public interface Converter extends java.rmi.Remote {

    public float celsiusToFarenheit(float celsius) throws java.rmi.RemoteException;

    public float farenheitToCelsius(float farenheit) throws java.rmi.RemoteException;

    public java.lang.String messageValidate(java.lang.String msgdata) throws java.rmi.RemoteException;
}
