package com.jeroenreijn.examples.view;

import liqp.ProtectionSettings;
import liqp.Template;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.view.AbstractTemplateView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Locale;
import java.util.Map;

@Slf4j
public class LiqpView extends AbstractTemplateView {
    @Override
    protected void renderMergedTemplateModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        File templateFile = ResourceUtils.getFile(getUrl());
        if (templateFile.exists()) {
            model.remove("springMacroRequestContext");
            model.remove("org.springframework.validation.BindingResult.i18n");
            model.remove("i18n");
            String rendered = Template.parse(templateFile).render(model);
            response.getWriter().write(rendered);
        } else {
            log.info("Not Found:" + getUrl());
        }
    }

    @Override
    public boolean checkResource(Locale locale) throws Exception {
        log.debug(getUrl());
        return getUrl().endsWith(".liqp");
    }

    @Override
    protected void initServletContext(ServletContext servletContext) throws BeansException {
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.debug(getUrl());
    }
}
