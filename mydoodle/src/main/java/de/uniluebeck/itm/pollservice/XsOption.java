
package de.uniluebeck.itm.pollservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for xsOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="xsOption">
 *   &lt;complexContent>
 *     &lt;extension base="{www.itm.uniluebeck.de/pollservice}xs">
 *       &lt;sequence>
 *         &lt;element name="dateTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="votes" type="{www.itm.uniluebeck.de/pollservice}xsVotes" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "xsOption", propOrder = {
    "dateTime",
    "value",
    "votes"
})
public class XsOption
    extends Xs
{

    protected String dateTime;
    protected String value;
    protected XsVotes votes;

    /**
     * Gets the value of the dateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     * Sets the value of the dateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateTime(String value) {
        this.dateTime = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the votes property.
     * 
     * @return
     *     possible object is
     *     {@link XsVotes }
     *     
     */
    public XsVotes getVotes() {
        return votes;
    }

    /**
     * Sets the value of the votes property.
     * 
     * @param value
     *     allowed object is
     *     {@link XsVotes }
     *     
     */
    public void setVotes(XsVotes value) {
        this.votes = value;
    }

}
