package com.pasadya;

import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends PasadyaBasePage {
	private static final long serialVersionUID = 1L;
	Logger log = LoggerFactory.getLogger(PasadyaBasePage.class);

    public HomePage(final PageParameters parameters) {
//    	add(new Image("mainPageTopTree", new Model<String>("assets/images/mainTree.png")));
    	add(new Image("mainPageImage", new Model<String>("assets/images/BrandNew.png")));
//    	add(new Image("treeLeftImage", new Model<String>("assets/images/treeLeft.png")));
    	
    
    	
    }
}
