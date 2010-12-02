
package de.uniluebeck.itm.pollservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for xsPoll complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="xsPoll">
 *   &lt;complexContent>
 *     &lt;extension base="{www.itm.uniluebeck.de/pollservice}xs">
 *       &lt;sequence>
 *         &lt;element name="OptionList" type="{www.itm.uniluebeck.de/pollservice}xsOptionList" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "xsPoll", propOrder = {
    "optionList",
    "title"
})
public class XsPoll
    extends Xs
{

    @XmlElement(name = "OptionList")
    protected List<XsOptionList> optionList;
    @XmlElement(name = "Title")
    protected String title;

    /**
     * Gets the value of the optionList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the optionList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOptionList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XsOptionList }
     * 
     * 
     */
    public List<XsOptionList> getOptionList() {
        if (optionList == null) {
            optionList = new ArrayList<XsOptionList>();
        }
        return this.optionList;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

}
