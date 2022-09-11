package com.devsuperior.dsmeta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {

  // todas essas informações que estão dentro dos "values", são os nomes das
  // variáveis de ambiente do twilio que colocamos no application.properties
  private String twilioSid = "ACad67e7f8ef364b68d5ae732871c5cd11";

  private String twilioKey = "3ea6b121cea37cd631ec416ec8951e06";

  private String twilioPhoneFrom = "+17817761698";

  private String twilioPhoneTo = "+5571996622763";

  @Autowired
  private SaleRepository repository;

  public void sendSms(Long saleId) {

    Sale sale = repository.findById(saleId).get();

    String msg = String.format(
        "O vendedor %s foi destaque em %s/%s/%s com um total de R$ %.2f",
        sale.getSellerName(),
        sale.getDate().getDayOfMonth(),
        sale.getDate().getMonthValue(),
        sale.getDate().getYear(),
        sale.getAmount());

    Twilio.init(twilioSid, twilioKey);

    PhoneNumber to = new PhoneNumber(twilioPhoneTo);
    PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

    Message message = Message.creator(to, from, msg).create();

    System.out.println(message.getSid());
  }
}