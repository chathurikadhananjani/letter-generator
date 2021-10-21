package com.task.letterConverter.rest;

import com.task.letterConverter.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;

@Controller
public class MainController {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmailService emailService;

    @RequestMapping("/index")
    public String Index(){
        return "index.html";
    }

    @GetMapping("/temp")
    public String Temp(){
        return "temp.html";
    }

        @GetMapping("/mail")
    public String showForm(){
        return "mail.html";
    }


    @PostMapping("/mail")
    public String mailRequest(HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {
        try{

        }catch (Exception e){

        }

        String email=request.getParameter("email");
        String name = request.getParameter("name");



        MimeMessage message= mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);

        String content=

                "<h3>Hello " + name+"</h3>" +"<b>This is a test Mail</b><br>" +
                        "here we attach your pdf...."+
                "<br><hr>" +

                "<img src='cid:logoImage'/>";

        helper.setFrom("chathurikatestapp@gmail.com","Letter Generating Tool");
        helper.setTo(email);
        helper.setText(content,true);
        helper.setSubject("letter generator");

        ClassPathResource pdf= new ClassPathResource("/static/images/Dear sir.docx");

        FileSystemResource fileSystemResource= new FileSystemResource(new File(String.valueOf(pdf)));


        helper.addAttachment(fileSystemResource.getFilename(), pdf);


        ClassPathResource resource=new ClassPathResource("/static/images/logo.png");
        helper.addInline("logoImage",resource);

        mailSender.send(message);
        System.out.println("Mail Sent");
        return "mail.html";


    }

//	@EventListener(ApplicationReadyEvent.class)
//	public void sendMail(){
//		emailService.sendEmail("chathurikatestapp@gmail.com",
//				"This is for ",
//				"This body send to test"
//		);
//	}


}
