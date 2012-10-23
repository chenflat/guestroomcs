package com.managementsystem.guestroom.web;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.managementsystem.guestroom.domain.Breadcrumb;

public abstract class AbstractController {

	private final Log logger = LogFactory.getLog(AbstractController.class);

	protected abstract String getModelViewName();

	protected abstract List<Breadcrumb> getBreadcrumbs();

}
