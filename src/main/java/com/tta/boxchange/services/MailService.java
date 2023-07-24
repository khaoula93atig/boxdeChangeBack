package com.tta.boxchange.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tta.boxchange.dao.UserService;
import com.tta.boxchange.dto.RestPassword;
import com.tta.boxchange.entities.User;
import com.tta.boxchange.repositories.UserRepository;
import com.tta.boxchange.security.jwt.JwtUtils;

@Service
public class MailService {

	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
    JwtUtils jwtUtil;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	UserService userService;
	
	public void EnvoyerEmailAjout(User user) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {

		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

		mimeMessageHelper.setSubject("Bienvenue a notre Application box de change ");
		mimeMessageHelper.setFrom("TTA");
		mimeMessageHelper.setTo(user.getEmail());
		String url = "http://localhost:4200/mdpoublier/" + jwtUtil.generateTokenBylogin(user.getUsername());
		String content = "Bonjour ( Mme), "+user.getNom()+" " + user.getPrenom()
		+"\n"
		+ "vous etes inscris a notre application BoxDechange, pour acceder a votre espace voici vos coordonnées: \n" 
		
		+ "votre login: "+user.getUsername()
		+"\n"
		+ "pour intializez votre mot de passe vous devez acceder a ce lien, "+url
		+"\n"
		+ "Cordialement,";

		mimeMessageHelper.setText(content);
		/*mimeMessageHelper.setText("<html><body><p>" + content
		+ "</p> <img src=\"http://207.180.211.158/photo/assets/images/logo_dsms.png\" width=\"50\" alt=\"Apen\"></body></html>",
		true);*/
		mailSender.send(mimeMessageHelper.getMimeMessage());
		} catch (MessagingException e) {
		e.printStackTrace();
		}

		}
	
		public void resetPassword(RestPassword resetPassword, String login) {
	        User user = userRepository.getByUsername(login);
	        String pass = encoder.encode(resetPassword.getPassword());
	        user.setPassword(pass);
	        
	        userService.updateUser(user);
	
	    }
		
		public void EnvoyerEmail(User user) {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			try {

			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

			mimeMessageHelper.setSubject("Mot de Passe ");
			mimeMessageHelper.setFrom("TTA");
			mimeMessageHelper.setTo(user.getEmail());
			String url = "http://localhost:4200/mdpoublier/" + jwtUtil.generateTokenBylogin(user.getUsername());
			String content = "Bonjour ( Mme), "+user.getNom() +" " +user.getPrenom()
			+"\n"
			+ "Pour vous intializez votre mot de passe vous devez acceder a ce lien : \n" + url + "\n"
			+ "Cordialement,";

			mimeMessageHelper.setText(content);
			/*mimeMessageHelper.setText("<html><body><p>" + content
			+ "</p> <img src=\"http://207.180.211.164:8080/Elab/T.D/logo-ELAB-final.png\" width=\"50\" alt=\"Apen\"></body></html>",
			true);*/
			mailSender.send(mimeMessageHelper.getMimeMessage());
			} catch (MessagingException e) {
			e.printStackTrace();
			}

			}
}
