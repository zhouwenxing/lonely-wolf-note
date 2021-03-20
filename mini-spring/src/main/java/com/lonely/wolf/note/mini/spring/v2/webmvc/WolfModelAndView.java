package com.lonely.wolf.note.mini.spring.v2.webmvc;

import java.util.Map;

/**
 * @author zwx
 * @version 1.0
 * @date 2021/2/15
 * @since jdk1.8
 */
public class WolfModelAndView {

    private String viewName;
    private Map<String,?> model;

    public WolfModelAndView(String viewName) {
        this.viewName = viewName;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public Map<String, ?> getModel() {
        return model;
    }

    public void setModel(Map<String, ?> model) {
        this.model = model;
    }
}
