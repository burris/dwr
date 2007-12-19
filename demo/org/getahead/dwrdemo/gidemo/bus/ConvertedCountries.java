package org.getahead.dwrdemo.gidemo.bus;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.directwebremoting.proxy.jsx3.xml.CdfDocument;
import org.directwebremoting.proxy.jsx3.xml.Record;


/**
 * 
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class ConvertedCountries
{
    /**
     * Convert to a {@link CdfDocument} to export
     * @return A {@link CdfDocument} that contains the countries
     */
    public CdfDocument getCountries()
    {
        CdfDocument document = new CdfDocument("root");

        int index = 1;
        for (Country country : countries.getCountries())
        {
            document.appendRecord(new Record(country.getId())
                .setAttribute("index", String.valueOf(index++))
                .setText(country.getName()));
        }

        log.info("XML=" + document.toXml());
        return document;
    }

    private Countries countries = new Countries();

    /**
     * The log stream
     */
    private static Log log = LogFactory.getLog(ConvertedCountries.class);
}
