
package stub;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the stub package. 
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

    private final static QName _GetStudentInfo_QNAME = new QName("http://ws.lexmark.com/", "getStudentInfo");
    private final static QName _SetStudentInfo_QNAME = new QName("http://ws.lexmark.com/", "setStudentInfo");
    private final static QName _SetStudentInfoResponse_QNAME = new QName("http://ws.lexmark.com/", "setStudentInfoResponse");
    private final static QName _GetStudentInfoResponse_QNAME = new QName("http://ws.lexmark.com/", "getStudentInfoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: stub
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SetStudentInfo }
     * 
     */
    public SetStudentInfo createSetStudentInfo() {
        return new SetStudentInfo();
    }

    /**
     * Create an instance of {@link GetStudentInfo }
     * 
     */
    public GetStudentInfo createGetStudentInfo() {
        return new GetStudentInfo();
    }

    /**
     * Create an instance of {@link GetStudentInfoResponse }
     * 
     */
    public GetStudentInfoResponse createGetStudentInfoResponse() {
        return new GetStudentInfoResponse();
    }

    /**
     * Create an instance of {@link SetStudentInfoResponse }
     * 
     */
    public SetStudentInfoResponse createSetStudentInfoResponse() {
        return new SetStudentInfoResponse();
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.lexmark.com/", name = "getStudentInfo")
    public JAXBElement<GetStudentInfo> createGetStudentInfo(GetStudentInfo value) {
        return new JAXBElement<GetStudentInfo>(_GetStudentInfo_QNAME, GetStudentInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetStudentInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.lexmark.com/", name = "setStudentInfo")
    public JAXBElement<SetStudentInfo> createSetStudentInfo(SetStudentInfo value) {
        return new JAXBElement<SetStudentInfo>(_SetStudentInfo_QNAME, SetStudentInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetStudentInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.lexmark.com/", name = "setStudentInfoResponse")
    public JAXBElement<SetStudentInfoResponse> createSetStudentInfoResponse(SetStudentInfoResponse value) {
        return new JAXBElement<SetStudentInfoResponse>(_SetStudentInfoResponse_QNAME, SetStudentInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.lexmark.com/", name = "getStudentInfoResponse")
    public JAXBElement<GetStudentInfoResponse> createGetStudentInfoResponse(GetStudentInfoResponse value) {
        return new JAXBElement<GetStudentInfoResponse>(_GetStudentInfoResponse_QNAME, GetStudentInfoResponse.class, null, value);
    }

}
