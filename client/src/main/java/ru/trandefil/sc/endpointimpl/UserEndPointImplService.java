package ru.trandefil.sc.endpointimpl;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;
import ru.trandefil.sc.endpoint.UserEndPoint;

/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-03-11T15:50:03.537+03:00
 * Generated source version: 3.2.7
 *
 */
@WebServiceClient(name = "UserEndPointImplService",
                  wsdlLocation = "http://localhost:8080/JavaEE/UserEndPointImpl?wsdl",
                  targetNamespace = "http://endpointimpl.sc.trandefil.ru/")
public class UserEndPointImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://endpointimpl.sc.trandefil.ru/", "UserEndPointImplService");
    public final static QName UserEndPointImplPort = new QName("http://endpointimpl.sc.trandefil.ru/", "UserEndPointImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/JavaEE/UserEndPointImpl?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(UserEndPointImplService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/JavaEE/UserEndPointImpl?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public UserEndPointImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public UserEndPointImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UserEndPointImplService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public UserEndPointImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public UserEndPointImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public UserEndPointImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns UserEndPoint
     */
    @WebEndpoint(name = "UserEndPointImplPort")
    public UserEndPoint getUserEndPointImplPort() {
        return super.getPort(UserEndPointImplPort, UserEndPoint.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns UserEndPoint
     */
    @WebEndpoint(name = "UserEndPointImplPort")
    public UserEndPoint getUserEndPointImplPort(WebServiceFeature... features) {
        return super.getPort(UserEndPointImplPort, UserEndPoint.class, features);
    }

}
