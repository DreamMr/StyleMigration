
package com.stylemigration.stylemigration.service.webservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "transFormService", targetNamespace = "transFormService", wsdlLocation = "http://39.105.123.116:6688/?wsdl")
public class TransFormService
    extends Service
{

    private final static URL TRANSFORMSERVICE_WSDL_LOCATION;
    private final static WebServiceException TRANSFORMSERVICE_EXCEPTION;
    private final static QName TRANSFORMSERVICE_QNAME = new QName("transFormService", "transFormService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://39.105.123.116:6688/?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TRANSFORMSERVICE_WSDL_LOCATION = url;
        TRANSFORMSERVICE_EXCEPTION = e;
    }

    public TransFormService() {
        super(__getWsdlLocation(), TRANSFORMSERVICE_QNAME);
    }

    public TransFormService(WebServiceFeature... features) {
        super(__getWsdlLocation(), TRANSFORMSERVICE_QNAME, features);
    }

    public TransFormService(URL wsdlLocation) {
        super(wsdlLocation, TRANSFORMSERVICE_QNAME);
    }

    public TransFormService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TRANSFORMSERVICE_QNAME, features);
    }

    public TransFormService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TransFormService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Application
     */
    @WebEndpoint(name = "Application")
    public Application getApplication() {
        return super.getPort(new QName("transFormService", "Application"), Application.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Application
     */
    @WebEndpoint(name = "Application")
    public Application getApplication(WebServiceFeature... features) {
        return super.getPort(new QName("transFormService", "Application"), Application.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TRANSFORMSERVICE_EXCEPTION!= null) {
            throw TRANSFORMSERVICE_EXCEPTION;
        }
        return TRANSFORMSERVICE_WSDL_LOCATION;
    }

}