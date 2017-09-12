package com.epro.infrastructure.util;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import org.springframework.util.StringUtils;

public class CustomDateEditorThaiToUS extends PropertyEditorSupport{
	private final DateFormat dateFormat;
	private final boolean allowEmpty;
	private final int exactDateLength;

	public CustomDateEditorThaiToUS(DateFormat dateFormat, boolean allowEmpty) {
		this.dateFormat = dateFormat;
		this.allowEmpty = allowEmpty;
		this.exactDateLength = -1;
	}

	public CustomDateEditorThaiToUS(DateFormat dateFormat, boolean allowEmpty,
			int exactDateLength) {
		this.dateFormat = dateFormat;
		this.allowEmpty = allowEmpty;
		this.exactDateLength = exactDateLength;
	}

	public void setAsText(String text) throws IllegalArgumentException {
		if ((this.allowEmpty) && (!(StringUtils.hasText(text)))) {
			setValue(null);
		} else {
			
			if ((text != null) && (this.exactDateLength >= 0)
					&& (text.length() != this.exactDateLength)) {
				throw new IllegalArgumentException(
						"Could not parse date: it is not exactly"
								+ this.exactDateLength + "characters long");
			}

			try {
				setValue(this.dateFormat.parse(text));
			} catch (ParseException ex) {
				throw new IllegalArgumentException("Could not parse date: "
						+ ex.getMessage(), ex);
			}
		}
	}

	public String getAsText() {
		Date value = (Date) getValue();
		return ((value != null) ? this.dateFormat.format(value) : "");
	}
}
