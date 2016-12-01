package com.hb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.dodo.model.GuestVo;
import com.hb.model.GuestDao;

public class UpdateController extends AbstractCommandController {

	private GuestDao dao;
	
	public void setDao(GuestDao dao) {
		this.dao = dao;
	}
	
	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException bindException)
			throws Exception {
		
		dao.updateOne((GuestVo) command);
		
		return new ModelAndView("redirect:list.hb");
	}

}
