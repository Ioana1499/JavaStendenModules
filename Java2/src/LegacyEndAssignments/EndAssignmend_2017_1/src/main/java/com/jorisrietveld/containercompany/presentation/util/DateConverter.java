package com.jorisrietveld.containercompany.presentation.util;

import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 09-11-2017 08:18
 * License: GPLv3 - General Public License version 3
 */
public class DateConverter extends StringConverter<LocalDate>
{
    private DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public String toString(LocalDate localDate)
    {
        if(localDate==null)
            return "";
        return dateTimeFormatter.format(localDate);
    }

    @Override
    public LocalDate fromString(String dateString)
    {
        if(dateString==null || dateString.trim().isEmpty())
        {
            return null;
        }
        return LocalDate.parse(dateString,dateTimeFormatter);
    }
}
