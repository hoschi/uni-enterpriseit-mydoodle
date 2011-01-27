
package de.uniluebeck.itm.pollservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for xsVote complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="xsVote">
 *   &lt;complexContent>
 *     &lt;extension base="{www.itm.uniluebeck.de/pollservice}xs">
 *       &lt;sequence>
 *         &lt;element name="OptionId" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Voter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "xsVote", propOrder = {
    "optionId",
    "voter"
})
public class XsVote
    extends Xs
{

    @XmlElement(name = "OptionId")
    protected List<String> optionId;
    @XmlElement(name = "Voter")
    protected String voter;

    /**
     * Gets the value of the optionId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the optionId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOptionId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getOptionId() {
        if (optionId == null) {
            optionId = new ArrayList<String>();
        }
        return this.optionId;
    }

    /**
     * Gets the value of the voter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVoter() {
        return voter;
    }

    /**
     * Sets the value of the voter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVoter(String value) {
        this.voter = value;
    }

}
