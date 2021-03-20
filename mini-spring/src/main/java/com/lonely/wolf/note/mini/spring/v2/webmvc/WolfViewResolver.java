package com.lonely.wolf.note.mini.spring.v2.webmvc;

import java.io.File;
import java.util.Locale;

/**
 * @author zwx
 * @version 1.0
 * @date 2021/2/15
 * @since jdk1.8
 */
public class WolfViewResolver {

    private final String DEFAULT_TEMPLATE_SUFFX = ".html";
    private File template;

    public WolfViewResolver(String templateRootDir) {
        String templateRootPath = this.getClass().getClassLoader().getResource(templateRootDir).getFile();
        template = new File(templateRootPath);
    }

    public WolfView resolveViewName(String viewName){
        if(null == viewName || "".equals(viewName.trim())){return null;}
        viewName = viewName.endsWith(DEFAULT_TEMPLATE_SUFFX) ? viewName : (viewName + DEFAULT_TEMPLATE_SUFFX);
        File templateFile = new File((template.getPath() + "/" + viewName).replaceAll("/+","/"));
        return new WolfView(templateFile);
    }
}
