
package de.uniluebeck.itm.pollservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for xsVotes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="xsVotes">
 *   &lt;complexContent>
 *     &lt;extension base="{www.itm.uniluebeck.de/pollservice}xs">
 *       &lt;sequence>
 *         &lt;element name="Voter" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "xsVotes", propOrder = {
    "voter"
})
public class XsVotes
    extends Xs
{

    @XmlElement(name = "Voter")
    protected List<String> voter;

    /**
     * Gets the value of the voter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the voter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVoter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getVoter() {
        if (voter == null) {
            voter = new ArrayList<String>();
        }
        return this.voter;
    }

}
