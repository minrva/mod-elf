package org.folio.rest.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import org.folio.rest.utils.EmailTransaction;

public class EmailComposer {

	/** smtp */
	private final String SMTP_USERNAME = "username";
    private final String SMTP_PASSWORD = "password";
    private final String SMTP_HOST = "smtp.gmail.com";
    private final String SMTP_PORT = "587";

	/** e-mail settings */
	private final String LIBRARY_NAME = "Datalogisk Institut";
	private final String LIBRARY_PHONE = "29979812";
	private final String HOME_PAGE = "http://diku.dk";
	private final String BANNER = "http://diku.dk/english/about/topgrafik/AboutDIKU_Top_505px.jpg?size=700x267";
	private final String FB_ICON = "https://images2.imgbox.com/dd/7b/dERSD77S_o.png";
	private final String FB_LINK = "https://www.facebook.com/universitet";
	private final String TWITTER_ICON = "https://images2.imgbox.com/17/29/H9U3G6if_o.png";
	private final String TWITTER_LINK = "https://twitter.com/uni_copenhagen";

	private final String CHECKOUT_EMAIL_SUBJECT = "Checked Out";
	private final String CHECKOUT_EMAIL_PERSONAL = "Tech Circulation";
	private final String CHECKOUT_EMAIL_PDF_NAME = "Equipment_Loan_Form.pdf";
	private final String CHECKOUT_EMAIL_FROM_ADDRESS = "techcirc@folio.org";

	private final String CHECKIN_EMAIL_SUBJECT = "Item Returned";
	private final String CHECKIN_EMAIL_PERSONAL = "Tech Circulation";
	private final String CHECKIN_EMAIL_PDF_NAME = "Equipment_Loan_Form.pdf";
	private final String CHECKIN_EMAIL_FROM_ADDRESS = "techcirc@folio.org";	
	
	/** templates */	
	private final String CHECKOUT_MSG_TEMPLATE = "Thank you for using the Loanable Technology Program, located at the @@LIBRARY_NAME@@. "
	+ "The <b>@@ITEMNAME@@</b> you checked out is due <b>@@DATE@@ by @@TIME@@</b>. "
	+ "<br><br>If you would like to renew the item, please contact the Library's Circulation & Reserves desk at @@LIBRARY_PHONE@@ "
	+ "or stop by in person. Renewals are subject to item availability and staff discretion. "
	+ "<br><br>For more information about the item you have checked out, please see the attached copy of the loan agreement.";	

	private final String CHECKIN_EMAIL_MSG_TEMPLATE = "Thank you for using the Loanable Technology Program! " 
	+ "The <b>@@ITEMNAME@@</b> that was checked out to you has been checked in and is no longer on your account. " 
	+ "<br><br>Please let us know if you have further questions by contacting us at the Circulation & Reserves desk "
	+ "at @@LIBRARY_PHONE@@ or by stopping by in person. <br><br>We hope to see you again soon!";

