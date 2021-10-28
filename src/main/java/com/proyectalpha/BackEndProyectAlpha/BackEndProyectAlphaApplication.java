package com.proyectalpha.BackEndProyectAlpha;

import com.proyectalpha.BackEndProyectAlpha.models.Offer;
import com.proyectalpha.BackEndProyectAlpha.models.Technology;
import com.proyectalpha.BackEndProyectAlpha.repositories.OffersRepository;
import com.proyectalpha.BackEndProyectAlpha.repositories.TechnologyRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class BackEndProyectAlphaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BackEndProyectAlphaApplication.class, args);
		OffersRepository offerRepository = context.getBean(OffersRepository.class);

		//Configuration demoConfig = new Configuration(null, "demoSalary", "remoto", new Date(), "demoLocation");
		Technology demoTech = new Technology(null, "javascript");
		Technology demoTech1 = new Technology(null, "react");

		Offer demoOffers = new Offer(null, "demoEnterprise", "demoOffer", "demoResponsibility", "demoRequeriments", "demoSummary", "demoSalary", "demoModality", new Date(), "demoLocation");
		Offer demoOffers1 = new Offer(null, "demoEnterprise1", "demoOffer1", "demoResponsibility1", "demoRequeriments1", "demoSummary1", "demoSalary1", "demoModality1", new Date(), "demoLocation1");

		demoOffers.addTechnologies(demoTech);
		demoOffers1.addTechnologies(demoTech);
		demoOffers1.addTechnologies(demoTech1);

		offerRepository.save(demoOffers);
		offerRepository.save(demoOffers1);

		System.out.println(offerRepository.findAll().size());


	}

}
