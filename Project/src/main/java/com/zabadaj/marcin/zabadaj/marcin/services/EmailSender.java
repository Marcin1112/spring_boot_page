package com.zabadaj.marcin.zabadaj.marcin.services;

public interface EmailSender {
	void sendEmail(String to, String title, String content);
}