	private final String EMAIL_TEMPLATE = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n"
	+ "<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n" 
	+ "<head>\r\n  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n"
	+ "  <title>Loanable Technology</title>\r\n  "
	+ "  <style type=\"text/css\">\r\n  "
	+ "    body {\r\n   padding-top: 0 !important;\r\n   padding-bottom: 0 !important;\r\n   padding-top: 0 !important;\r\n   padding-bottom: 0 !important;\r\n   margin:0 !important;\r\n   width: 100% !important;\r\n   -webkit-text-size-adjust: 100% !important;\r\n   -ms-text-size-adjust: 100% !important;\r\n   -webkit-font-smoothing: antialiased !important;\r\n }\r\n .tableContent img {\r\n   border: 0 !important;\r\n   display: block !important;\r\n   outline: none !important;\r\n }\r\n\r\np, h2{\r\n  margin:0;\r\n  color:#333\r\n}\r\n\r\np, h2{\r\n\tfont-family: \"Helvetica Neue\",Helvetica,Arial,sans-serif;\r\n\tfont-size: 14px;\r\n}\r\n\r\ndiv,p,ul,h2,h2{\r\n  margin:0;\r\n}\r\n\r\nh2.bigger,h2.bigger{\r\n  font-size: 32px;\r\n  font-weight: normal;\r\n}\r\n\r\nh2.big,h2.big{\r\n  font-size: 21px;\r\n  font-weight: normal;\r\n}\r\n\r\na.link1{\r\n\tfont-family: \"Helvetica Neue\",Helvetica,Arial,sans-serif;\r\n\tcolor:#62A9D2;font-size:14px;font-weight:bold;text-decoration:none;\r\n}\r\n\r\na.link2{\r\n\tfont-family: \"Helvetica Neue\",Helvetica,Arial,sans-serif;\r\n\tpadding:8px;background:#62A9D2;font-size:14px;color:#ffffff;text-decoration:none;font-weight:bold;\r\n}\r\n\r\na.link3{\r\n\tfont-family: \"Helvetica Neue\",Helvetica,Arial,sans-serif;\r\n\tbackground:#62A9D2; color:#ffffff; padding:8px 10px;text-decoration:none;font-size:13px;\r\n}\r\n.bgBody{\r\nbackground: #F6F6F6;\r\n}\r\n.bgItem{\r\nbackground: #ffffff;\r\n}\r\n"
	+ "  </style>\r\n\r\n\r\n"
	+ "  <script type=\"colorScheme\" class=\"swatch active\">\r\n  {\r\n    \"name\":\"Default\",\r\n    \"bgBody\":\"#F6F6F6\",\r\n    \"link\":\"62A9D2\",\r\n    \"color\":\"999999\",\r\n    \"bgItem\":\"ffffff\",\r\n    \"title\":\"555555\"\r\n  }\r\n</script> \r\n\r\n"
	+ "</head>\r\n" 
	+ "<body "
	+ "paddingwidth=\"0\" paddingheight=\"0\"   style=\"padding-top: 0; padding-bottom: 0; padding-top: 0; padding-bottom: 0; background-repeat: repeat; width: 100% !important; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; -webkit-font-smoothing: antialiased;\" offset=\"0\" toppadding=\"0\" leftpadding=\"0\">\r\n  \r\n\r\n  "
	+ "<table style='border-collapse:collapse;' bgcolor= '#F6F6F6' width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"tableContent bgBody\" align=\"center\">\r\n    \r\n    <!--  =========================== The header ===========================  -->      \r\n    \r\n    <tr>\r\n      <td height='25' bgcolor='#022544' colspan='3'></td>\r\n    </tr>\r\n\r\n    <tr>\r\n      <td height='130' bgcolor='#022544'>&nbsp;</td>\r\n      <td rowspan='2' width='600' valign='top'>\r\n        "
	+ "	<table width=\"600\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" >\r\n          \r\n          <!--  =========================== The body ===========================  -->   \r\n          \r\n\r\n          <tr>\r\n            <td class='movableContentContainer'>\r\n              \r\n              <div class='movableContent'>\r\n                <table width=\"600\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" valign='top'>\r\n                  <tr>\r\n                    <td valign='top'>\r\n                      <table width=\"600\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" align=\"center\" valign='top'>\r\n                        <tr bgcolor='#022544'>\r\n                          <td align='left' valign='middle' >\r\n                            <div class=\"contentEditableContainer contentImageEditable\">\r\n                              <div class=\"contentEditable\" >\r\n                                \r\n\t\t\t\t\t\t\t\t"
	+ " 	\r\n                              </div>\r\n                            </div>\r\n                          </td>\r\n\t\t\t\t\t\t<td align='left' valign='left' >\r\n                            <div class=\"contentEditableContainer contentImageEditable\">\r\n                              <div class=\"contentEditable\" >\r\n                                \r\n\t\t\t\t\t\t\t  </div>\r\n                            </div>\r\n                          </td>\r\n                          <td align='right' valign='top' >\r\n                            <div class=\"contentEditableContainer contentTextEditable\" style='display:inline-block;'>\r\n                              \r\n                            </div>\r\n                          </td>\r\n                          <td width='18' align='right' valign='top'>\r\n                            <div class=\"contentEditableContainer contentImageEditable\" style='display:inline-block;'>\r\n                              <div class=\"contentEditable\" >\r\n                              </div>\r\n                            </div>\r\n                          </td>\r\n                        </tr>\r\n                      "
	+ "	</table>\r\n                    </td>\r\n                  </tr>\r\n                </table>\r\n              </div>\r\n\r\n              <div class='movableContent'>\r\n                <table width=\"600\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" valign='top' bgcolor='white'>\r\n                  <tr><td height='25' bgcolor='#022544'></td></tr>\r\n\r\n                <tr><td height='5' bgcolor='#022544'></td></tr>\r\n\r\n                <tr><td height='40' class='bgItem'></td></tr>\r\n\r\n                <tr>\r\n                  <td>\r\n                    <table width=\"600\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" valign='top' class='bgItem' bgcolor='white'>\r\n "
	+ "                     <tr>\r\n                        <td  width='70'></td>\r\n                        <td  align='center' width='530'>\r\n                          <div class='contentEditableContainer contentTextEditable'>\r\n                            <div class=\"contentEditable\" style='font-size:32px;color:#555555;font-weight:normal;'>\r\n                              <h2 style='font-size:32px;'>Loanable Technology</h2>\r\n                            </div>\r\n                          </div>\r\n                        </td>\r\n                        <td  width='70'></td>\r\n                      </tr>\r\n\r\n                      <tr><td colspan='3' height='22' ></td></tr>\r\n\r\n                      <tr>\r\n                        <td width='70'></td>\r\n                        <td  align='left' width='530'>\r\n                          <div class='contentEditableContainer contentTextEditable'>\r\n                            <div class=\"contentEditable\" style='color:#99A1A6;line-height:19px;'>\r\n                              <p>@@MESSAGE@@</p>\r\n                            </div>\r\n                          </div>\r\n                        </td>\r\n                        <td  width='70'></td>\r\n                      </tr>\r\n\r\n                      <tr><td colspan='3' height='45' ></td></tr>\r\n\r\n                    "
	+ "</table>\r\n                  </td>\r\n                </tr>\r\n                </table>\r\n              </div>\r\n\r\n\t\t\t  <div class='movableContent'>\r\n                      <table width=\"600\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" valign='top'>\r\n                        <tr>\r\n                          <td>\r\n                            <div class='contentEditableContainer contentImageEditable'>\r\n                              <div class=\"contentEditable\">\r\n                                <img src=\"@@BANNER@@\" alt='Image of location' data-default=\"placeholder\" data-max-width=\"600\" width='600' height='180' >\r\n "
	+ "                             </div>\r\n                            </div>\r\n                          </td>\r\n                        </tr>\r\n                        <tr><td height='10' bgcolor='#CCDFF6'></td></tr>\r\n                        <tr>\r\n                          <td bgcolor='#CCDFF6' style='padding:8px 0;'>\r\n                            <table width=\"600\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" valign='top'>\r\n                              <tr>\r\n                                <td width='20'></td>\r\n                                <td align='left' valign='top' width='370'>\r\n                                  <div class='contentEditableContainer contentTextEditable'>\r\n                                    <div class=\"contentEditable\" style='line-height:19px;'>\r\n                                      <p >The library offers a wide range of technology and support centered around collaboration and digital media.</p>\r\n                                    </div>\r\n                                  </div>\r\n                                </td>\r\n                                <td width='20'></td>\r\n                                <td align='center' valign='middle' width='180'>\r\n                                  <div class='contentEditableContainer contentTextEditable'>\r\n                                    <div class=\"contentEditable\">\r\n                                      <a target='_blank' class='link3' href=\"@@HOME_PAGE@@\" style='background:#efefef; border: 1px solid; border-color: #204D74; color:#1F3762; padding:8px 10px;text-decoration:none;'>FIND OUT MORE</a>\r\n                                    </div>\r\n                                  </div>\r\n                                </td>\r\n                                <td width='20'></td>\r\n                              </tr>\r\n                            </table>\r\n                          </td>\r\n                        </tr>\r\n                        <tr><td height='10' bgcolor='#CCDFF6'></td></tr>\r\n  "
	+ "                    </table>\r\n                    </div>\r\n\t\t\t\t\t\r\n                <div class='movableContent'>\r\n                <table width=\"600\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" valign='top'>\r\n                  <tr><td height='10' bgcolor='#F6F6F6'></td></tr>\r\n                    <tr>\r\n                      <td>\r\n                        <table width=\"600\" height='55' border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" valign='top' bgcolor='#022544'>\r\n                          <tr>\r\n                            <td width='25'></td>\r\n                            <td width='475' valign='middle'>\r\n                              <div class='contentEditableContainer contentTextEditable'>\r\n                                <div class=\"contentEditable\" style='font-style:italic;color:#0F4666;line-height:19px;'>\r\n                                  <p style='color:#fff;'>Find us on:</p>\r\n                                </div>\r\n                              </div>\r\n                            </td>\r\n                            <td width='45' valign='middle'>\r\n                              <div class='contentEditableContainer contentFacebookEditable'>\r\n                                <div class=\"contentEditable\">\r\n                                  <a target='_blank' href='@@FB_LINK@@'><img src=\"@@FB_ICON@@\" alt='facebook' data-default=\"placeholder\" data-customIcon=\"true\" data-max-width='45' width='45' height='45' ></a>\r\n                                </div>\r\n                              </div>\r\n                            </td>\r\n                            <td width='10'></td>\r\n                            <td width='45' valign='middle'>\r\n                              <div class='contentEditableContainer contentTwitterEditable'>\r\n                                <div class=\"contentEditable\">\r\n                                  "
	+ "<a target='_blank' href=@@TWITTER_LINK@@><img src=\"@@TWITTER_ICON@@\" alt='Twitter' data-default=\"placeholder\" data-customIcon=\"true\" data-max-width='45' width='45' height='45' ></a>\r\n                                </div>\r\n                              </div>  \r\n                            </td>\r\n                            <td width='10'></td>\r\n                          </tr>\r\n                        </table>\r\n                      </td>\r\n                    </tr>\r\n                    <tr><td height='10' bgcolor='#F6F6F6'></td></tr>\r\n                </table>\r\n              </div>\r\n\r\n                 <div class='movableContent'>\r\n                      <table width=\"600\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" valign='top'>\r\n                        <tr><td height='20' </td></tr>\r\n                      </table>\r\n                    </div>\r\n\r\n\r\n           \r\n\r\n\r\n              <div class='movableContent'>\r\n                <table width=\"600\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" valign='top' class='bgBody' >\r\n                  <tr><td height='54' style='border-bottom:1px solid #DAE0E4'>&nbsp;</td></tr>\r\n\r\n                  <tr><td height='28'></td></tr>\r\n\r\n                  <tr>\r\n                    <td valign='top' align='left'>\r\n                      <div class=\"contentEditableContainer contentTextEditable\">\r\n                        <div class=\"contentEditable\" style='color:#A8B0B6; font-size:13px;line-height: 16px;'>\r\n                          <p >\t <br>\r\n\t\t\t\t\t\t\t\tCirculation, Reserves, and Loanable Technology Desk <br>\r\n\t\t\t\t\t\t\t\t@@LIBRARY_NAME@@  <br>\r\n                          </p>\r\n                        </div>\r\n                      </div>\r\n"
	+ "                      </td>\r\n                    </tr>\r\n\r\n                    <tr><td height='28'></td></tr>\r\n                </table>\r\n              </div>\r\n\r\n              <!--  =========================== The footer ===========================  -->\r\n      </td>\r\n    </tr>   \r\n\r\n    \r\n\r\n      <tr><td height='28'>&nbsp;</td></tr>\r\n\r\n    </table>\r\n  </td>\r\n  <td height='130' bgcolor='#022544'>&nbsp;</td>\r\n</tr>\r\n\r\n<tr>\r\n  <td class='bgBody'>  &nbsp;</td>\r\n  <td class='bgBody'>  &nbsp;</td>\r\n</tr>\r\n\r\n\r\n\r\n\r\n</table>\r\n"
	+ "</body>\r\n"
	+ "</html>\r\n";	
	
