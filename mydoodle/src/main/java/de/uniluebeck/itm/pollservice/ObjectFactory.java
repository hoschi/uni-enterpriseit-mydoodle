
package de.uniluebeck.itm.pollservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.uniluebeck.itm.pollservice package. 
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

    private final static QName _PollInfo_QNAME = new QName("www.itm.uniluebeck.de/pollservice", "PollInfo");
    private final static QName _Votes_QNAME = new QName("www.itm.uniluebeck.de/pollservice", "Votes");
    private final static QName _GetPollResponse_QNAME = new QName("www.itm.uniluebeck.de/pollservice", "getPollResponse");
    private final static QName _Option_QNAME = new QName("www.itm.uniluebeck.de/pollservice", "Option");
    private final static QName _Vote_QNAME = new QName("www.itm.uniluebeck.de/pollservice", "Vote");
    private final static QName _Poll_QNAME = new QName("www.itm.uniluebeck.de/pollservice", "Poll");
    private final static QName _GetPolls_QNAME = new QName("www.itm.uniluebeck.de/pollservice", "getPolls");
    private final static QName _GetPollsResponse_QNAME = new QName("www.itm.uniluebeck.de/pollservice", "getPollsResponse");
    private final static QName _GetPoll_QNAME = new QName("www.itm.uniluebeck.de/pollservice", "getPoll");
    private final static QName _VoteForOptionsResponse_QNAME = new QName("www.itm.uniluebeck.de/pollservice", "voteForOptionsResponse");
    private final static QName _VoteForOptions_QNAME = new QName("www.itm.uniluebeck.de/pollservice", "voteForOptions");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.uniluebeck.itm.pollservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Xs }
     * 
     */
    public Xs createXs() {
        return new Xs();
    }

    /**
     * Create an instance of {@link XsPollInfo }
     * 
     */
    public XsPollInfo createXsPollInfo() {
        return new XsPollInfo();
    }

    /**
     * Create an instance of {@link XsOptionList }
     * 
     */
    public XsOptionList createXsOptionList() {
        return new XsOptionList();
    }

    /**
     * Create an instance of {@link VoteForOptionsResponse }
     * 
     */
    public VoteForOptionsResponse createVoteForOptionsResponse() {
        return new VoteForOptionsResponse();
    }

    /**
     * Create an instance of {@link XsVote }
     * 
     */
    public XsVote createXsVote() {
        return new XsVote();
    }

    /**
     * Create an instance of {@link GetPolls }
     * 
     */
    public GetPolls createGetPolls() {
        return new GetPolls();
    }

    /**
     * Create an instance of {@link XsPoll }
     * 
     */
    public XsPoll createXsPoll() {
        return new XsPoll();
    }

    /**
     * Create an instance of {@link GetPoll }
     * 
     */
    public GetPoll createGetPoll() {
        return new GetPoll();
    }

    /**
     * Create an instance of {@link GetPollsResponse }
     * 
     */
    public GetPollsResponse createGetPollsResponse() {
        return new GetPollsResponse();
    }

    /**
     * Create an instance of {@link GetPollResponse }
     * 
     */
    public GetPollResponse createGetPollResponse() {
        return new GetPollResponse();
    }

    /**
     * Create an instance of {@link XsOption }
     * 
     */
    public XsOption createXsOption() {
        return new XsOption();
    }

    /**
     * Create an instance of {@link XsVotes }
     * 
     */
    public XsVotes createXsVotes() {
        return new XsVotes();
    }

    /**
     * Create an instance of {@link VoteForOptions }
     * 
     */
    public VoteForOptions createVoteForOptions() {
        return new VoteForOptions();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XsPollInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "www.itm.uniluebeck.de/pollservice", name = "PollInfo")
    public JAXBElement<XsPollInfo> createPollInfo(XsPollInfo value) {
        return new JAXBElement<XsPollInfo>(_PollInfo_QNAME, XsPollInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XsVotes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "www.itm.uniluebeck.de/pollservice", name = "Votes")
    public JAXBElement<XsVotes> createVotes(XsVotes value) {
        return new JAXBElement<XsVotes>(_Votes_QNAME, XsVotes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPollResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "www.itm.uniluebeck.de/pollservice", name = "getPollResponse")
    public JAXBElement<GetPollResponse> createGetPollResponse(GetPollResponse value) {
        return new JAXBElement<GetPollResponse>(_GetPollResponse_QNAME, GetPollResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XsOption }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "www.itm.uniluebeck.de/pollservice", name = "Option")
    public JAXBElement<XsOption> createOption(XsOption value) {
        return new JAXBElement<XsOption>(_Option_QNAME, XsOption.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XsVote }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "www.itm.uniluebeck.de/pollservice", name = "Vote")
    public JAXBElement<XsVote> createVote(XsVote value) {
        return new JAXBElement<XsVote>(_Vote_QNAME, XsVote.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XsPoll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "www.itm.uniluebeck.de/pollservice", name = "Poll")
    public JAXBElement<XsPoll> createPoll(XsPoll value) {
        return new JAXBElement<XsPoll>(_Poll_QNAME, XsPoll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPolls }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "www.itm.uniluebeck.de/pollservice", name = "getPolls")
    public JAXBElement<GetPolls> createGetPolls(GetPolls value) {
        return new JAXBElement<GetPolls>(_GetPolls_QNAME, GetPolls.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPollsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "www.itm.uniluebeck.de/pollservice", name = "getPollsResponse")
    public JAXBElement<GetPollsResponse> createGetPollsResponse(GetPollsResponse value) {
        return new JAXBElement<GetPollsResponse>(_GetPollsResponse_QNAME, GetPollsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPoll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "www.itm.uniluebeck.de/pollservice", name = "getPoll")
    public JAXBElement<GetPoll> createGetPoll(GetPoll value) {
        return new JAXBElement<GetPoll>(_GetPoll_QNAME, GetPoll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoteForOptionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "www.itm.uniluebeck.de/pollservice", name = "voteForOptionsResponse")
    public JAXBElement<VoteForOptionsResponse> createVoteForOptionsResponse(VoteForOptionsResponse value) {
        return new JAXBElement<VoteForOptionsResponse>(_VoteForOptionsResponse_QNAME, VoteForOptionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoteForOptions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "www.itm.uniluebeck.de/pollservice", name = "voteForOptions")
    public JAXBElement<VoteForOptions> createVoteForOptions(VoteForOptions value) {
        return new JAXBElement<VoteForOptions>(_VoteForOptions_QNAME, VoteForOptions.class, null, value);
    }

}
