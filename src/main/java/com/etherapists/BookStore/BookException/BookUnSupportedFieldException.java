package com.etherapists.BookStore.BookException;

import java.util.Set;

public class BookUnSupportedFieldException extends RuntimeException{
	
	public BookUnSupportedFieldException(Set<String> keys) {
		super("Field " + keys.toString() + " update is not allow.");
	}

}
