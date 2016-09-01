package org.git.spring.controller;

import java.util.List;

import org.git.spring.dao.EmployeeCertDAOImpl;
import org.git.spring.model.Certification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/certificates")
public class CertificationTrackerControllerREST {
	@Autowired
	private EmployeeCertDAOImpl employeeCertDAOImpl;

	@RequestMapping(value = "/{certID}", method = RequestMethod.GET
	// ,headers={"content-type=application/xml,application/json"}
			, produces = "application/json")
	@ResponseBody
	public Certification getCertificationRest(@PathVariable("certID") int certID) {
		return employeeCertDAOImpl.getCertification(certID);
	}

	@RequestMapping(method = RequestMethod.GET)
	// ,headers={"content-type=application/xml,application/json"}
			//, produces = "application/json")
	@ResponseBody
	public List<Certification> listAllCertificationsRest() {
		return employeeCertDAOImpl.getAllCertifications();
	}
	
	@RequestMapping(value= "/{certID}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCertRest(@PathVariable int certID){
		employeeCertDAOImpl.removeCertification(certID);
	}
}
 