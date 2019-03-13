
package ru.trandefil.sc.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.trandefil.sc.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ClearJson_QNAME = new QName("http://generated.sc.trandefil.ru/", "clearJson");
    private final static QName _ClearJsonResponse_QNAME = new QName("http://generated.sc.trandefil.ru/", "clearJsonResponse");
    private final static QName _LoadJson_QNAME = new QName("http://generated.sc.trandefil.ru/", "loadJson");
    private final static QName _LoadJsonResponse_QNAME = new QName("http://generated.sc.trandefil.ru/", "loadJsonResponse");
    private final static QName _SaveJson_QNAME = new QName("http://generated.sc.trandefil.ru/", "saveJson");
    private final static QName _SaveJsonResponse_QNAME = new QName("http://generated.sc.trandefil.ru/", "saveJsonResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.trandefil.sc.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ClearJson }
     * 
     */
    public ClearJson createClearJson() {
        return new ClearJson();
    }

    /**
     * Create an instance of {@link ClearJsonResponse }
     * 
     */
    public ClearJsonResponse createClearJsonResponse() {
        return new ClearJsonResponse();
    }

    /**
     * Create an instance of {@link LoadJson }
     * 
     */
    public LoadJson createLoadJson() {
        return new LoadJson();
    }

    /**
     * Create an instance of {@link LoadJsonResponse }
     * 
     */
    public LoadJsonResponse createLoadJsonResponse() {
        return new LoadJsonResponse();
    }

    /**
     * Create an instance of {@link SaveJson }
     * 
     */
    public SaveJson createSaveJson() {
        return new SaveJson();
    }

    /**
     * Create an instance of {@link SaveJsonResponse }
     * 
     */
    public SaveJsonResponse createSaveJsonResponse() {
        return new SaveJsonResponse();
    }

    /**
     * Create an instance of {@link Session }
     * 
     */
    public Session createSession() {
        return new Session();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearJson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.sc.trandefil.ru/", name = "clearJson")
    public JAXBElement<ClearJson> createClearJson(ClearJson value) {
        return new JAXBElement<ClearJson>(_ClearJson_QNAME, ClearJson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearJsonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.sc.trandefil.ru/", name = "clearJsonResponse")
    public JAXBElement<ClearJsonResponse> createClearJsonResponse(ClearJsonResponse value) {
        return new JAXBElement<ClearJsonResponse>(_ClearJsonResponse_QNAME, ClearJsonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadJson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.sc.trandefil.ru/", name = "loadJson")
    public JAXBElement<LoadJson> createLoadJson(LoadJson value) {
        return new JAXBElement<LoadJson>(_LoadJson_QNAME, LoadJson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadJsonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.sc.trandefil.ru/", name = "loadJsonResponse")
    public JAXBElement<LoadJsonResponse> createLoadJsonResponse(LoadJsonResponse value) {
        return new JAXBElement<LoadJsonResponse>(_LoadJsonResponse_QNAME, LoadJsonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveJson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.sc.trandefil.ru/", name = "saveJson")
    public JAXBElement<SaveJson> createSaveJson(SaveJson value) {
        return new JAXBElement<SaveJson>(_SaveJson_QNAME, SaveJson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveJsonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.sc.trandefil.ru/", name = "saveJsonResponse")
    public JAXBElement<SaveJsonResponse> createSaveJsonResponse(SaveJsonResponse value) {
        return new JAXBElement<SaveJsonResponse>(_SaveJsonResponse_QNAME, SaveJsonResponse.class, null, value);
    }

}