	public Message composeCheckout(EmailTransaction emailTx) throws UnsupportedEncodingException, MessagingException {
		String pdfString = emailTx.pdf;
		byte[] decoded = null;
		String partSeparator = ",";
		if (pdfString.contains(partSeparator)) {
			pdfString = pdfString.split(partSeparator)[1];
		}
		decoded = Base64.getDecoder().decode(pdfString);
        Session session = createSession(SMTP_USERNAME, SMTP_PASSWORD, SMTP_HOST, SMTP_PORT);
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(CHECKOUT_EMAIL_FROM_ADDRESS, CHECKOUT_EMAIL_PERSONAL));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTx.email));
		message.setSubject(CHECKOUT_EMAIL_SUBJECT);
		String text = createCheckoutMessage(emailTx.itemName, emailTx.returnDay, emailTx.returnTime, LIBRARY_NAME, LIBRARY_PHONE);
		String html = createEmail(text, BANNER, HOME_PAGE, FB_LINK, FB_ICON, TWITTER_LINK, TWITTER_ICON, LIBRARY_NAME);
		message.setContent(html, "text/html; charset=utf-8");
		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(html, "text/html; charset=utf-8");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		messageBodyPart = new MimeBodyPart();
		ByteArrayDataSource source = new ByteArrayDataSource(decoded, "application/pdf");
		messageBodyPart.setDataHandler(new DataHandler(source));
		messageBodyPart.setFileName(CHECKOUT_EMAIL_PDF_NAME);
		multipart.addBodyPart(messageBodyPart);
		message.setContent(multipart);
		return message;
	}

	public Message composeCheckinEmail(String email, String item, String pdf) throws MessagingException, UnsupportedEncodingException {
		String pdfString = pdf;
		byte[] decoded = null;
		String partSeparator = ",";
		if (pdfString.contains(partSeparator)) {
			pdfString = pdfString.split(partSeparator)[1];
		}
		decoded = Base64.getDecoder().decode(pdfString);
        Session session = createSession(SMTP_USERNAME, SMTP_PASSWORD, SMTP_HOST, SMTP_PORT);
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(CHECKIN_EMAIL_FROM_ADDRESS, CHECKIN_EMAIL_PERSONAL));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
		message.setSubject(CHECKIN_EMAIL_SUBJECT);
		String text = createCheckinMessage(item, LIBRARY_PHONE);
		String html = createEmail(text, BANNER, HOME_PAGE, FB_LINK, FB_ICON, TWITTER_LINK, TWITTER_ICON, LIBRARY_NAME);
		message.setContent(html, "text/html; charset=utf-8");
		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(html, "text/html; charset=utf-8");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		messageBodyPart = new MimeBodyPart();
		ByteArrayDataSource source = new ByteArrayDataSource(decoded, "application/pdf");
		messageBodyPart.setDataHandler(new DataHandler(source));
		messageBodyPart.setFileName(CHECKIN_EMAIL_PDF_NAME);
		multipart.addBodyPart(messageBodyPart);
		message.setContent(multipart);
		return message;
	}

	private String createCheckinMessage(String itemName, String libraryPhone) {
		String message = CHECKIN_EMAIL_MSG_TEMPLATE;
		message = message.replace("@@ITEMNAME@@", itemName);
		message = message.replace("@@LIBRARY_PHONE@@", libraryPhone);
		return message;
	}

	private String createCheckoutMessage(String itemName, String date, String time, String libraryName, String libraryPhone) {
		String message = CHECKOUT_MSG_TEMPLATE;
		message = message.replace("@@ITEMNAME@@", itemName);
		message = message.replace("@@DATE@@", date);
		message = message.replace("@@TIME@@", time);
		message = message.replace("@@LIBRARY_NAME@@", libraryName);
		message = message.replace("@@LIBRARY_PHONE@@", libraryPhone);
		return message;
	}

	private String createEmail(String message, String banner, String homePage, String fbLink, String fbIcon, String twitterLink, String twitterIcon, String libraryName) {
		String html = EMAIL_TEMPLATE;
		html = html.replace("@@MESSAGE@@", message);
		html = html.replace("@@BANNER@@", banner);
		html = html.replace("@@HOME_PAGE@@", homePage);
		html = html.replace("@@FB_LINK@@", fbLink);
		html = html.replace("@@FB_ICON@@", fbIcon);
		html = html.replace("@@TWITTER_LINK@@", twitterLink);
		html = html.replace("@@TWITTER_ICON@@", twitterIcon);
		html = html.replace("@@LIBRARY_NAME@@", libraryName);
		return html;
	}

	private Session createSession(String username, String password, String host, String port) {
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        Authenticator authenticator = new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };
        return Session.getInstance(props, authenticator);
    }
}
