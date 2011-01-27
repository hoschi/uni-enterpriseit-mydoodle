
package de.uniluebeck.itm.pollservice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "Pollservice", targetNamespace = "www.itm.uniluebeck.de/pollservice", wsdlLocation = "file:/Users/jacob/git/uni-enterpriseit-mydoodle/src/main/resources/wsdl/Pollservice.wsdl")
public class Pollservice
    extends Service
{

    private final static URL POLLSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(de.uniluebeck.itm.pollservice.Pollservice.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = de.uniluebeck.itm.pollservice.Pollservice.class.getResource(".");
            url = new URL(baseUrl, "file:/Users/jacob/git/uni-enterpriseit-mydoodle/src/main/resources/wsdl/Pollservice.wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'file:/Users/jacob/git/uni-enterpriseit-mydoodle/src/main/resources/wsdl/Pollservice.wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        POLLSERVICE_WSDL_LOCATION = url;
    }

    public Pollservice(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Pollservice() {
        super(POLLSERVICE_WSDL_LOCATION, new QName("www.itm.uniluebeck.de/pollservice", "Pollservice"));
    }

    /**
     * 
     * @return
     *     returns PollWebService
     */
    @WebEndpoint(name = "PollWebServicePort")
    public PollWebService getPollWebServicePort() {
        return super.getPort(new QName("www.itm.uniluebeck.de/pollservice", "PollWebServicePort"), PollWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PollWebService
     */
    @WebEndpoint(name = "PollWebServicePort")
    public PollWebService getPollWebServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("www.itm.uniluebeck.de/pollservice", "PollWebServicePort"), PollWebService.class, features);
    }

}